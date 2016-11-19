package com.example.a1027.week151105.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1027.week151105.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-19.
 */

public class MemberAdapter extends BaseAdapter {

    ArrayList<MemberDTO> list;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };


    public MemberAdapter(Context context, ArrayList<MemberDTO> list) {

        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int idx) {
        return list.get(idx);
    }

    @Override
    public long getItemId(int idx) {
        return idx;
    }

    @Override
    public View getView(int idx, View v, ViewGroup g) {
        ViewHolder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.member_list, null);
            holder = new ViewHolder();
            holder.ivPhoto = (ImageView)v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView) v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView) v.findViewById(R.id.tv_phone);

            v.setTag(holder);

        } else {

            holder = (ViewHolder) v.getTag();
        }
        Log.d("Adapter Checked Name:", list.get(idx).getName());
        holder.ivPhoto.setImageResource(photos[idx]);
        holder.tvName.setText(list.get(idx).getName());
        holder.tvPhone.setText(list.get(idx).getPhone());
        return v;
    }

    // inner class
    static class ViewHolder {
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    };
}
