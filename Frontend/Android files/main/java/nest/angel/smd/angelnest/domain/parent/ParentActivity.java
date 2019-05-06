package nest.angel.smd.angelnest.domain.parent;

import android.support.v7.app.AppCompatActivity;

import nest.angel.smd.angelnest.data.util.AppLogs;

public class ParentActivity extends AppCompatActivity{

    String TAG = "ParentActivity";

    //Generic functions used in all activities.
    //All other activities will inherit this class.
    //For example, you can write here logout scenario, in case of session expire, you can
    //call this function from that derived activity.
    //Similarly, use all these functions in Parent Fragment as well, so you can use those functions in fragments.
    protected void logoutCase(){
        AppLogs.LogI(TAG, "Logging Out!!");
    }
}
