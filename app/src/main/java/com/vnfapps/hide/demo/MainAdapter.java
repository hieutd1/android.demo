package com.vnfapps.hide.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vnfapps.hide.demo.widget.TabLayoutAndViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hieut_000 on 2/23/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private final List<Item> data = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
        data.add(new Item(TabLayoutAndViewPager.class));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = data.get(position).name;
        holder.name.setText(name);
        OnItemClickListener listener = new OnItemClickListener(data.get(position));
        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.itemName);
        }
    }

    public class OnItemClickListener implements View.OnClickListener{
        Item item;

        public OnItemClickListener(Item item) {
            this.item = item;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, item.aClass);
            context.startActivity(intent);
        }
    }

    public class Item {
        public Class aClass;
        public String name;

        public Item(Class aClass) {
            this.aClass = aClass;
            this.name = aClass.getSimpleName();
        }
    }
}
