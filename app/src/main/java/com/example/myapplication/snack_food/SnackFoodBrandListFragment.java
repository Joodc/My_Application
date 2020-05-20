package com.example.myapplication.snack_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class SnackFoodBrandListFragment extends ListFragment {
    SnackFoodBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new SnackFoodBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_yupdduck_logo, "동대문 엽기 떡볶이", "대표메뉴 : 엽기 떡볶이, 엽기 닭볶음탕", "주문전화 : 1661-8514");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_sinjeon_logo, "신전 떡볶이","대표메뉴 : 떡볶이, 스팸마요컵밥, 튀김오뎅", "주문전화 : 053-423-6339");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_youngdabang_logo, "청년 다방","대표메뉴 : 차돌떡볶이, 통닭떡볶이, 찰순대", "주문전화 : 1666-4693");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_kukde_logo, "국대 떡볶이","대표메뉴 : 떡볶이, 참치마요컵밥, 냉쫄우동", "주문전화 : 02-598-8869");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_jaws_logo, "죠스 떡볶이","대표메뉴 : 죠스 떡볶이, 죠스 찰순대", "주문전화 : 02-927-1525");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        SnackFoodBrandListViewItem item = (SnackFoodBrandListViewItem) listView.getItemAtPosition(position);

        int snack_food_brand_img = item.getSnack_food_brand_img();
        String snack_food_brand_name = item.getSnack_food_brand_name();
        String snack_food_brand_menu = item.getSnack_food_brand_menu();
        String snack_food_brand_number = item.getSnack_food_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}