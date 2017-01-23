package com.example.ishibori.crowdsensing.navigationmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ishibori.crowdsensing.R;

import java.util.ArrayList;

import static com.example.ishibori.crowdsensing.navigationmenu.CustomMenuItem.ItemType.Group_Headline;
import static com.example.ishibori.crowdsensing.navigationmenu.CustomMenuItem.ItemType.Icon_Title;

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
            case Group_Headline: {
                rowView = inflater.inflate(R.layout.menu_item_group_headline, null);
                TextView text = (TextView) rowView.findViewById(R.id.menu_text);
                text.setText(((GroupHeadlineItem) currentItem).title);
            }
            break;
            case Icon_Title: {
                rowView = inflater.inflate(R.layout.menu_item_icon_title, null);
                ImageView icon = (ImageView) rowView.findViewById(R.id.menu_icon);
                TextView text = (TextView) rowView.findViewById(R.id.menu_text);
                text.setText(((StandardItem) currentItem).title);

                icon.setImageBitmap(((StandardItem) currentItem).icon);
            }
            break;
            case Horizontal_Menu: {
                rowView = inflater.inflate(R.layout.menu_item_horizontal_menu, null);
                ImageView icon1 = (ImageView) rowView.findViewById(R.id.nav_item1_icon);
                ImageView icon2 = (ImageView) rowView.findViewById(R.id.nav_item2_icon);
                ImageView icon3 = (ImageView) rowView.findViewById(R.id.nav_item3_icon);

                TextView text1 = (TextView) rowView.findViewById(R.id.nav_item1_text);
                TextView text2 = (TextView) rowView.findViewById(R.id.nav_item2_text);
                TextView text3 = (TextView) rowView.findViewById(R.id.nav_item3_text);

                text1.setText(((HorizontalMenuItem) currentItem).titles.get(0));
                icon1.setImageBitmap(((HorizontalMenuItem) currentItem).icons.get(0));

                text2.setText(((HorizontalMenuItem) currentItem).titles.get(1));
                icon2.setImageBitmap(((HorizontalMenuItem) currentItem).icons.get(1));

                text3.setText(((HorizontalMenuItem) currentItem).titles.get(2));
                icon3.setImageBitmap(((HorizontalMenuItem) currentItem).icons.get(2));

                break;
            }
        }

        if(rowView != null) {
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
