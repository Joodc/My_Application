package com.example.myapplication.korean_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class KoreanFoodMenuListFragment extends ListFragment {
    KoreanFoodMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new KoreanFoodMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_menu1, "삼겹살", "미세먼지 많은 날 삼겹살로!");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_menu2, "김치찌개", "얼큰한 김치찌개 한입?");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_menu3, "찜닭", "찜닭 한입 당면 한입 국물 한입");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_menu4, "감자탕", "오늘은 등뼈를 뜯고 싶다..");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_menu5, "죽", "몸이 아플때는 죽 먹고 쉬자");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        KoreanFoodMenuListViewItem item = (KoreanFoodMenuListViewItem) listView.getItemAtPosition(position);

        int korean_food_menu_img = item.getKorean_food_menu_img();
        String korean_food_menu_name = item.getKorean_food_menu_name();
        String korean_food_menu_content = item.getKorean_food_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}