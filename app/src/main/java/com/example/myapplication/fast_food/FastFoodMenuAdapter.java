package com.example.myapplication.fast_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FastFoodMenuAdapter extends BaseAdapter {
    //FastFoodMenuAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<FastFoodMenuListViewItem> fastFoodMenuListViewItems = new ArrayList<>();

    //FastFoodMenuAdapter의 생성자
    public FastFoodMenuAdapter() { }

    //FastFoodMenuAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() { return fastFoodMenuListViewItems.size(); }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_fast_food_menu_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_menu_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView fast_food_menu_img = convertView.findViewById(R.id.food_menu_img);
        TextView fast_food_menu_name = convertView.findViewById(R.id.food_menu_name);
        TextView fast_food_menu_content = convertView.findViewById(R.id.food_menu_content);

        //Data Set(fastFoodMenuListViewItems)에서 position에 위치한 데이터 참조 획득
        FastFoodMenuListViewItem fastFoodMenuListViewItem = fastFoodMenuListViewItems.get(position);

        //아이템 내 각 위젯에 데이터 반영
        fast_food_menu_img.setImageResource(fastFoodMenuListViewItem.getFast_food_menu_img());
        fast_food_menu_name.setText(fastFoodMenuListViewItem.getFast_food_menu_name());
        fast_food_menu_content.setText(fastFoodMenuListViewItem.getFast_food_menu_content());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return fastFoodMenuListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int img, String name, String content) {
        FastFoodMenuListViewItem item = new FastFoodMenuListViewItem();

        item.setFast_food_menu_img(img);
        item.setFast_food_menu_name(name);
        item.setFast_food_menu_content(content);

        fastFoodMenuListViewItems.add(item);
    }
}