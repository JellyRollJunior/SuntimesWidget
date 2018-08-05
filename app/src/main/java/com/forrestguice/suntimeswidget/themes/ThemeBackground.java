/**
    Copyright (C) 2017-2018 Forrest Guice
    This file is part of SuntimesWidget.

    SuntimesWidget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SuntimesWidget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SuntimesWidget.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.forrestguice.suntimeswidget.themes;

import android.content.Context;
import android.support.annotation.NonNull;

import com.forrestguice.suntimeswidget.R;

/**
 * ThemeBackground
 */
public enum ThemeBackground
{
    COLOR(-1, "Colour", true),
    DARK(R.drawable.bg_widget_dark, "Dark", false),
    LIGHT(R.drawable.bg_widget, "Light", false),
    TRANSPARENT(android.R.color.transparent, "Transparent", false);

    private int resID;
    private String displayString;
    private boolean customColors = false;

    private ThemeBackground(int resId, String displayString, boolean customColors )
    {
        this.resID = resId;
        this.displayString = displayString;
        this.customColors = customColors;
    }

    public int getResID()
    {
        return resID;
    }

    public boolean supportsCustomColors()
    {
        return customColors;
    }

    public String getDisplayString()
    {
        return displayString;
    }
    public void setDisplayString( String displayString )
    {
        this.displayString = displayString;
    }

    @Override
    public String toString()
    {
        return displayString;
    }

    public static void initDisplayStrings( Context context )
    {
        DARK.setDisplayString(context.getString(R.string.configLabel_themeBackground_dark));
        LIGHT.setDisplayString(context.getString(R.string.configLabel_themeBackground_light));
        TRANSPARENT.setDisplayString(context.getString(R.string.configLabel_themeBackground_trans));
        COLOR.setDisplayString(context.getString(R.string.configLabel_themeBackground_color));
    }

    @NonNull
    public static ThemeBackground getThemeBackground( int resID )
    {
        ThemeBackground[] backgrounds = ThemeBackground.values();
        //noinspection ForLoopReplaceableByForEach
        for (int i=0; i<backgrounds.length; i++)
        {
            if (backgrounds[i] != null && backgrounds[i].getResID() == resID)
            {
                return backgrounds[i];
            }
        }
        return ThemeBackground.DARK;
    }
}
