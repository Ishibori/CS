package com.example.ishibori.crowdsensing.navigationmenu;

import android.graphics.Bitmap;

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
}
