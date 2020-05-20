package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        Button logout_Button = view.findViewById(R.id.logout_Button);
        final SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserInfo", 0);

        logout_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState), "log-out");
                editor.apply();
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        return view;
    }
}