package com.example.myapplication.chinese_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class ChineseFoodBrandListFragment extends ListFragment {
    ChineseFoodBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new ChineseFoodBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_hong_logo, "홍짜장", "대표메뉴 : 해물쟁반짜장, 홍탕수육", "주문전화 : 1688-7785");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_hongkong_logo, "홍콩반점0410","대표메뉴 : 고추짬뽕, 볶음짬뽕, 깐풍기", "주문전화 : 1577-5577");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_lahwakungbu_logo, "라화쿵부","대표메뉴 : 마라향궈, 꿔바로우, 운남쌀국수", "주문전화 : 1588-1912");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_chakhan_logo, "착한 쭝식","대표메뉴 : 옛날짜장면, 탕수육, 크림새우", "주문전화 : 1800-3234");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.chinese_food_kyoddong_logo, "교동 짬뽕", "대표메뉴 : 짜장면, 짬뽕, 탕수육", "주문전화 : 1661-9494");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        ChineseFoodBrandListViewItem item = (ChineseFoodBrandListViewItem) listView.getItemAtPosition(position);

        int chinese_food_brand_img = item.getChinese_food_brand_img();
        String chinese_food_brand_name = item.getChinese_food_brand_name();
        String chinese_food_brand_menu = item.getChinese_food_brand_menu();
        String chinese_food_brand_number = item.getChinese_food_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}