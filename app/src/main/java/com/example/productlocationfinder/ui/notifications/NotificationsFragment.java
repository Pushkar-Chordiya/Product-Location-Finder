package com.example.productlocationfinder.ui.notifications;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.productlocationfinder.Adapter.ProductAdapter;
import com.example.productlocationfinder.Api.APIServices;
import com.example.productlocationfinder.Api.APIUrl;
import com.example.productlocationfinder.Model.InternetConnection;
import com.example.productlocationfinder.Model.ProductList;
import com.example.productlocationfinder.Model.ProductModel;
import com.example.productlocationfinder.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationsFragment extends Fragment {

TextView btnCall,tv_model,btnAddress,tv_purchase;
String address,phone;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
             View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        btnCall=root.findViewById(R.id.btnCall);
        tv_model=root.findViewById(R.id.tv_model);
        btnAddress=root.findViewById(R.id.btnAddress);
        tv_purchase=root.findViewById(R.id.tv_purchase);
        address=tv_purchase.getText().toString();
        phone=tv_model.getText().toString();


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posted_by = phone;
                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?daddr="+address;

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(intent);
//                Uri gmmIntentUri = Uri.parse("geo:"+lat+","+lng+"");
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//                    startActivity(mapIntent);
//                }
            }
        });


        return root;
    }

}