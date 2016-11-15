package com.BestBuy;

import android.app.SearchManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Application_Product_Information extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView tittle,sku,price,review,sdes,color,weight,height,ldes,mobile,servive;
    FloatingActionButton fabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application__product__information);
        toolbar=(Toolbar)findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        tittle=(TextView)findViewById(R.id.tittle_pip);
        sku=(TextView)findViewById(R.id.sku_id);
        price=(TextView)findViewById(R.id.price_pip);
        review=(TextView)findViewById(R.id.review_pip);
        sdes=(TextView)findViewById(R.id.sdes_pip);
        color=(TextView)findViewById(R.id.color_pip);
        weight=(TextView)findViewById(R.id.weight_pip);
        height=(TextView)findViewById(R.id.height_pip);
        ldes=(TextView)findViewById(R.id.ldes_pip);
        servive=(TextView)findViewById(R.id.sprovider_pip);
        mobile=(TextView)findViewById(R.id.moburl_pip);
        toolbar.setNavigationIcon(R.drawable.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imageView=(ImageView)findViewById(R.id.img_pip);
        String sname=getIntent().getStringExtra("name");
        String ssku=getIntent().getStringExtra("sku");
        String sprice="$"+getIntent().getStringExtra("price");
        final String smoburl=getIntent().getStringExtra("moburl");
        String sreview=getIntent().getStringExtra("review");
        String slrgimg=getIntent().getStringExtra("lrgimg");
        String sclr=getIntent().getStringExtra("clr");
        String sweight=getIntent().getStringExtra("weight");
        String sheight=getIntent().getStringExtra("height");
        String sldescription=getIntent().getStringExtra("ldescription");
        String ssdescription=getIntent().getStringExtra("sdescription");
        String sserviceprovider=getIntent().getStringExtra("serviceprovider");
        Picasso.with(this).load(slrgimg).into(imageView);
        tittle.setText(sname);
        sku.setText(ssku);
        price.setText(sprice);
        review.setText(sreview);
        sdes.setText(ssdescription);
        color.setText(sclr);
        weight.setText(sweight);
        height.setText(sheight);
        ldes.setText(sldescription);
        servive.setText(sserviceprovider);
        mobile.setText(smoburl);
        fabtn=(FloatingActionButton)findViewById(R.id.fab);
        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT,"Share");
                share.putExtra(Intent.EXTRA_TEXT,smoburl);
                startActivity(Intent.createChooser(share,"share & enjoy"));
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
