package nest.angel.smd.angelnest.data.util;

import android.util.Log;

import nest.angel.smd.angelnest.BuildConfig;

public class AppLogs {
    private static boolean isDebugLoggingOn = false;
    public static void LogI(String TAG, String msg){
        if(isDebugLoggingOn && BuildConfig.DEBUG){
            if(msg == null)
                msg = "";

            if(TAG == null || TAG.isEmpty())
                TAG = "AngelNest";

            Log.i(TAG,msg);
        }
    }
    public static void LogD(String TAG, String msg){
        if(isDebugLoggingOn && BuildConfig.DEBUG){
            if(msg == null)
                msg = "";

            if(TAG == null || TAG.isEmpty())
                TAG = "AngelNest";

            Log.d(TAG,msg);
        }
    }
    public static void LogE(String TAG, String msg){
        if(isDebugLoggingOn && BuildConfig.DEBUG){
            if(msg == null)
                msg = "";

            if(TAG == null || TAG.isEmpty())
                TAG = "AngelNest";
            Log.e(TAG,msg);
        }
    }

}
