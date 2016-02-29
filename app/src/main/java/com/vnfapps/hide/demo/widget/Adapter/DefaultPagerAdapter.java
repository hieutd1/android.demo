package com.vnfapps.hide.demo.widget.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vnfapps.hide.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hide on 2/25/2016.
 */
public class DefaultPagerAdapter extends PagerAdapter {
    //****************************************************************
    //* Variables
    //****************************************************************
    public static final String TAG = DefaultPagerAdapter.class.getName();
    private final List<Item> dataList = new ArrayList<>();
    private Context mContext;

    //****************************************************************
    //* Constructors
    //****************************************************************
    public DefaultPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //****************************************************************
    //* Override/Implement functions
    //****************************************************************
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try {
            Item item = dataList.get(position);
            if (item.view == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                item.view = inflater.inflate(item.layoutResId, container, false);
                TextView textView = (TextView) item.view.findViewById(R.id.text);
                textView.setText(item.title);
            }
            container.addView(item.view);
            return item.view;
        } catch (Exception e) {
            e.printStackTrace();
            return new View(mContext);
        }

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Item item = dataList.get(position);
        if (item.view != null && item.view == object) {
            container.removeView((View) object);
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return dataList.get(position).title;
    }

    //****************************************************************
    //* Functions
    //****************************************************************
    public void addItem(String title, int layoutResId) {
        Item item = new Item();
        item.title = title;
        item.layoutResId = layoutResId;
        dataList.add(item);
    }

    public void addItem(int titleResId, int layoutResId) {
        Item item = new Item();
        item.layoutResId = titleResId;
        String title = mContext.getString(titleResId);
        addItem(title, layoutResId);
    }

    //****************************************************************
    //* Inner classes
    //****************************************************************
    public static class Item {
        public int titleResId;
        public String title;
        public int layoutResId;
        public View view;
    }
}
