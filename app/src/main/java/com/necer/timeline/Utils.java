package com.necer.timeline;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by 闫彬彬 on 2017/10/11.
 * QQ:619008099
 */

public class Utils {

    /**
     * dp转px
     *
     * @param context
     * @param
     * @return
     */
    public static float dp2px(Context context, int dpVal) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
}
