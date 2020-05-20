package com.example.myapplication.chinese_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class ChineseFoodMenuListFragment extends ListFragment {
    ChineseFoodMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new ChineseFoodMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_menu1, "짜장면", "짜증날땐? 짜장면!");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_menu2, "짬뽕", "얼큰한 짬뽕!");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_menu3, "탕수육", "부먹?찍먹?걍먹!");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_menu4, "볶음밥", "복잡할땐? 볶음밥!");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_menu5, "마라탕", "입안이 얼얼한 마라탕");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        ChineseFoodMenuListViewItem item = (ChineseFoodMenuListViewItem) listView.getItemAtPosition(position);

        int chinese_food_menu_img = item.getChinese_food_menu_img();
        String chinese_food_menu_name = item.getChinese_food_menu_name();
        String chinese_food_menu_content = item.getChinese_food_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}