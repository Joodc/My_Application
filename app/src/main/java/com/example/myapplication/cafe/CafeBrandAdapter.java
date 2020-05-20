package com.example.myapplication.cafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CafeBrandAdapter extends BaseAdapter {
    //CafeBrandAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<CafeBrandListViewItem> cafeBrandListViewItems = new ArrayList<>();

    //CafeBrandAdapter의 생성자
    public CafeBrandAdapter(){ }

    //CafeBrandAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return cafeBrandListViewItems.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_cafe_brand_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_brand_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView cafe_brand_img = convertView.findViewById(R.id.food_brand_img);
        TextView cafe_brand_name = convertView.findViewById(R.id.food_brand_name);
        TextView cafe_brand_menu = convertView.findViewById(R.id.food_brand_menu);
        TextView cafe_brand_number = convertView.findViewById(R.id.food_brand_number);

        //Data Set(cafeBrandListViewItems)에서 position에 위치한 데이터 참조 획득
        CafeBrandListViewItem cafeBrandListViewItem = cafeBrandListViewItems.get(position);

        //아이템 내 각 위젯에 데이터 반영
        cafe_brand_img.setImageResource(cafeBrandListViewItem.getCafe_brand_img());
        cafe_brand_name.setText(cafeBrandListViewItem.getCafe_brand_name());
        cafe_brand_menu.setText(cafeBrandListViewItem.getCafe_brand_menu());
        cafe_brand_number.setText(cafeBrandListViewItem.getCafe_brand_number());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return cafeBrandListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int img, String name, String menu, String number) {
        CafeBrandListViewItem item = new CafeBrandListViewItem();

        item.setCafe_brand_img(img);
        item.setCafe_brand_name(name);
        item.setCafe_brand_menu(menu);
        item.setCafe_brand_number(number);

        cafeBrandListViewItems.add(item);
    }
}