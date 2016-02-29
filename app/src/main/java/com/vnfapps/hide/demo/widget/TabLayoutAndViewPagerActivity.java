package com.vnfapps.hide.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
                setTabItemCustomView(null, 0, 999);
                break;
            case R.id.mn_custom_tab_view:
                setTabItemCustomView(R.layout.custom_tab_item, 0, 999);
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

    public void setTabItemCustomView(int layoutResId, int startPos, int endPos) {
        View view = LayoutInflater.from(this).inflate(layoutResId, null);
        setTabItemCustomView(view, startPos, endPos);

    }

    public void setTabItemCustomView(View view, int startPos, int endPos) {
        holder.setTabItemCustomView(view, startPos, endPos);

    }

}
