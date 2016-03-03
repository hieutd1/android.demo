package com.vnfapps.hide.demo.widget.viewholder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vnfapps.hide.demo.R;
import com.vnfapps.hide.demo.widget.TabLayout;
import com.vnfapps.hide.demo.widget.TabLayoutAndViewPagerActivity;
import com.vnfapps.hide.demo.widget.adapter.DefaultPagerAdapter;
import com.vnfapps.hide.demo.widget.tablayout.CustomTabItem;

/**
 * Created by Hide on 2/29/2016.
 */
public class TabLayoutAndViewPagerViewHolder {
    private final Context context;
    private final View root;
    public ActionBar actionBar;
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public DefaultPagerAdapter defaultPagerAdapter;

    public TabLayoutAndViewPagerViewHolder(Context context, View root) {
        this.context = context;
        this.root = root;
        actionBar = ((AppCompatActivity) context).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(TabLayoutAndViewPagerActivity.class.getSimpleName());
//                actionBar.setWindowTitle(TabLayoutAndViewPagerActivity.class.getSimpleName());
        }
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        defaultPagerAdapter = new DefaultPagerAdapter(context);
        defaultPagerAdapter.addItem(R.string.mn_tab_layout_and_view_pager_normal, R.layout.default_view_pager_list_item);
        defaultPagerAdapter.addItem(R.string.mn_tab_layout_and_view_pager_custom_tab_view, R.layout.default_view_pager_list_item);
        viewPager.setAdapter(defaultPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setTabItemCustomView(int startPos, int endPos) {
        int start = Math.max(startPos, 0);
        int end = Math.min(tabLayout.getTabCount(), endPos);
        for (int i = start; i < end; i++) {
            CustomTabItem customTabItem = tabLayout.setTabItemCustomView(new CustomTabItem(context), i);
            if (customTabItem != null) {
                CustomTabItem.ItemData itemData = new CustomTabItem.ItemData();
                itemData.title = defaultPagerAdapter.getPageTitle(i).toString();
                itemData.iconResId = R.drawable.ic_tab_item;
                customTabItem.bindData(itemData);
                if (i == tabLayout.getSelectedTabPosition()) {
                    customTabItem.getRootView().setSelected(true);
                }
            }
        }

    }

    public void removeTabItemCustomView(int startPos, int endPos) {
        int start = Math.max(startPos, 0);
        int end = Math.min(tabLayout.getTabCount(), endPos);
        for (int i = start; i < end; i++) {
            tabLayout.setTabItemCustomView(null, i);
        }
    }

}
