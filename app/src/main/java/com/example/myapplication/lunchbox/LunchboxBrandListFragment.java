package com.example.myapplication.lunchbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class LunchboxBrandListFragment extends ListFragment {
    LunchboxBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new LunchboxBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_hansot_logo, "한솥 도시락", "대표메뉴 : 돈까스덮밥, 동백도시락", "주문전화 : 02-585-1114");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_tomato_logo, "토마토 도시락","대표메뉴 : 떡닭갈비도시락, 순살치킨타코", "주문전화 : 1670-4547");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_bon_logo, "본 도시락","대표메뉴 : 제육쌈밥, 차돌박이강된장쌈밥", "주문전화 : 1644-6288");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_obong_logo, "오봉 도시락","대표메뉴 : 일품도시락, 부산도시락", "주문전화 : 031-906-0040");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_dosiraklab_logo, "도시락 연구소","대표메뉴 : 제육불고기 도시락, 야채볶음밥", "주문전화 : 02-1234-5678");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        LunchboxBrandListViewItem item = (LunchboxBrandListViewItem) listView.getItemAtPosition(position);

        int lunchbox_brand_img = item.getLunchbox_brand_img();
        String lunchbox_brand_name = item.getLunchbox_brand_name();
        String lunchbox_brand_menu = item.getLunchbox_brand_menu();
        String lunchbox_brand_number = item.getLunchbox_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}