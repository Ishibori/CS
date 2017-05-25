package com.example.ishibori.crowdsensing.navigationmenu;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ishibori.crowdsensing.R;

import java.util.ArrayList;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class HorizontalMenuItem extends CustomMenuItem {
    ArrayList<String> titles;
    ArrayList<Bitmap> icons;

    public HorizontalMenuItem(ItemType menuItemType, ArrayList<String> titles, ArrayList<Bitmap> icons){
        this.menuItemType = menuItemType;
        this.titles = titles;
        this.icons = icons;
    }

    /*public View setHorizontalMenu(View rowView, CustomMenuItem currentItem) {
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
    }*/
}
