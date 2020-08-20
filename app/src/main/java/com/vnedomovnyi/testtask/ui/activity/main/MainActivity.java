package com.vnedomovnyi.testtask.ui.activity.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vnedomovnyi.testtask.R;
import com.vnedomovnyi.testtask.ui.screen.general.GeneralFragment;
import com.vnedomovnyi.testtask.ui.screen.news.NewsFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MainActivity extends AppCompatActivity implements HasAndroidInjector {

    public static final int FULLSCREEN_FRAGMENT_CONTAINER_ID = R.id.fullscreen_fragment_container;

    @Inject
    DispatchingAndroidInjector<Object> injector;

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation(savedInstanceState);
    }

    private void setupBottomNavigation(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            showScreen(R.id.generalFragment);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            showScreen(menuItem.getItemId());
            return true;
        });
    }

    private void showScreen(int screenId) {
        String tag = getTag(screenId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = null;

        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.isVisible()) {
                currentFragment = fragment;
                break;
            }
        }

        Fragment newFragment = fragmentManager.findFragmentByTag(tag);

        if (currentFragment != null && currentFragment.equals(newFragment)) {
            return;
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (currentFragment == null) {
            for (Fragment fragment : fragmentManager.getFragments()) {
                transaction.hide(fragment);
            }
        } else {
            transaction.hide(currentFragment);
        }

        if (newFragment == null) {
            transaction.add(R.id.fragment_container, createFragment(screenId), tag);
        } else {
            transaction.show(newFragment);
        }

        transaction.commitNow();
    }

    private String getTag(int screenId) {
        return String.valueOf(screenId);
    }

    private Fragment createFragment(int screenId) {
        switch (screenId) {
            case R.id.generalFragment:
                return GeneralFragment.newInstance();
            case R.id.newsFragment:
                return NewsFragment.newInstance();
            default:
                throw new IllegalArgumentException("Illegal screenId = " + screenId);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return injector;
    }

}