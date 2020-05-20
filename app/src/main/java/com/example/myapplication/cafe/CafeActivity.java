package com.example.myapplication.cafe;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.FoodPagerAdapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class CafeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    FoodPagerAdapter adapter = new FoodPagerAdapter(getSupportFragmentManager());
    TextView food_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        food_Text = findViewById(R.id.food_Text);
        food_Text.setText(R.string.cafe);

        mViewPager = findViewById(R.id.food_Container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.food_TabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new CafeBrandListFragment(), "브랜드");
        adapter.addFragment(new CafeMenuListFragment(), "메뉴");
        viewPager.setAdapter(adapter);
    }
}