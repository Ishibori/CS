package com.example.ishibori.crowdsensing.navigationmenu;

/**
 * Created by Ishibori on 22/01/2017.
 */

public class GroupHeadlineItem extends CustomMenuItem{
    String title;

    public GroupHeadlineItem(ItemType menuItemType, String title){
        this.menuItemType = menuItemType;
        this.title = title;
    }
}
