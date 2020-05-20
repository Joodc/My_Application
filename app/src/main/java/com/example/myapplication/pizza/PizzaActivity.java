package com.example.myapplication.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.FoodPagerAdapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class PizzaActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    FoodPagerAdapter adapter = new FoodPagerAdapter(getSupportFragmentManager());
    TextView food_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        food_Text = findViewById(R.id.food_Text);
        food_Text.setText(R.string.pizza);

        mViewPager = findViewById(R.id.food_Container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.food_TabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new PizzaBrandListFragment(), "브랜드");
        adapter.addFragment(new PizzaMenuListFragment(), "메뉴");
        viewPager.setAdapter(adapter);
    }
}