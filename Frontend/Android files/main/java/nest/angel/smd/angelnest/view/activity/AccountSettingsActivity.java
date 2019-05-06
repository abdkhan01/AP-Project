package nest.angel.smd.angelnest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;

public class AccountSettingsActivity extends ParentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_settings);


    }
}
