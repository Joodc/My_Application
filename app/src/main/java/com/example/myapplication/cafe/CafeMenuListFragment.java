package com.example.myapplication.cafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class CafeMenuListFragment extends ListFragment {
    CafeMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new CafeMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_menu1, "아이스 아메리카노", "시원한 아메리카노 한잔의 여유~");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_menu2, "밀크티", "달짝찌근한 밀크티의 달달함");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_menu3, "카페라떼", "따뜻함 속에 묻어나는 부드러움");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_menu4, "버블티", "버블티 한잔이면 배가 든든");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.cafe_menu5, "스무디", "머리가 띵! 스무디~~");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        CafeMenuListViewItem item = (CafeMenuListViewItem) listView.getItemAtPosition(position);

        int cafe_menu_img = item.getCafe_menu_img();
        String cafe_menu_name = item.getCafe_menu_name();
        String cafe_menu_content = item.getCafe_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}