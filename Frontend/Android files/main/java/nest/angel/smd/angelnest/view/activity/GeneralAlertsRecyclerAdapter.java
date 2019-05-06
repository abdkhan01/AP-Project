package nest.angel.smd.angelnest.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Alerts;
import nest.angel.smd.angelnest.data.classes.Circles;

public class GeneralAlertsRecyclerAdapter extends RecyclerView.Adapter<GeneralAlertsRecyclerAdapter.MyViewHolder> {

    private List<Alerts> alertsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView alertName;
        public Switch generalAlertsSwitch;

        public MyViewHolder(View view) {
            super(view);
            generalAlertsSwitch = (Switch) view.findViewById(R.id.general_alerts_switch);
            alertName = (TextView) view.findViewById(R.id.general_alertsname_tv);

        }
    }


    public GeneralAlertsRecyclerAdapter(List<Alerts> alertsList) {
        this.alertsList = alertsList;
    }

    @Override
    public GeneralAlertsRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.general_alerts_recyclerview, parent, false);

        return new GeneralAlertsRecyclerAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(GeneralAlertsRecyclerAdapter.MyViewHolder holder, int position) {
        Alerts alert = alertsList.get(position);
        holder.generalAlertsSwitch.setChecked(alert.getAlertSwitch());
        holder.alertName.setText(alert.getAlertName());
    }

    @Override
    public int getItemCount() {
        return alertsList.size();
    }
}

