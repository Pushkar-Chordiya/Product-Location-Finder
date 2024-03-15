package com.example.productlocationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {


TextView tv_name,tv_price,tv_model,tv_purchase,tv_location;
String name,price,model_no,date,wall,rack,section,box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        price=intent.getStringExtra("price");
        model_no=intent.getStringExtra("model_no");
        date=intent.getStringExtra("date");
        wall=intent.getStringExtra("wall");
        rack=intent.getStringExtra("rack");
        section=intent.getStringExtra("section");
        box=intent.getStringExtra("box");


        tv_name=findViewById(R.id.tv_name);
        tv_price=findViewById(R.id.tv_price);
        tv_model=findViewById(R.id.tv_model);
        tv_purchase=findViewById(R.id.tv_purchase);
        tv_location=findViewById(R.id.tv_location);

        tv_name.setText(name);
        tv_price.setText(price);
        tv_model.setText(model_no);
        tv_purchase.setText(date);
        tv_location.setText(wall+","+rack+",Section\t"+section+",Box\t"+box);
    }
}