package com.example.myapplication.pizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class PizzaMenuListFragment extends ListFragment {
    PizzaMenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new PizzaMenuAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_menu1, "치즈 피자", "피자의 근본! 치즈만으로 충분하다!");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_menu2, "고르곤졸라", "조청 하나면 단짠 조합 완성");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_menu3, "불고기 피자", "불고기 듬뿍 올린 맛있는 피자");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_menu4, "쉬림프 피자", "새우와 치즈가 은근 꿀조합");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_menu5, "콤비네이션 피자", "고르기 힘들면 무조건 콤비네이션!");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        PizzaMenuListViewItem item = (PizzaMenuListViewItem) listView.getItemAtPosition(position);

        int pizza_menu_img = item.getPizza_menu_img();
        String pizza_menu_name = item.getPizza_menu_name();
        String pizza_menu_content = item.getPizza_menu_content();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String content) { adapter.addItem(img, name, content); }
}