package nest.angel.smd.angelnest.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Circles;
import nest.angel.smd.angelnest.data.classes.Members;

public class EditCircleRecyclerAdapter  extends RecyclerView.Adapter<EditCircleRecyclerAdapter.MyViewHolder> {

    private List<Members> membersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView profileImage;
        public TextView name;
        public CheckBox checkBox;
        public TextView adminTv;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.member_name);
            checkBox = (CheckBox) view.findViewById(R.id.delete_checkbox);
            profileImage = (ImageView) view.findViewById(R.id.profile_image);
            adminTv = (TextView) view.findViewById(R.id.admin_tv);

        }
    }


    public EditCircleRecyclerAdapter(List<Members> membersList) {
        this.membersList = membersList;
    }

    @Override
    public EditCircleRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.edit_circle_recyclerview, parent, false);

        return new EditCircleRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EditCircleRecyclerAdapter.MyViewHolder holder, int position) {
        Members member = membersList.get(position);
        holder.profileImage.setImageBitmap(member.getProfileImage());
        holder.name.setText(member.getName());
    }

    @Override
    public int getItemCount() {
        return membersList.size();
    }
}

