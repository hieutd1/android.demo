package com.vnfapps.hide.demo.widget.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.vnfapps.hide.demo.R;
import com.vnfapps.hide.demo.base.BaseEntity;
import com.vnfapps.hide.demo.widget.TabLayout;

/**
 * Created by Hide on 3/2/2016.
 */
public class CustomTabItem extends TabLayout.TabView<CustomTabItem.ItemData> {
    //****************************************************************
    //* Variables
    //****************************************************************
    ImageView mIcon;
    TextView mTitle;

    public CustomTabItem(Context context, ItemData data) {
        super(context);
        mView = LayoutInflater.from(context).inflate(R.layout.custom_tab_item, null);
        mIcon = (ImageView) mView.findViewById(R.id.icon);
        mTitle = (TextView) mView.findViewById(R.id.title);
        bindData(data);
    }

    @Override
    public void bindData(ItemData tabItemData) {
        mIcon.setImageResource(tabItemData.iconResId);
        mTitle.setText(tabItemData.title);
    }


    public class ItemData extends BaseEntity {
        public int iconResId;
        public String title;
    }

}
