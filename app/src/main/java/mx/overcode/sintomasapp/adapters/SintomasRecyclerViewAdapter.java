package mx.overcode.sintomasapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.channguyen.rsv.RangeSliderView;

import java.util.ArrayList;
import java.util.List;

import mx.overcode.sintomasapp.R;
import mx.overcode.sintomasapp.models.Sintoma;

/**
 * Created by aldo on 3/19/18.
 */

public class SintomasRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Sintoma> list;
    private OnItemValueChangeListener listener;

    private final int CONTENT_TYPE = 1;
    private final int BUTTON_TYPE = 2;

    class ContentHolder extends RecyclerView.ViewHolder implements SeekBar.OnSeekBarChangeListener {
        private TextView tvDetail;
        private ImageView ivLeft, ivRight;
        private SeekBar rsv_value;

        public ContentHolder(View itemView) {
            super(itemView);
            this.tvDetail = itemView.findViewById(R.id.tvDetail);
            this.rsv_value = itemView.findViewById(R.id.rsv_value);
            this.ivLeft = itemView.findViewById(R.id.ivLeft);
            this.ivRight = itemView.findViewById(R.id.ivRight);

            rsv_value.setOnSeekBarChangeListener(this);

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            int position = getAdapterPosition(); // gets item position
            if (listener != null){
                listener.onValueChange(position, (double)i / 10.0);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    }

    class ButtonHolder extends RecyclerView.ViewHolder  {
        private Button btnGeneric, btnSpecific;

        public ButtonHolder(View itemView) {
            super(itemView);
            this.btnGeneric = itemView.findViewById(R.id.btnGeneric);
            this.btnSpecific = itemView.findViewById(R.id.btnSpecific);

            btnGeneric.setOnClickListener(view -> {
                listener.onCalculareGeneric();
            });

            btnSpecific.setOnClickListener(view -> {
                listener.onCalcularSpecific();
            });

        }

    }

    public SintomasRecyclerViewAdapter(Context ctx, List<Sintoma> list, OnItemValueChangeListener listener) {
        this.context = ctx;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View itemView;
        switch (viewType) {
            case CONTENT_TYPE:
                itemView = inflater.inflate(R.layout.item_sintoma, viewGroup, false);
                return new ContentHolder(itemView);
            case BUTTON_TYPE:
                itemView = inflater.inflate(R.layout.item_buttons_view, viewGroup, false);
                return new ButtonHolder(itemView);
            default:
                itemView = inflater.inflate(R.layout.item_sintoma, viewGroup, false);
                return new ContentHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentHolder) {

            ContentHolder viewHolder = (ContentHolder)holder;

            final Sintoma item = list.get(position);

            viewHolder.tvDetail.setText(item.getId() + ". "+ item.getDetail());

            Glide.with(holder.itemView).load(item.getImgLeft())
                    .apply(RequestOptions.circleCropTransform())
                    .into(viewHolder.ivLeft);

            Glide.with(holder.itemView).load(item.getImgRight())
                    .apply(RequestOptions.circleCropTransform())
                    .into(viewHolder.ivRight);
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public interface OnItemValueChangeListener {
        void onValueChange(int position, double value);
        void onCalculareGeneric();
        void onCalcularSpecific();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == list.size()){
            return BUTTON_TYPE;
        }
        else{
            return CONTENT_TYPE;
        }
    }
}
