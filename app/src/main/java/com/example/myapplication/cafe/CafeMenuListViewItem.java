package com.example.myapplication.cafe;

public class CafeMenuListViewItem {
    private int cafe_menu_img;
    private String cafe_menu_name;
    private String cafe_menu_content;

    public int getCafe_menu_img() {
        return this.cafe_menu_img;
    }

    public String getCafe_menu_name() {
        return this.cafe_menu_name;
    }

    public String getCafe_menu_content() {
        return this.cafe_menu_content;
    }

    public void setCafe_menu_img(int cafe_menu_img) {
        this.cafe_menu_img = cafe_menu_img;
    }

    public void setCafe_menu_name(String cafe_menu_name) {
        this.cafe_menu_name = cafe_menu_name;
    }

    public void setCafe_menu_content(String cafe_menu_content) {
        this.cafe_menu_content = cafe_menu_content;
    }
}