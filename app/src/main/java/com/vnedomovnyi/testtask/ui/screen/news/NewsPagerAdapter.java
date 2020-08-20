package com.vnedomovnyi.testtask.ui.screen.news;

import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.vnedomovnyi.testtask.R;
import com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news.LifestyleNewsFragment;
import com.vnedomovnyi.testtask.ui.screen.news.other_news.OtherNewsFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.SneakyThrows;
import lombok.Value;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    public static final List<FragmentInfo> FRAGMENT_INFOS = new ArrayList<FragmentInfo>() {
        {
            add(new FragmentInfo(LifestyleNewsFragment::newInstance, R.string.lifestyle_news_title));
            add(new FragmentInfo(OtherNewsFragment::newInstance, R.string.other_news_title));
        }
    };

    private final Resources resources;

    public NewsPagerAdapter(@NonNull FragmentManager fm, Resources resources) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.resources = resources;
    }

    @SneakyThrows
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FRAGMENT_INFOS.get(position).creatingCallable.call();
    }

    @Override
    public int getCount() {
        return FRAGMENT_INFOS.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return resources.getString(FRAGMENT_INFOS.get(position).titleResId);
    }

    @Value
    public static class FragmentInfo {

        Callable<Fragment> creatingCallable;

        @StringRes
        int titleResId;

    }

}
