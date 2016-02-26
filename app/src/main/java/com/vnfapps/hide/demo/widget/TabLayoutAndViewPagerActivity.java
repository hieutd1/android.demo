package com.vnfapps.hide.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vnfapps.hide.demo.R;
import com.vnfapps.hide.demo.widget.Adapter.DefaultPagerAdapter;

/**
 * Created by hieut_000 on 2/23/2016.
 */
public class TabLayoutAndViewPagerActivity extends AppCompatActivity {
    ViewHolder holder;

    public static void start(Context context) {
        Intent starter = new Intent(context, TabLayoutAndViewPagerActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_and_viewpager);
        init();
    }


    private void init() {
        holder = new ViewHolder();
    }

    private class ViewHolder {
        public ActionBar actionBar;
        public TabLayout tabLayout;
        public ViewPager viewPager;
        public DefaultPagerAdapter defaultPagerAdapter;

        public ViewHolder() {
            actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setWindowTitle(TabLayoutAndViewPagerActivity.class.getSimpleName());
            }
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            defaultPagerAdapter = new DefaultPagerAdapter(TabLayoutAndViewPagerActivity.this);
            viewPager.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return 0;
                }



                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return false;
                }
            });
        }
    }
}
