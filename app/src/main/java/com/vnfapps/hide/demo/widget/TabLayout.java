package com.vnfapps.hide.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.vnfapps.hide.demo.base.BaseEntity;

/**
 * Created by Hide on 3/2/2016.
 */
public class TabLayout extends android.support.design.widget.TabLayout {
    //****************************************************************
    //* Variables
    //****************************************************************
    public static final String TAG = TabLayout.class.getName();

    //****************************************************************
    //* Constructors
    //****************************************************************
    public TabLayout(Context context) {
        super(context);
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //****************************************************************
    //* Override/Implement functions
    //****************************************************************

    //****************************************************************
    //* Functions
    //****************************************************************
    public void setTabItemCustomView(TabView tabView, int startPos, int endPos) {
        int start = Math.max(startPos, 0);
        int end = Math.min(getTabCount(), endPos);
        for (int i = start; i < end; i++) {
            Tab tab = getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabView.mView);
            }
        }
    }


    //****************************************************************
    //* Inner classes
    //****************************************************************
    public static abstract class TabView<T extends BaseEntity> {
        protected View mView;
        Context mContext;

        public TabView(Context context) {
            this.mContext = context;
        }

        public View getRootView() {
            return mView;
        }

        public abstract void bindData(T tabItemData);
    }
}
