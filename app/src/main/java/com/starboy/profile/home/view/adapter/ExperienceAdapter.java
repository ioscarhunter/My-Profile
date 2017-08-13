package com.starboy.profile.home.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.starboy.profile.R;
import com.starboy.profile.home.model.ExperienceItem;
import com.starboy.profile.utils.Utils;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by i_osc on 8/6/2017.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder> {

    private Context context;
    private ArrayList<ExperienceItem> items;

    public ExperienceAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    public void setItems(ArrayList<ExperienceItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ExperienceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exprerience, parent, false);
        return new ExperienceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExperienceViewHolder holder, int position) {
        ExperienceItem item = items.get(position);
        if (position == 0) {
            holder.timelineTopView.setVisibility(View.VISIBLE);
            holder.timelineBottomView.setVisibility(View.VISIBLE);
        } else if (position < getItemCount() - 1) {
            holder.timelineTopView.setVisibility(View.VISIBLE);
            holder.timelineBottomView.setVisibility(View.VISIBLE);
        } else {
            holder.timelineTopView.setVisibility(View.VISIBLE);
            holder.timelineBottomView.setVisibility(View.INVISIBLE);
        }

        holder.nameText.setText(item.getName());
        holder.yearText.setText(item.getYear());
        holder.detailText.setText(item.getDetail());
        try {
            holder.logoImageView.setImageResource(Utils.getId(item.getResource(), R.drawable.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class ExperienceViewHolder extends RecyclerView.ViewHolder {

        private View timelineTopView;
        private CircleImageView logoImageView;
        private View timelineBottomView;
        private TextView yearText;
        private TextView nameText;
        private TextView detailText;

        public ExperienceViewHolder(View view) {
            super(view);
            timelineTopView = view.findViewById(R.id.timelineTopView);
            logoImageView = (CircleImageView) view.findViewById(R.id.logoImageView);
            timelineBottomView = view.findViewById(R.id.timelineBottomView);
            yearText = (TextView) view.findViewById(R.id.yearText);
            nameText = (TextView) view.findViewById(R.id.nameText);
            detailText = (TextView) view.findViewById(R.id.detailText);
        }
    }
}
