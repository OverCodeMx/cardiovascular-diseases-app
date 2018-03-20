package mx.overcode.sintomasapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mx.overcode.sintomasapp.R;
import mx.overcode.sintomasapp.models.Enfermedad;

/**
 * Created by aldo on 3/19/18.
 */

public class EnfermedadesRecyclerViewAdapter extends RecyclerView.Adapter<EnfermedadesRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Enfermedad> list;
    private OnItemListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
        private TextView tvName;
        private CheckBox cbDisease;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.cbDisease = itemView.findViewById(R.id.cbDisease);

            cbDisease.setOnCheckedChangeListener(this);

        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            int position = getAdapterPosition(); // gets item position
            Enfermedad item = list.get(position);
            if (listener != null){
                listener.onCheckboxChange(position, b);
            }
        }

    }

    public EnfermedadesRecyclerViewAdapter(Context ctx, List<Enfermedad> list, OnItemListener listener) {
        this.context = ctx;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public EnfermedadesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                           int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final View view = inflater.inflate(R.layout.item_enfermedad, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Enfermedad item = list.get(position);

        holder.tvName.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemListener {
        void onCheckboxChange(int position, boolean b);
    }


}