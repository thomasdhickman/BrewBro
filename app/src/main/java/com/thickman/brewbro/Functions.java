package com.thickman.brewbro;

import android.content.Context;
import android.content.SharedPreferences;

public class Functions {

    public static SharedPreferences preferences = null;

    public static final String PREF_NAME = "preferences";
    public static final String PREF_NULL = "pref_null";

    private static void setPreferences(Context ctx) {
        if (preferences == null) {
            preferences = ctx.getSharedPreferences(PREF_NAME,
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.commit();
        }
    }

    public static void setStringPreference(Context ctx, String key, String value) {
        try {
            setPreferences(ctx);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getStringPreference(Context ctx, String key) {
        return preferences.getString(key, PREF_NULL);
    }

    public static void setBooleanPreference(Context ctx, String key, boolean flag) {
        try {
            setPreferences(ctx);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(key, flag);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean getBooleanPreference(Context ctx, String key) {
        return preferences.getBoolean(key, false);
    }

    public static void setIntPreference(Context ctx, String key, int value) {
        try {
            setPreferences(ctx);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(key, value);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getIntPreference(Context ctx, String key) {
        return preferences.getInt(key, -1);
    }

    public static void setLongPreference(Context ctx, String key, long value) {
        try {
            setPreferences(ctx);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(key, value);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static long getLongPreference(Context ctx, String key) {
        return preferences.getLong(key, (long) -1);
    }


    public static double limitPrecision(String dblAsString, int maxDigitsAfterDecimal) {
        int multiplier = (int) Math.pow(10, maxDigitsAfterDecimal);
        double truncated = (double) ((long) ((Double.parseDouble(dblAsString)) * multiplier)) / multiplier;
        return truncated;
    }
}
