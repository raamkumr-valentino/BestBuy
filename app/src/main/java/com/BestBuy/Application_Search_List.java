package com.BestBuy;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

import cz.msebera.android.httpclient.Header;

public class Application_Search_List extends AppCompatActivity {
    ListView listView;
    Products_Response response;
    Custom_Adapter customAdapter;
    Gson gson;
    Toolbar toolbar;
    AsyncHttpClient client;
    DilatingDotsProgressBar dilatingDotsProgressBar;
    String query;
    String url="";
    Products_Response.ProductsBean val=new Products_Response.ProductsBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application__search__list);
        toolbar=(Toolbar)findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        listView=(ListView)findViewById(R.id.search_product_listView);
        toolbar.setNavigationIcon(R.drawable.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        Intent searchIntent=getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction()))
        {
            try {
                query = searchIntent.getStringExtra(SearchManager.QUERY);
            }catch (Exception e){}
        }
        url="https://api.bestbuy.com/v1/products((search="+query+"))?apiKey=evtrx3mbnq2ewwx5swdt62du&pageSize=40&format=json";
        dilatingDotsProgressBar= (DilatingDotsProgressBar) findViewById(R.id.progress_search);
        listView=(ListView)findViewById(R.id.search_product_listView);
        dilatingDotsProgressBar.showNow();
        client=new AsyncHttpClient();
        client.setConnectTimeout(18000);
            client.get(Application_Search_List.this, url, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    String responseString = new String(responseBody);
                    gson = new Gson();
                    response = gson.fromJson(responseString, Products_Response.class);
                    customAdapter = new Custom_Adapter(Application_Search_List.this, response.getProducts());
                    listView.setAdapter(customAdapter);
                    dilatingDotsProgressBar.hideNow();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                val=(Products_Response.ProductsBean)listView.getAdapter().getItem(position);
                Intent intent=new Intent(getApplicationContext(),Application_Product_Information.class);
                intent.putExtra("name",val.getName());
                intent.putExtra("sku",val.getSku());
                intent.putExtra("price",val.getSalePrice());
                intent.putExtra("moburl",val.getMobileUrl());
                intent.putExtra("review",val.getCustomerReviewAverage());
                intent.putExtra("lrgimg",val.getLargeFrontImage());
                intent.putExtra("clr",val.getColor());
                intent.putExtra("weight",val.getWeight());
                intent.putExtra("height",val.getHeight());
                intent.putExtra("ldescription",val.getLongDescription());
                intent.putExtra("sdescription",val.getShortDescription());
                intent.putExtra("serviceprovider",val.getServiceProvider());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
        SearchView searchView= (SearchView) menu.findItem(R.id.search_menu).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }
}
