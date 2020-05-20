package com.example.myapplication.korean_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class KoreanFoodBrandListFragment  extends ListFragment {
    KoreanFoodBrandAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new KoreanFoodBrandAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_wonbossam_logo, "원할머니 보쌈.족발", "대표메뉴 : 의성마늘 떡 보쌈, 매운 족발", "주문전화 : 1599-5353");
        // 두 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_nolbu_logo, "놀부 부대찌개","대표메뉴 : 놀부부대세트, 쭈꾸미 삼겹철판", "주문전화 : 1577-6877");
        // 세 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_paik_logo, "백철판0410","대표메뉴 : 치즈매운철판닭갈비, 냄비떡볶이", "주문전화 : 1544-2360");
        // 네 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_galtongsam_logo, "갈통삼","대표메뉴 : 삼겹목살구이, 등심스테이크", "주문전화 : 1661-1758");
        // 다섯 번째 아이템 추가.
        adapter.addItem(R.drawable.korean_food_yooganae_logo, "유가네 닭갈비","대표메뉴 : 유가네 닭갈비, 사천마라닭갈비", "주문전화 : 1661-9922");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        KoreanFoodBrandListViewItem item = (KoreanFoodBrandListViewItem) listView.getItemAtPosition(position);

        int korean_food_brand_img = item.getKorean_food_brand_img();
        String korean_food_brand_name = item.getKorean_food_brand_name();
        String korean_food_brand_menu = item.getKorean_food_brand_menu();
        String korean_food_brand_number = item.getKorean_food_brand_number();

        //use item data.
    }

    //ListFragment 외부(Activity)에서 아이템 추가를 위한 함수
    public void addItem(int img, String name, String menu, String number) { adapter.addItem(img, name, menu, number); }
}