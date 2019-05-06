package nest.angel.smd.angelnest.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Members;

public class CircleSettingsRecyclerAdapter extends RecyclerView.Adapter<CircleSettingsRecyclerAdapter.MyViewHolder> {

    private List<Members> membersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView profileImage;
        public TextView name;
        public Switch adminSwitch;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.member_name);
            adminSwitch = (Switch) view.findViewById(R.id.admin_switch);
            profileImage = (ImageView) view.findViewById(R.id.profile_image);
        }
    }


    public CircleSettingsRecyclerAdapter(List<Members> membersList) {
        this.membersList = membersList;
    }

    @Override
    public CircleSettingsRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.circle_settings_recyclerview, parent, false);

        return new CircleSettingsRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CircleSettingsRecyclerAdapter.MyViewHolder holder, int position) {
        Members member = membersList.get(position);
        holder.profileImage.setImageBitmap(member.getProfileImage());
        holder.name.setText(member.getName());
    }

    @Override
    public int getItemCount() {
        return membersList.size();
    }
}


