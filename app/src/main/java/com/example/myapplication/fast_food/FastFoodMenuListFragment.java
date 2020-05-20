package com.example.myapplication.fast_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class FastFoodMenuListFragment extends ListFragment {
    FastFoodMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new FastFoodMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_menu1, "치즈버거", "버거 중의 근본!");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_menu2, "불고기버거", "우리나라 대표 버거!!");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_menu3, "치킨버거", "치킨의 두툼한 패티!");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_menu4, "새우버거", "새우버거의 담백한 맛");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.fast_food_menu5, "수제버거", "수제버거만의 차별적 높이!");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        FastFoodMenuListViewItem item = (FastFoodMenuListViewItem) listView.getItemAtPosition(position);

        int fast_food_menu_img = item.getFast_food_menu_img();
        String fast_food_menu_name = item.getFast_food_menu_name();
        String fast_food_menu_content = item.getFast_food_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}