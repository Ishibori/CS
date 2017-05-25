package com.example.ishibori.crowdsensing.navigationmenu;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class CustomMenuItem {
    public enum ItemType {Empty, StandardItem, HorizontalMenu, GroupHeadline}
    public ItemType menuItemType;
    public boolean showRightCounter;

    public View getView(LayoutInflater li){
        return null;
    }
}
