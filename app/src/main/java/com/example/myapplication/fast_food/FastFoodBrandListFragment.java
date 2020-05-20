package com.example.myapplication.fast_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class FastFoodBrandListFragment extends ListFragment {
    FastFoodBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new FastFoodBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_mac_logo, "맥도날드", "대표메뉴 : 빅맥, 상하이 치킨버거, 1955버거", "주문전화 : 1600-5252");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_lotteria_logo, "롯데리아","대표메뉴 : 불고기버거, AZ버거, 새우버거", "주문전화 : 02-709-1114");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_momstouch_logo, "맘스터치","대표메뉴 : 싸이버거, 화이트 갈릭버거", "주문전화 : 1661-4205");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_kfc_logo, "KFC","대표메뉴 : 징거버거, 핫 크리스피 치킨", "주문전화 : 1599-8484");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_burgerking_logo, "버거킹","대표메뉴 : 콰트로 치즈 와퍼, 주니어 와퍼", "주문전화 : 1599-0505");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        FastFoodBrandListViewItem item = (FastFoodBrandListViewItem) listView.getItemAtPosition(position);

        int fast_food_brand_img = item.getFast_food_brand_img();
        String fast_food_brand_name = item.getFast_food_brand_name();
        String fast_food_brand_menu = item.getFast_food_brand_menu();
        String fast_food_brand_number = item.getFast_food_brand_number();


    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}