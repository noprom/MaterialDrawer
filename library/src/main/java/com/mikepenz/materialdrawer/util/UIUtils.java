package com.mikepenz.materialdrawer.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

import com.mikepenz.materialdrawer.R;

/**
 * Created by mikepenz on 15.03.14.
 */
public class UIUtils {
    public static ColorStateList getTextColor(int text_color, int selected_text_color) {
        return new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_activated},
                        new int[]{android.R.attr.state_enabled}
                },
                new int[]{
                        selected_text_color,
                        text_color
                }
        );
    }

    public static StateListDrawable getIconColor(Drawable icon, Drawable selectedIcon) {
        StateListDrawable iconStateListDrawable = new StateListDrawable();
        iconStateListDrawable.addState(new int[]{android.R.attr.state_activated}, selectedIcon);
        iconStateListDrawable.addState(new int[]{android.R.attr.state_enabled}, icon);
        return iconStateListDrawable;
    }

    public static StateListDrawable getDrawerItemBackground(Context ctx) {
        ColorDrawable clrActive = new ColorDrawable(ctx.getResources().getColor(R.color.material_drawer_selected));
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_activated}, clrActive);

        return states;
    }

    @SuppressLint("NewApi")
    public static void setBackground(View v, Drawable d) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackgroundDrawable(d);
        } else {
            v.setBackground(d);
        }
    }
}
