package com.BestBuy;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;

import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

public class Application_Home extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    WebView webView;
    String categoryurl="";
    Intent intent;
    DilatingDotsProgressBar dilatingDotsProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application__home);
        toolbar = (Toolbar)findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        dilatingDotsProgressBar=(DilatingDotsProgressBar)findViewById(R.id.progress);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        String Home_Page_url="http://www.bestbuy.com/";
        webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new MyBrowser());
        dilatingDotsProgressBar.showNow();
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(Home_Page_url);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_id:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.cell_phones_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=pcmcat209400050001))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.computers_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=abcat0501000))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.laptop_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=abcat0502000))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.tv_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=abcat0101000))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.home_theatre_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=pcmcat241600050001))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.tablet_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=pcmcat209000050006))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.camera_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=abcat0401000))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.video_games_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=pcmcat295700050012))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.fitness_beauty_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=pcmcat242800050021))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                    case R.id.head_phone_id:
                        categoryurl="https://api.bestbuy.com/v1/products((categoryPath.id=abcat0204000))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
                        intent=new Intent(getApplicationContext(),Application_ProductList.class);
                        intent.putExtra("categoryurl",categoryurl);
                        startActivity(intent);
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private class MyBrowser extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            actionBarDrawerToggle.syncState();
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url)
        {
            dilatingDotsProgressBar.hideNow();
            view.loadUrl("");
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack())
        {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.search_menu,menu);
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
        SearchView searchView= (SearchView) menu.findItem(R.id.search_menu).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

}
