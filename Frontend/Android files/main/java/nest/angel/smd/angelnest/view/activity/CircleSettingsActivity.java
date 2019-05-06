package nest.angel.smd.angelnest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Circles;
import nest.angel.smd.angelnest.data.classes.Members;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;

public class CircleSettingsActivity extends ParentActivity {

    private List<Members> membersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CircleSettingsRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_settings);

        recyclerView = findViewById(R.id.circle_settings_recyclerview);

        mAdapter = new CircleSettingsRecyclerAdapter(membersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

}
