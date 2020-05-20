package com.example.myapplication.late_night_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class LateNightFoodBrandListFragment extends ListFragment {
    LateNightFoodBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new LateNightFoodBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_hansin_logo, "한신포차", "대표메뉴 : 한신닭발, 한신통닭, 감바스", "주문전화 : 1544-2360");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_tudari_logo, "투다리","대표메뉴 : 투다리꼬치세트, 얼얼마라홍탕", "주문전화 : 1644-9271");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_newyork_logo, "뉴욕야시장","대표메뉴 : 뉴욕채끝스테이크, 사천순살치킨", "주문전화 : 02-326-3187");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_misoolkwan_logo, "미술관","대표메뉴 : 해물파전, 꼬막찜, 생연어사시미", "주문전화 : 1899-6096");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.late_night_food_dailybeer_logo, "생활맥주","대표메뉴 : 인생맥주, 미미네 생활 떡볶이", "주문전화 : 02-783-9663");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        LateNightFoodBrandListViewItem item = (LateNightFoodBrandListViewItem) listView.getItemAtPosition(position);

        int late_night_food_brand_img = item.getLate_night_food_brand_img();
        String late_night_food_brand_name = item.getLate_night_food_brand_name();
        String late_night_food_brand_menu = item.getLate_night_food_brand_menu();
        String late_night_food_brand_number = item.getLate_night_food_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}