package nest.angel.smd.angelnest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;
import nest.angel.smd.angelnest.view.interfaces.IEditProfile;

public class EditProfileActivity extends ParentActivity implements IEditProfile {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
    }

    @Override
    public void showProgressBar() {

    }
}
