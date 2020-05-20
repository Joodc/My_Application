package com.example.myapplication.pizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class PizzaBrandListFragment extends ListFragment {
    PizzaBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new PizzaBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_domino_logo, "도미노피자", "대표메뉴 : 직화 스테이크피자, 포테이토피자", "주문전화 : 1577-3082");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_pizzahut_logo, "피자헛","대표메뉴 : 치즈판타지피자, 수퍼슈프림피자", "주문전화 : 1588-5588");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_pizzaschool_logo, "피자스쿨","대표메뉴 : 치킨퀘사디아피자, 까르보네피자", "주문전화 : 02-844-7070");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_mrpizza_logo, "미스터피자","대표메뉴 : 쉬림프골드피자, 포테이토골드피자", "주문전화 : 1577-0077");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.pizza_pizzamaru_logo, "피자마루","대표메뉴 : 몬스터 피자, 시가코 피자", "주문전화 : 1800-1082");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        PizzaBrandListViewItem item = (PizzaBrandListViewItem) listView.getItemAtPosition(position);

        int pizza_brand_img = item.getPizza_brand_img();
        String pizza_brand_name = item.getPizza_brand_name();
        String pizza_brand_menu = item.getPizza_brand_menu();
        String pizza_brand_number = item.getPizza_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}