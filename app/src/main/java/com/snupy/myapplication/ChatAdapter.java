package com.snupy.myapplication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by interstellar on 10/02/2017.
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // 아이템 리스트
    private ArrayList<item> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(ArrayList<item> items) {
        mDataset = items;
    }
    // Create new views (invoked by the layout manager)

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {   View view = null;
        Log.d("viewType is", String.valueOf(viewType));
        switch(viewType%2){
            case 1:{  return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_msg_view,parent,false));}
            case 0:{  return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.oppenent_msg_view,parent,false));}
        }
        return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_msg_view,parent,false));
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        switch(position){
            case 1:{ ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                      viewHolder0.mTextView.setText( mDataset.get(position).text );
                    }
            case 0:{ ViewHolder1 viewHolder1 = (ViewHolder1) holder;
                      viewHolder1.mTextView.setText( mDataset.get(position).text  );
                    }
        }
       // holder.mImageView.setImageResource( mDataset.get(position).img );
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder0 extends RecyclerView.ViewHolder{
        // public ImageView mImageView;
        public TextView mTextView;
        public ViewHolder0(View itemView) {
            super(itemView);
            // mImageView = (ImageView) itemView.findViewById(R.id.image_in_card);
            mTextView = (TextView) itemView.findViewById(R.id.textview_in_my_msg);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{
        // public ImageView mImageView;
        public TextView mTextView;
        public ViewHolder1(View itemView) {
            super(itemView);
            // mImageView = (ImageView) itemView.findViewById(R.id.image_in_card);
            mTextView = (TextView) itemView.findViewById(R.id.textview_in_op_msg);
        }
    }
}