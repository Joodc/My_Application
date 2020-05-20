package com.example.myapplication.lunchbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class LunchboxMenuListFragment extends ListFragment {
    LunchboxMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new LunchboxMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_menu1, "참치 마요 덮밥", "학생들이 좋아하는 도시락 1위");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_menu2, "돈까스 도시락", "돈까스 좋아하세요?~-~");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_menu3, "제육 덮밥", "제육덮밥은 무조건 곱빼기!");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_menu4, "연어 덮밥", "입안에 살살녹는 연어ㅠ");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.lunchbox_menu5, "옛날 도시락", "나 때는 말이야!");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        LunchboxMenuListViewItem item = (LunchboxMenuListViewItem) listView.getItemAtPosition(position);

        int lunchbox_menu_img = item.getLunchbox_menu_img();
        String lunchbox_menu_name = item.getLunchbox_menu_name();
        String lunchbox_menu_content = item.getLunchbox_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}