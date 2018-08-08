package com.blogspot.programer27android.taber;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.blogspot.programer27android.taber.tab.Adapters;
import com.blogspot.programer27android.taber.tab.SlidingTabLayoutt;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private SlidingTabLayoutt msliding;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=findViewById(R.id.apbar);
        setSupportActionBar(mToolbar);

        mViewPager = findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new Adapters(getSupportFragmentManager(),this));

        msliding = (SlidingTabLayoutt) findViewById(R.id.st1_tabs);
        msliding.setDistributeEvenly(true);
        msliding.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        msliding.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        msliding.setCustomTabView(R.layout.tab_view,R.id.tv_tab);
        msliding.setViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tiga,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.action){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
