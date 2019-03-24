package krunal.com.example.acer.waitinglistapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import krunal.com.example.acer.waitinglistapp.Database.WaitingListEntity;

/**
 * Created by acer on 13-02-2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder> {

    private List<WaitingListEntity> mlist = new ArrayList<>();
    Context context;
    private LayoutInflater mlayout;

    public RecycleViewAdapter(Context context){
        this.context = context;
        this.mlayout = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = mlayout.inflate(R.layout.items, parent, false);
        return new RecycleViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        WaitingListEntity waitingList = mlist.get(position);
        holder.mname.setText(waitingList.getName());
        holder.msize.setText(String.valueOf(waitingList.getNumber()));
    }

    WaitingListEntity get(int position){
        return mlist.get(position);
    }

     void add(List<WaitingListEntity> waitingListEntity){
        this.mlist = waitingListEntity;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    static class RecycleViewHolder extends RecyclerView.ViewHolder {

        private TextView mname;

        private TextView msize;

        public RecycleViewHolder(View itemView) {
            super(itemView);

            mname = itemView.findViewById(R.id.name);
            msize = itemView.findViewById(R.id.size);
        }


    }


}
