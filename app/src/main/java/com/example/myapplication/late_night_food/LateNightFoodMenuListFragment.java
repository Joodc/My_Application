package com.example.myapplication.late_night_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class LateNightFoodMenuListFragment extends ListFragment {
    LateNightFoodMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new LateNightFoodMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_menu1, "닭발", "매운 닭발 하나에 주먹밥~");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_menu2, "곱창볶음", "쫄깃한 곱창 한입과 소주한잔?");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_menu3, "족발", "집에서 족발이나 뜯어야겠다");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_menu4, "모듬회", "회를 초장에 찍어 먹으면? 캬~");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_menu5, "해물파전", "비오는날엔? 막걸리랑 파전!");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        LateNightFoodMenuListViewItem item = (LateNightFoodMenuListViewItem) listView.getItemAtPosition(position);

        int late_night_food_menu_img = item.getLate_night_food_menu_img();
        String late_night_food_menu_name = item.getLate_night_food_menu_name();
        String late_night_food_menu_content = item.getLate_night_food_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}