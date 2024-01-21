package com.example.fragmentandviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.main_viewpager); //initialize the viewpager2 to the one on activity_main.xml
        tabLayout = (TabLayout) findViewById(R.id.main_tabLayout); //init tabLayout

        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter( //declare adapter with this activity's fragment manager and its life cycle
                getSupportFragmentManager(),
                getLifecycle()
        );

        viewPagerAdapter.addFragment(new Fragment_Instruction_1()); //adding all fragments
        viewPagerAdapter.addFragment(new Fragment_Instruction_2());
        viewPagerAdapter.addFragment(new Fragment_Instruction_3());

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); //set orientation to horizontal
        viewPager.setAdapter(viewPagerAdapter); //give the adapter and its data to viewpager2

        //connect tabLayout with the viewPager
        new TabLayoutMediator(tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        //customize your tab here, note: position starts from 0 to n-1 (n is number of fragments)
                        String tabName = "";
                        switch(position) //switch that reads position of tab
                        {
                            case 0:
                                tabName = "One";
                                break;
                            case 1:
                                tabName = "Two";
                                break;
                            case 2:
                                tabName = "Three";
                                break;
                            default:
                                break;
                        }
                        tab.setText(tabName);
                    }
                }).attach(); //attach this customization to the current activity
    }
}