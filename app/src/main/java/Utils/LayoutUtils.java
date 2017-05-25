package Utils;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

/**
 * Created by Ishibori on 28/01/2017.
 */

public class LayoutUtils {
    public static int getColorFromId(Context context, int colorId) {
        return ResourcesCompat.getColor(context.getResources(), colorId, null);
    }
}
