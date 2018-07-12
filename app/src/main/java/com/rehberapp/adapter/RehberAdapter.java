package com.rehberapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rehberapp.R;
import com.rehberapp.model.Rehber;

import java.util.List;

public class RehberAdapter extends RecyclerView.Adapter<RehberAdapter.UserViewHolder> {

    private List<Rehber> dataList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }

    public RehberAdapter(List<Rehber> dataList) {
        this.dataList = dataList;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_rehber, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        //holder.txtId.setText(String.valueOf(dataList.get(position).getId()));

        holder.txtAdSoyad.setText(String.valueOf(dataList.get(position).getAdsoyad()));

        holder.txtTelefon.setText(String.valueOf(dataList.get(position).getTelefon()));
    }


    @Override

    public int getItemCount() {

        return dataList.size();

    }


    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtAdSoyad, txtTelefon;

        UserViewHolder(View itemView) {
            super(itemView);

            //txtId = (TextView) itemView.findViewById(R.id.txt_id);

            txtAdSoyad = (TextView) itemView.findViewById(R.id.txt_adSoyad);

            txtTelefon = (TextView) itemView.findViewById(R.id.txt_telefonNo);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    if(mListener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }});

        }

    }
}
