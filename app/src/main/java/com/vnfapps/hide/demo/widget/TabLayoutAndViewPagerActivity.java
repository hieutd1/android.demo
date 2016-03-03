package com.vnfapps.hide.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.vnfapps.hide.demo.R;
import com.vnfapps.hide.demo.widget.viewholder.TabLayoutAndViewPagerViewHolder;

/**
 * Created by hieut_000 on 2/23/2016.
 */
public class TabLayoutAndViewPagerActivity extends AppCompatActivity {
    TabLayoutAndViewPagerViewHolder holder;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mn_tab_layout_and_view_pager, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.mn_normal:
                holder.removeTabItemCustomView(0, holder.tabLayout.getTabCount());
                break;
            case R.id.mn_custom_tab_view:
                holder.setTabItemCustomView(0, holder.tabLayout.getTabCount());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.translate_left_in, R.anim.translate_left_out);
    }

    private void init() {
        holder = new TabLayoutAndViewPagerViewHolder(this, findViewById(R.id.container));
    }
}
