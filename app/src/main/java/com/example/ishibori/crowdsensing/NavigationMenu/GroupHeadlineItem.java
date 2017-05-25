package com.example.ishibori.crowdsensing.navigationmenu;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishibori.crowdsensing.R;

import DataSource.DataSource;
import Utils.LayoutUtils;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class GroupHeadlineItem extends CustomMenuItem{
    String title;

    public GroupHeadlineItem(ItemType menuItemType, String title){
        this.menuItemType = menuItemType;
        this.title = title;
    }

    @Override
    public View getView(LayoutInflater inflater){
        View v = inflater.inflate(R.layout.menu_item_group_headline, null);

        TextView text = (TextView) v.findViewById(R.id.menu_text);
        text.setText(title);
        text.setTextColor(LayoutUtils.getColorFromId(DataSource.globalContext, R.color.darkWhite));

        LinearLayout cellLayout = (LinearLayout) v.findViewById(R.id.menu_item_group_headline);
        cellLayout.setBackgroundColor(LayoutUtils.getColorFromId(DataSource.globalContext, R.color.middleGray));

        return v;
    }
}
