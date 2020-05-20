package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.cafe.CafeActivity;
import com.example.myapplication.chicken.ChickenActivity;
import com.example.myapplication.chinese_food.ChineseFoodActivity;
import com.example.myapplication.fast_food.FastFoodActivity;
import com.example.myapplication.korean_food.KoreanFoodActivity;
import com.example.myapplication.late_night_food.LateNightFoodActivity;
import com.example.myapplication.lunchbox.LunchboxActivity;
import com.example.myapplication.map.Real_Write_Address;
import com.example.myapplication.pizza.PizzaActivity;
import com.example.myapplication.snack_food.SnackFoodActivity;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView user_address_Text = view.findViewById(R.id.user_address_Text);
        ImageButton korean_food_button = view.findViewById(R.id.korean_food_button);
        ImageButton snack_food_button = view.findViewById(R.id.snack_food_button);
        ImageButton cafe_button = view.findViewById(R.id.cafe_button);
        ImageButton chicken_button = view.findViewById(R.id.chicken_button);
        ImageButton pizza_button = view.findViewById(R.id.pizza_button);
        ImageButton fast_food_button = view.findViewById(R.id.fast_food_button);
        ImageButton chinese_food_button = view.findViewById(R.id.chinese_food_button);
        ImageButton late_night_food_button = view.findViewById(R.id.late_night_food_button);
        ImageButton lunchbox_button = view.findViewById(R.id.lunchbox_button);
        Button search_Button = view.findViewById(R.id.search_Button);

        user_address_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user_address_Intent = new Intent(getActivity(), Real_Write_Address.class);
                startActivity(user_address_Intent);
            }
        });

        korean_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent korean_food_Intent = new Intent(getActivity(), KoreanFoodActivity.class);
                startActivity(korean_food_Intent);
            }
        });
        snack_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent snack_food_Intent = new Intent(getActivity(), SnackFoodActivity.class);
                startActivity(snack_food_Intent);
            }
        });
        cafe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cafe_Intent = new Intent(getActivity(), CafeActivity.class);
                startActivity(cafe_Intent);
            }
        });
        chicken_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chicken_Intent = new Intent(getActivity(), ChickenActivity.class);
                startActivity(chicken_Intent);
            }
        });
        pizza_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pizza_Intent = new Intent(getActivity(), PizzaActivity.class);
                startActivity(pizza_Intent);
            }
        });
        fast_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast_food_Intent = new Intent(getActivity(), FastFoodActivity.class);
                startActivity(fast_food_Intent);
            }
        });
        chinese_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chinese_food_Intent = new Intent(getActivity(), ChineseFoodActivity.class);
                startActivity(chinese_food_Intent);
            }
        });
        late_night_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent late_night_food_Intent = new Intent(getActivity(), LateNightFoodActivity.class);
                startActivity(late_night_food_Intent);
            }
        });
        lunchbox_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lunchbox_Intent = new Intent(getActivity(), LunchboxActivity.class);
                startActivity(lunchbox_Intent);
            }
        });

        search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search_Intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(search_Intent);
            }
        });

        return view;
    }
}