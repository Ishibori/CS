package com.example.ishibori.crowdsensing.navigationmenu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ishibori.crowdsensing.R;

import java.util.ArrayList;

import Utils.LayoutUtils;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class CustomMenuItemAdapter extends BaseAdapter {
    Context context;
    private static LayoutInflater inflater = null;

    public ArrayList<CustomMenuItem> menuItems;

    public CustomMenuItemAdapter(Context context, ArrayList<CustomMenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (menuItems != null)
            return menuItems.size();

        return 0;
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CustomMenuItem currentItem = menuItems.get(position);
        View rowView = currentItem.getView(inflater);

        if (rowView != null) {
            rowView.setBackgroundColor(LayoutUtils.getColorFromId(context, R.color.darkGray));
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You Clicked " + position, Toast.LENGTH_LONG).show();
                }
            });
        }

        return rowView;
    }
}
