package com.spsz.zrodo.njspsz.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GuidePages extends PagerAdapter {
    private ArrayList<View> listViews;

    public GuidePages() {
    }

    public GuidePages(ArrayList<View> listViews) {
        this.listViews = listViews;
    }

    @Override
    public int getCount() {
        return listViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listViews.get(position));
        return listViews.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(listViews.get(position));
    }
}
