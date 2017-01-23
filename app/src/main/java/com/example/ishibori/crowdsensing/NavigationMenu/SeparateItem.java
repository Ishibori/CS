package com.example.ishibori.crowdsensing.navigationmenu;

import android.graphics.Bitmap;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class SeparateItem extends CustomMenuItem{
    Bitmap separater;

    public SeparateItem(ItemType menuItemType, Bitmap separater){
        this.menuItemType = menuItemType;
        this.separater = separater;
    }
}
