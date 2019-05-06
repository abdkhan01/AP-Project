package nest.angel.smd.angelnest.data.util;

import android.content.Context;
import android.content.SharedPreferences;

import nest.angel.smd.angelnest.data.network.Constants;


public class AppPreferences {

    private static SharedPreferences mPreferences;

    AppPreferences(Context context) {
        mPreferences = context.getSharedPreferences(Constants.AppPreferences, Context.MODE_PRIVATE);
    }

    public void clearPrefs() {
        mPreferences.edit().clear().apply();
    }

    public boolean getBooleanPreference(String key) {
        return mPreferences.getBoolean(key, false);
    }

    public void setBooleanPreference(String key,boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public int getIntegerPreference(String key) {
        return mPreferences.getInt(key, 0);
    }

    public void setIntegerPreference(String key,int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    public Long getLongPreference(String key) {
        return mPreferences.getLong(key, 0);
    }

    public void setLongPreference(String key,long value) {
        mPreferences.edit().putLong(key,value).apply();
    }

    public double getFloatPreference(String key) {
        return mPreferences.getFloat(key, 0.0f);
    }

    public void setFloatPreference(String key,double value) {
        mPreferences.edit().putFloat(key,(float) value).apply();
    }

    public String getStringPreference(String key) {
        return mPreferences.getString(key, "");
    }

    public void setStringPreference(String key,String value) {
        mPreferences.edit().putString(key,value).apply();
    }
}