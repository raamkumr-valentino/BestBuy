package com.BestBuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by RaamKumr on 7/14/2016.
 */
public class Custom_Adapter extends BaseAdapter{

    private List<Products_Response.ProductsBean> items;
    private Context context;
    private LayoutInflater layoutInflater;

    public Custom_Adapter(Context context, List<Products_Response.ProductsBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.product_list_style,parent,false);
        Products_Response.ProductsBean item=(Products_Response.ProductsBean)getItem(position);
        ImageView thumbnail= (ImageView) rowView.findViewById(R.id.img_id1);
        TextView name=(TextView)rowView.findViewById(R.id.txt_id1);
        TextView price=(TextView)rowView.findViewById(R.id.txt_id2);
        TextView availability=(TextView)rowView.findViewById(R.id.txt_id3);
        String image=item.getLargeFrontImage();
        Picasso.with(context).load(image).into(thumbnail);
        name.setText(item.getName());
        price.setText(item.getSalePrice());
        availability.setText(item.getOnlineAvailabilityText());
        return rowView;
    }
}
