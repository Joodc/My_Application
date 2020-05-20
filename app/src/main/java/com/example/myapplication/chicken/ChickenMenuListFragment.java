package com.example.myapplication.chicken;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class ChickenMenuListFragment extends ListFragment {
    ChickenMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new ChickenMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_menu1, "후라이드 치킨", "바삭바삭한 후라이드 치킨!");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_menu2, "양념 치킨","단짠단짠 양념 치킨이 짱");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_menu3, "간장 치킨","간장 소스와 치킨의 조화!");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_menu4, "스노윙 치킨","치즈가루가 솔솔 뿌려져 고소한 맛");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.chicken_menu5, "핫 치킨","스트레스가 확 풀리게 매운맛");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        ChickenMenuListViewItem item = (ChickenMenuListViewItem) listView.getItemAtPosition(position);

        int chicken_menu_img = item.getChicken_menu_img();
        String chicken_menu_name = item.getChicken_menu_name();
        String chicken_menu_content = item.getChicken_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}