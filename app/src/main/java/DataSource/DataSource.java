package DataSource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatDrawableManager;

import com.example.ishibori.crowdsensing.R;
import com.example.ishibori.crowdsensing.navigationmenu.CustomMenuItem;
import com.example.ishibori.crowdsensing.navigationmenu.GroupHeadlineItem;
import com.example.ishibori.crowdsensing.navigationmenu.HorizontalMenuItem;
import com.example.ishibori.crowdsensing.navigationmenu.StandardItem;

import java.util.ArrayList;

/**
 * Created by Ishibori on 23/01/2017.
 */

public class DataSource {
    public static ArrayList<String> favoriteSurveys;
    public static ArrayList<String> publicSurveys;
    public static ArrayList<String> privateSurveys;

    public static boolean isInitialized = false;
    public static Context globalContext;

    public static void init(Context context) {
        globalContext = context;
        isInitialized = true;
    }

    public static ArrayList<CustomMenuItem> getNavigationMenuItems() {
        ArrayList<CustomMenuItem> menuItems = new ArrayList<CustomMenuItem>();

        if (!isInitialized)
            return menuItems;

        Bitmap bmpCamera = getBitmapFromVectorDrawable(globalContext, R.drawable.ic_menu_camera);

        menuItems.add(new GroupHeadlineItem(CustomMenuItem.ItemType.GroupHeadline, "MANAGE SURVEYS"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Create New"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Favorites", 0, true));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Public", 1000, true));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Private", 4, true));

        menuItems.add(new GroupHeadlineItem(CustomMenuItem.ItemType.GroupHeadline, "COMMUNICATE"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Share"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Notifications", 0, true));

        menuItems.add(new GroupHeadlineItem(CustomMenuItem.ItemType.GroupHeadline, "ACCOUNT"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Upgrade"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Settings"));

        menuItems.add(new GroupHeadlineItem(CustomMenuItem.ItemType.GroupHeadline, "PRACTICAL"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Privacy Policy"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Help"));
        menuItems.add(new StandardItem(CustomMenuItem.ItemType.StandardItem, bmpCamera, "Log Out"));

        /*ArrayList<String> titles = new ArrayList<String>();
        titles.add(globalContext.getString(R.string.nav_settings));
        titles.add(globalContext.getString(R.string.nav_help));
        titles.add(globalContext.getString(R.string.nav_log_out));

        ArrayList<Bitmap> icons = new ArrayList<Bitmap>();
        icons.add(bmpCamera);
        icons.add(bmpCamera);
        icons.add(bmpCamera);

        menuItems.add(new HorizontalMenuItem(CustomMenuItem.ItemType.Horizontal_Menu, titles, icons));
*/
        return menuItems;
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = AppCompatDrawableManager.get().getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
