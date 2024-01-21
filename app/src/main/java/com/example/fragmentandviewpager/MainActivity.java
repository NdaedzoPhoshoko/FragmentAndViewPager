package com.example.fragmentandviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.main_viewpager); //initialize the viewpager2 to the one on activity_main.xml
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        viewPagerAdapter.addFragment(new Fragment_Instruction_1()); //adding all fragments
        viewPagerAdapter.addFragment(new Fragment_Instruction_2());
        viewPagerAdapter.addFragment(new Fragment_Instruction_3());

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); //set orientation to horizontal
        viewPager.setAdapter(viewPagerAdapter); //give the adapter and its data to viewpager2
    }
}