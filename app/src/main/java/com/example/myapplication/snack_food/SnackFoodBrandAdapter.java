package com.example.myapplication.snack_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SnackFoodBrandAdapter extends BaseAdapter {
    //SnackFoodBrandAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<SnackFoodBrandListViewItem> snackFoodBrandListViewItems = new ArrayList<>();

    //SnackFoodBrandAdapter의 생성자
    public SnackFoodBrandAdapter(){ }

    //SnackFoodBrandAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return snackFoodBrandListViewItems.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_snack_food_brand_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_brand_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView snack_food_brand_img = convertView.findViewById(R.id.food_brand_img);
        TextView snack_food_brand_name = convertView.findViewById(R.id.food_brand_name);
        TextView snack_food_brand_menu = convertView.findViewById(R.id.food_brand_menu);
        TextView snack_food_brand_number = convertView.findViewById(R.id.food_brand_number);

        //Data Set(snackFoodBrandListViewItems)에서 position에 위치한 데이터 참조 획득
        SnackFoodBrandListViewItem snackFoodBrandListViewItem = snackFoodBrandListViewItems.get(position);

        //아이템 내 각 위젯에 데이터 반영
        snack_food_brand_img.setImageResource(snackFoodBrandListViewItem.getSnack_food_brand_img());
        snack_food_brand_name.setText(snackFoodBrandListViewItem.getSnack_food_brand_name());
        snack_food_brand_menu.setText(snackFoodBrandListViewItem.getSnack_food_brand_menu());
        snack_food_brand_number.setText(snackFoodBrandListViewItem.getSnack_food_brand_number());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return snackFoodBrandListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int img, String name, String menu, String number) {
        SnackFoodBrandListViewItem item = new SnackFoodBrandListViewItem();

        item.setSnack_food_brand_img(img);
        item.setSnack_food_brand_name(name);
        item.setSnack_food_brand_menu(menu);
        item.setSnack_food_brand_number(number);

        snackFoodBrandListViewItems.add(item);
    }
}