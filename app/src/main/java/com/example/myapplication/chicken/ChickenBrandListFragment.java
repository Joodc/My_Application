package com.example.myapplication.chicken;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class ChickenBrandListFragment extends ListFragment {
    ChickenBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new ChickenBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_bbq_logo, "BBQ", "대표메뉴 : 황금올리브치킨, 시크릿양념치킨", "주문전화 : 1588-9282");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_bhc_logo, "BHC", "대표메뉴 : 뿌링클, 맛초킹, 후라이드, 마라칸", "주문전화 : 1577-5577");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_kyochon_logo, "교촌 치킨", "대표메뉴 : 교촌 후라이드, 교촌 허니콤보", "주문전화 : 1577-1991");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_nene_logo, "네네 치킨", "대표메뉴 : 파닭순살, 쇼킹핫, 스노윙치즈", "주문전화 : 1599-4479");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_goobne_logo, "굽네 치킨", "대표메뉴 : 굽네 갈비천왕, 굽네 볼케이노", "주문전화 : 1661-9494");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        ChickenBrandListViewItem item = (ChickenBrandListViewItem) listView.getItemAtPosition(position);

        int chicken_brand_img = item.getChicken_brand_img();
        String chicken_brand_name = item.getChicken_brand_name();
        String chicken_brand_menu = item.getChicken_brand_menu();
        String chicken_brand_number = item.getChicken_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}