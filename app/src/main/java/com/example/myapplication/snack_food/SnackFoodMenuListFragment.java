package com.example.myapplication.snack_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class SnackFoodMenuListFragment extends ListFragment {
    SnackFoodMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new SnackFoodMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_menu1, "떡볶이", "쫀득쫀득한 떡볶이 먹고싶다...");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_menu2, "김밥", "잘 말아쭤~~");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_menu3, "만두", "쌀쌀한 날에는 만두 한입?");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_menu4, "튀김", "튀김은 진리다!");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.snack_food_menu5, "순대", "분식의 다크호스");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        SnackFoodMenuListViewItem item = (SnackFoodMenuListViewItem) listView.getItemAtPosition(position);

        int snack_food_menu_img = item.getSnack_food_menu_img();
        String snack_food_menu_name = item.getSnack_food_menu_name();
        String snack_food_menu_content = item.getSnack_food_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}