package com.example.ecommercemubuto.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommercemubuto.R;
import com.example.ecommercemubuto.ui.AccountList;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<AccountList> list;


    public ListViewAdapter(Activity activity,List<AccountList> mList){

        layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        list=mList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satırView;
        satırView = layoutInflater.inflate(R.layout.account_item, null);

        ImageView img = (ImageView) satırView.findViewById(R.id.account_image);
        TextView txt = (TextView) satırView.findViewById(R.id.account_text);
        AccountList accountList = list.get(position);
        txt.setText(accountList.getIsim().toString());

        String AccountName = accountList.getIsim().toString();
        if (accountList.equals("My Orders")) {
            img.setImageResource(R.drawable.logo);
        } else if (accountList.equals("Settings")){
          img.setImageResource(R.drawable.ic_action_cart);

        }
        else if (accountList.equals("My Coupons")){

            img.setImageResource(R.drawable.ic_action_cart);
        }
        else if (accountList.equals("Help")){

            img.setImageResource(R.drawable.ic_action_cart);
        }


            return satırView;
    }
}
