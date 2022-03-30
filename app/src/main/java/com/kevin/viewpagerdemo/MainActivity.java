package com.kevin.viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    Integer[] items = new Integer[]{1, 2, 3, 4, 5};
    private ArrayList<Integer> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.main_viewpager);
        createData(100);
        viewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, arrayList));
        viewPager.addOnPageChangeListener(this);
    }

    private void createData(int size) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(getRandomNumber());
        }

    }

    private Integer getRandomNumber() {
        return items[(int) Math.floor(Math.random() * items.length)];
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public static class MainFragmentAdapter extends FragmentStatePagerAdapter {

        private final ArrayList<Integer> mList;

        public MainFragmentAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Integer> arrayList) {
            super(fm, behavior);
            mList = arrayList;
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return MainFragment.newInstance(mList.get(position), position);
        }


        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

    }

}