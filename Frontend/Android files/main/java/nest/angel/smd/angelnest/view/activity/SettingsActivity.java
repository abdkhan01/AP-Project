package nest.angel.smd.angelnest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;

public class SettingsActivity extends ParentActivity {

    private ListView settings_lv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        settings_lv = (ListView) findViewById(R.id.settings_lv);

        ArrayList<String> settings_array = new ArrayList<>();
        populateList(settings_array);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                settings_array);

        settings_lv.setAdapter(arrayAdapter);
    }

    private void populateList(List<String> list){

        list.add("Circles");
        list.add("Map Options");
        list.add("Alerts");
        list.add("Account");
        list.add("Log Out");

    }
}
