package com.example.ishibori.crowdsensing.navigationmenu;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishibori.crowdsensing.R;

import DataSource.DataSource;
import Utils.LayoutUtils;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class StandardItem extends CustomMenuItem {
    Bitmap icon;
    String title;
    int counter;

    public StandardItem(ItemType menuItemType, Bitmap icon, String title, int counter, boolean showRightCounter){
        this.menuItemType = menuItemType;
        this.icon = icon;
        this.title = title;
        this.counter = counter;
        this.showRightCounter = showRightCounter;
    }

    public StandardItem(ItemType menuItemType, Bitmap icon, String title){
        this.menuItemType = menuItemType;
        this.icon = icon;
        this.title = title;
    }

    @Override
    public View getView(LayoutInflater inflater){
        View rowView = inflater.inflate(R.layout.menu_item_standard_item, null);

        ImageView imgIcon = (ImageView) rowView.findViewById(R.id.menu_icon);
        TextView text = (TextView) rowView.findViewById(R.id.menu_text);
        TextView txtCounter = (TextView) rowView.findViewById(R.id.menu_counter);

        imgIcon.setImageBitmap(icon);
        imgIcon.setColorFilter(Color.parseColor("#BBBBBB"), PorterDuff.Mode.SRC_ATOP);

        text.setText(title);
        text.setTextColor(LayoutUtils.getColorFromId(DataSource.globalContext, R.color.darkWhite));

        if (showRightCounter) {
            String counterStr = counter > 999 ? "999+" : Integer.toString(counter);
            txtCounter.setText(counterStr);
            txtCounter.setTextColor(LayoutUtils.getColorFromId(DataSource.globalContext, R.color.white));
            txtCounter.setVisibility(View.VISIBLE);
        } else {
            txtCounter.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }


}
