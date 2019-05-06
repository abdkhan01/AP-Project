package nest.angel.smd.angelnest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Alerts;
import nest.angel.smd.angelnest.data.classes.Circles;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;

public class AlertsSettingsActivity extends ParentActivity {

    private List<Circles> circlesList = new ArrayList<>();
    private List<Alerts> alertsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView generalAlertsRecyclerView;
    private CircleOptionsRecyclerAdapter mAdapter;
    private GeneralAlertsRecyclerAdapter mGeneralAlertsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerts_settings);

        recyclerView = findViewById(R.id.alerts_settings_recyclerview);

        mAdapter = new CircleOptionsRecyclerAdapter(circlesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        generalAlertsRecyclerView = findViewById(R.id.general_alerts_recyclerview);

        mGeneralAlertsAdapter = new GeneralAlertsRecyclerAdapter(alertsList);
        RecyclerView.LayoutManager mGeneralAlertsLayoutManager = new LinearLayoutManager(getApplicationContext());
        generalAlertsRecyclerView.setLayoutManager(mGeneralAlertsLayoutManager);
        generalAlertsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        generalAlertsRecyclerView.setAdapter(mGeneralAlertsAdapter);
    }

}
