package com.example.ishibori.crowdsensing.navigationmenu;

import android.graphics.Bitmap;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class StandardItem extends CustomMenuItem {
    Bitmap icon;
    String title;

    public StandardItem(ItemType menuItemType, Bitmap icon, String title){
        this.menuItemType = menuItemType;
        this.icon = icon;
        this.title = title;
    }
}
