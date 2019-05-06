package nest.angel.smd.angelnest.domain.parent;

import android.support.v4.app.Fragment;

import nest.angel.smd.angelnest.data.util.AppLogs;

public class ParentFragment extends Fragment {

    String TAG = "ParentFragment";

    //Generic functions/ Usecases here which will be used in all fragments.
    //All other activities will inherit this class.
    //For example, you can write here logout scenario, in case of session expire, you can
    //call this function from that derived activity.
    //Similarly, use all these functions in Parent Fragment as well, so you can use those functions in fragments.
    protected void logoutCase(){
        AppLogs.LogI(TAG, "Logging Out!!");
    }
}
