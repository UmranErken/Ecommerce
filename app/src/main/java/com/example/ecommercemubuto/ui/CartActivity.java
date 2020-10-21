package com.example.ecommercemubuto.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.ecommercemubuto.MainActivity;
import com.example.ecommercemubuto.R;
import com.example.ecommercemubuto.helper.BottomNavigationViewHelper;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class CartActivity extends AppCompatActivity {
    MaterialSearchView materialSearchView;
    String[] list;

    private ExpandableListView expandableListView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item=menu.findItem(R.id.search_menu);
        materialSearchView.setMenuItem(item);
        return true;
    }


    private BottomNavigationView bottomNavigationView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

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


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_cart);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent = new Intent(CartActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_search:
                        Intent intent1 = new Intent(CartActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.navigation_favorite:
                        Intent intent2 = new Intent(CartActivity.this, FavoriteActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.navigation_cart:

                        break;
                    case R.id.navigation_account:
                        Intent intent4 = new Intent(CartActivity.this, AccountActivity.class);
                        startActivity(intent4);
                        break;


                }
                return false;
            }
        });


    }
}
