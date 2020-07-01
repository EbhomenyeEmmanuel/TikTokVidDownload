package com.esq.tiktokviddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.esq.tiktokviddownload.ui.DownloadFragment;
import com.esq.tiktokviddownload.ui.HomeFragment;

public class HomeAdapter extends FragmentPagerAdapter {

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    private String[] title = {"Home", "Downloads"};

    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = HomeFragment.newInstance(position);
                break;
            case 1:
                fragment = DownloadFragment.newInstance(position);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
