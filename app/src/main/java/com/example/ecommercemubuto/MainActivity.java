package com.example.ecommercemubuto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ecommercemubuto.helper.BottomNavigationViewHelper;
import com.example.ecommercemubuto.ui.AccountActivity;
import com.example.ecommercemubuto.ui.CartActivity;
import com.example.ecommercemubuto.ui.FavoriteActivity;
import com.example.ecommercemubuto.ui.FragmentFive;
import com.example.ecommercemubuto.ui.FragmentFour;
import com.example.ecommercemubuto.ui.FragmentOne;
import com.example.ecommercemubuto.ui.FragmentSeven;
import com.example.ecommercemubuto.ui.FragmentSix;
import com.example.ecommercemubuto.ui.FragmentThree;
import com.example.ecommercemubuto.ui.FragmentTwo;
import com.example.ecommercemubuto.ui.SearchActivity;
import com.example.ecommercemubuto.ui.adapter.ViewPagerAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class MainActivity extends AppCompatActivity {
MaterialSearchView materialSearchView;
String[] list;


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private BottomNavigationView bottomNavigationView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item=menu.findItem(R.id.search_menu);
        materialSearchView.setMenuItem(item);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        list=new String[]{"Dress","T-shirt","Shoe","Bag","Skirt","Jacket"};
        materialSearchView=findViewById(R.id.material_search);
        materialSearchView.closeSearch();
        materialSearchView.setSuggestions(list);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });




        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentOne(), "WOMAN");
        adapter.AddFragment(new FragmentTwo(), "MALE");
        adapter.AddFragment(new FragmentThree(), "CHILD");
        adapter.AddFragment(new FragmentFour(), "SHOE & BAG");
        adapter.AddFragment(new FragmentFive(), "ACCESSORIES");
        adapter.AddFragment(new FragmentSix(), "COSMETIC");
        adapter.AddFragment(new FragmentSeven(), "HOME & LIFE");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_search:
                        Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.navigation_favorite:
                        Intent intent2 = new Intent(MainActivity.this, FavoriteActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.navigation_cart:
                        Intent intent3 = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.navigation_account:
                        Intent intent4 = new Intent(MainActivity.this, AccountActivity.class);
                        startActivity(intent4);
                        break;


                }
                return false;
            }
        });
    }



}