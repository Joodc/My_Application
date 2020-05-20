package com.example.myapplication.cafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class CafeBrandListFragment extends ListFragment {
    CafeBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new CafeBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_starbucks_logo, "스타벅스", "대표메뉴 : 황금올리브치킨, 시크릿양념치킨", "주문전화 : 1588-9282");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_ediya_logo, "이디야 커피", "대표메뉴 : 뿌링클, 맛초킹, 후라이드, 마라칸", "주문전화 : 1577-5577");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_paik_logo, "빽다방", "대표메뉴 : 교촌 후라이드, 교촌 허니콤보", "주문전화 : 1577-1991");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_twosome_logo, "투썸플레이스", "대표메뉴 : 파닭순살, 쇼킹핫, 스노윙치즈", "주문전화 : 1599-4479");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_mega_logo, "메가 커피", "대표메뉴 : 굽네 갈비천왕, 굽네 볼케이노", "주문전화 : 1661-9494");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        CafeBrandListViewItem item = (CafeBrandListViewItem) listView.getItemAtPosition(position);

        int cafe_brand_img = item.getCafe_brand_img();
        String cafe_brand_name = item.getCafe_brand_name();
        String cafe_brand_menu = item.getCafe_brand_menu();
        String cafe_brand_number = item.getCafe_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}