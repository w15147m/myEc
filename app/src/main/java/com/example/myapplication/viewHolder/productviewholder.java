package com.example.myapplication.viewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interface.Interface;
import com.example.myapplication.R;

public class productviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView productdec,productprice,textproductname;
       ImageView imageView;
       Interface itemClickListener;

    public productviewholder(@NonNull View itemView) {
        super(itemView);

        productdec = imageView.findViewById(R.id.productdec);
        imageView = imageView.findViewById(R.id.imageView);
        textproductname = imageView.findViewById(R.id.textproductname);
        productprice = imageView.findViewById(R.id.productprice);
    }
   public void setItemcilcklistener(AdapterView.OnItemClickListener listener){

//        this.listener=itemClickListener
   }
    @Override
    public void onClick(View view) {

    }
}
