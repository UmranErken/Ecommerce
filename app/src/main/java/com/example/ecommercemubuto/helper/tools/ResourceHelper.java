package com.example.ecommercemubuto.helper.tools;

import android.content.Context;

public class ResourceHelper {
    public static String convertNameFromIOSFormat(String iosResourceName) {
        return iosResourceName.replace("Bg", "_bg").toLowerCase().replace(".png", "");
    }

    public static int getResourceId(Context context, String resourceName, String resourceType) {
        try {
            return context.getResources().getIdentifier(resourceName, resourceType, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
