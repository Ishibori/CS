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
        View rowView = null;

        switch (currentItem.menuItemType) {
            case GroupHeadline: {
                rowView = setGroupHeadline(rowView, currentItem);
                break;
            }
            case StandardItem: {
                rowView = setStandardItem(rowView, currentItem);
                break;
            }
            case HorizontalMenu: {
                rowView = setHorizontalMenu(rowView, currentItem);
                break;
            }
        }

        if (rowView != null) {
            rowView.setBackgroundColor(getColorFromId(R.color.darkGray));
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You Clicked " + position, Toast.LENGTH_LONG).show();
                }
            });
        }

        return rowView;
    }

    public View setGroupHeadline(View rowView, CustomMenuItem currentItem) {
        rowView = inflater.inflate(R.layout.menu_item_group_headline, null);
        GroupHeadlineItem item = (GroupHeadlineItem) currentItem;

        TextView text = (TextView) rowView.findViewById(R.id.menu_text);
        text.setText(item.title);
        text.setTextColor(getColorFromId(R.color.darkWhite));

        LinearLayout cellLayout = (LinearLayout) rowView.findViewById(R.id.menu_item_group_headline);
        cellLayout.setBackgroundColor(getColorFromId(R.color.middleGray));

        return rowView;
    }

    public View setStandardItem(View rowView, CustomMenuItem currentItem) {
        rowView = inflater.inflate(R.layout.menu_item_standard_item, null);
        StandardItem standardItem = (StandardItem) currentItem;

        ImageView icon = (ImageView) rowView.findViewById(R.id.menu_icon);
        TextView text = (TextView) rowView.findViewById(R.id.menu_text);
        TextView counter = (TextView) rowView.findViewById(R.id.menu_counter);

        icon.setImageBitmap(standardItem.icon);
        icon.setColorFilter(Color.parseColor("#BBBBBB"), PorterDuff.Mode.SRC_ATOP);

        text.setText(standardItem.title);
        text.setTextColor(getColorFromId(R.color.darkWhite));

        if (standardItem.showRightCounter) {
            String counterStr = standardItem.counter > 999 ? "999+" : Integer.toString(standardItem.counter);
            counter.setText(counterStr);
            counter.setTextColor(getColorFromId(R.color.white));
            counter.setVisibility(View.VISIBLE);
        } else {
            counter.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

    public View setHorizontalMenu(View rowView, CustomMenuItem currentItem) {
        rowView = inflater.inflate(R.layout.menu_item_horizontal_menu, null);
        HorizontalMenuItem item = (HorizontalMenuItem) currentItem;

        ImageView icon1 = (ImageView) rowView.findViewById(R.id.nav_item1_icon);
        ImageView icon2 = (ImageView) rowView.findViewById(R.id.nav_item2_icon);
        ImageView icon3 = (ImageView) rowView.findViewById(R.id.nav_item3_icon);

        TextView text1 = (TextView) rowView.findViewById(R.id.nav_item1_text);
        TextView text2 = (TextView) rowView.findViewById(R.id.nav_item2_text);
        TextView text3 = (TextView) rowView.findViewById(R.id.nav_item3_text);

        text1.setText(item.titles.get(0));
        icon1.setImageBitmap(item.icons.get(0));

        text2.setText(item.titles.get(1));
        icon2.setImageBitmap(item.icons.get(1));

        text3.setText(item.titles.get(2));
        icon3.setImageBitmap(item.icons.get(2));

        return rowView;
    }

    public int getColorFromId(int colorId) {
        return ResourcesCompat.getColor(context.getResources(), colorId, null);
    }
}
