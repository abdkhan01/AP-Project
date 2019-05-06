package nest.angel.smd.angelnest.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Circles;

public class CircleOptionsRecyclerAdapter extends RecyclerView.Adapter<CircleOptionsRecyclerAdapter.MyViewHolder> {

    private List<Circles> circlesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView memberCount,circleName;

        public MyViewHolder(View view) {
            super(view);
            memberCount = (TextView) view.findViewById(R.id.circleoptions_circle_name_tv);
            circleName = (TextView) view.findViewById(R.id.members_count);

        }
    }


    public CircleOptionsRecyclerAdapter(List<Circles> circlesList) {
        this.circlesList = circlesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.circle_options_recycleriew, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Circles circle = circlesList.get(position);
        holder.memberCount.setText(circle.getMemberCount());
        holder.circleName.setText(circle.getCircleName());
    }

    @Override
    public int getItemCount() {
        return circlesList.size();
    }
}

