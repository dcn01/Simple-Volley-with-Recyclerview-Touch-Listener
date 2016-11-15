package com.hakiki95.simpelvolleyrequest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hakiki95.simpelvolleyrequest.R;
import com.hakiki95.simpelvolleyrequest.model.Model_Mhs;

import java.util.List;

/**
 * Created by hakiki95 on 14/11/2016.
 */

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.HolderMahasiswa> {
    private List<Model_Mhs> mList;
    private Context mContext;

    public AdapterMahasiswa(Context mcontext,List<Model_Mhs> mlist)
    {
        this.mContext = mcontext;
        this.mList = mlist;
    }

    @Override
    public HolderMahasiswa onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mahasiswa,parent,false);
        HolderMahasiswa holder = new HolderMahasiswa(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderMahasiswa holder, int position) {
        Model_Mhs md = mList.get(position);
        Glide.with(mContext).load(md.getImageUrl()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img_thubnail);

        holder.tvNpm.setText(md.getNpm());
        holder.tvNama.setText(md.getNama());
        holder.tvProdi.setText(md.getProdi());
        holder.tvFakultas.setText(md.getFakultas());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public  class HolderMahasiswa extends RecyclerView.ViewHolder
    {
        ImageView img_thubnail ;
        TextView tvNpm, tvNama, tvProdi, tvFakultas;


        public HolderMahasiswa (View v)
        {
            super(v);
            img_thubnail = (ImageView) v.findViewById(R.id.img_thubnail);
            tvNpm = (TextView) v.findViewById(R.id.tv_npm);
            tvNama= (TextView) v.findViewById(R.id.tv_nama);
            tvProdi= (TextView) v.findViewById(R.id.tv_prodi);
            tvFakultas= (TextView) v.findViewById(R.id.tv_fakultas);

        }
    }
}
