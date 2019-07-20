package org.appslash.payslash;

import android.content.ClipData;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class dashboard extends AppCompatActivity implements settingsFragment.OnFragmentInteractionListener,
                                                            notificationsFragment.OnFragmentInteractionListener,
                                                            dashboardFragment.OnFragmentInteractionListener,
                                                            qrscannerFragment.OnFragmentInteractionListener{
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    final Fragment settingsFragment = new settingsFragment();
    final Fragment dashboardFragment = new dashboardFragment();
    final Fragment notificationsFragment = new notificationsFragment();
    final Fragment qrscannerFragment = new qrscannerFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = dashboardFragment;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_settings:
                    fm.beginTransaction().hide(active).show(settingsFragment).commit();
                    active = settingsFragment;

                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().hide(active).show(dashboardFragment).commit();
                    active = dashboardFragment;
                    return true;
                case R.id.navigation_qrscan:
                    fm.beginTransaction().hide(active).show(qrscannerFragment).commit();
                    active = qrscannerFragment;
                    return true;
                case R.id.navigation_notifications:
                    fm.beginTransaction().hide(active).show(notificationsFragment).commit();
                    active = notificationsFragment;
                    return true;
                case R.id.navigation_exit:
                    //mTextMessage.setText(R.string.title_exit);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mTextMessage = (TextView) findViewById(R.id.message);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().add(R.id.main_container,settingsFragment).hide(settingsFragment).commit();
        fm.beginTransaction().add(R.id.main_container,notificationsFragment).hide(notificationsFragment).commit();
        fm.beginTransaction().add(R.id.main_container,qrscannerFragment).hide(qrscannerFragment).commit();
        fm.beginTransaction().add(R.id.main_container,active).show(active).commit();
    }

}
