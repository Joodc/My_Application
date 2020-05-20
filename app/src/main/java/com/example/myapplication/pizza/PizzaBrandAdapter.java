package com.example.myapplication.pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class PizzaBrandAdapter extends BaseAdapter {
    //PizzaBrandAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<PizzaBrandListViewItem> pizzaBrandListViewItems = new ArrayList<>();

    //PizzaBrandAdapter의 생성자
    public PizzaBrandAdapter(){ }

    //PizzaBrandAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return pizzaBrandListViewItems.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_pizza_brand_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_brand_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView pizza_brand_img = convertView.findViewById(R.id.food_brand_img);
        TextView pizza_brand_name = convertView.findViewById(R.id.food_brand_name);
        TextView pizza_brand_menu = convertView.findViewById(R.id.food_brand_menu);
        TextView pizza_brand_number = convertView.findViewById(R.id.food_brand_number);

        //Data Set(pizzaBrandListViewItems)에서 position에 위치한 데이터 참조 획득
        PizzaBrandListViewItem pizzaBrandListViewItem = pizzaBrandListViewItems.get(position);

        //아이템 내 각 위젯에 데이터 반영
        pizza_brand_img.setImageResource(pizzaBrandListViewItem.getPizza_brand_img());
        pizza_brand_name.setText(pizzaBrandListViewItem.getPizza_brand_name());
        pizza_brand_menu.setText(pizzaBrandListViewItem.getPizza_brand_menu());
        pizza_brand_number.setText(pizzaBrandListViewItem.getPizza_brand_number());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return pizzaBrandListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int img, String name, String menu, String number) {
        PizzaBrandListViewItem item = new PizzaBrandListViewItem();

        item.setPizza_brand_img(img);
        item.setPizza_brand_name(name);
        item.setPizza_brand_menu(menu);
        item.setPizza_brand_number(number);

        pizzaBrandListViewItems.add(item);
    }
}