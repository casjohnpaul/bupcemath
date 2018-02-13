package com.bupc.emath;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.bupc.emath.fragment.AboutFragment;
import com.bupc.emath.fragment.HomeFragment;
import com.bupc.emath.fragment.QuizFragment;
import com.bupc.emath.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int HOME_FRAGMENT = 0;
    public static final int ABOUT_FRAGMENT = 1;
    public static final int SETTING_FRAGMENT = 2;

    private List<Fragment> fragments = new ArrayList<>();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    displayView(HOME_FRAGMENT);
                    return true;
                case R.id.navigation_about:
                    displayView(ABOUT_FRAGMENT);
                    return true;
                case R.id.navigation_settings:
                    displayView(SETTING_FRAGMENT);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments.add(HomeFragment.newInstance());
        fragments.add(AboutFragment.newInstance());
        fragments.add(SettingFragment.newInstance());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        displayView(HOME_FRAGMENT);
    }

    public void displayView(int viewIndex) {

        Fragment fragment = fragments.get(viewIndex);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        ft.replace(R.id.flMainContainer, fragment);
        ft.commit();
    }

}
