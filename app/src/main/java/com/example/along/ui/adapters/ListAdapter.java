package com.example.along.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.along.R;

import java.util.List;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author dragon.
 * Date 2018/4/20 10:54
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> mStrings;

    public void setStrings(List<String> strings) {
        mStrings = strings;
        notifyDataSetChanged();
    }

    public ListAdapter(Context context, List<String> strings) {
        mContext = context;
        mStrings = strings;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int i) {
        return mStrings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListHolder gridHolder;
        if (view==null) {
            view=mLayoutInflater.inflate(R.layout.item_tv,viewGroup,false);
            gridHolder=new ListHolder(view);
            view.setTag(gridHolder);
        }else{
            gridHolder= (ListHolder) view.getTag();
        }
        gridHolder.mTvItemGrid.setText(mStrings.get(i));
        return view;
    }



    public class ListHolder{
        private TextView mTvItemGrid;


        public ListHolder(View view){
            mTvItemGrid = (TextView) view.findViewById(R.id.tv_item_grid);
        }
    }
}