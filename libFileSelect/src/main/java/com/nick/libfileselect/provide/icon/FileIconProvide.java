package com.nick.libfileselect.provide.icon;

import android.content.Context;

import java.io.File;

/**
 */
public abstract class FileIconProvide {
    public abstract int getFileDrawableResId(Context context, File file);
}
