package com.example.productlocationfinder.ui.dashboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.productlocationfinder.Api.APIServices;
import com.example.productlocationfinder.Api.APIUrl;
import com.example.productlocationfinder.MainActivity;
import com.example.productlocationfinder.Model.DataModel;
import com.example.productlocationfinder.R;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardFragment extends Fragment {

EditText edtName,edtModel,edtPrice,edtPurchaseDate,edtSection,edtBox;
Spinner spinner_wall,spinner_rack;
ProgressDialog progressDialog;
TextView btnSubmit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
              View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        edtModel=root.findViewById(R.id.edtModel);
        edtPrice=root.findViewById(R.id.edtPrice);
        edtPurchaseDate=root.findViewById(R.id.edtPurchaseDate);
        edtSection=root.findViewById(R.id.edtSection);
        edtBox=root.findViewById(R.id.edtBox);
        spinner_wall=root.findViewById(R.id.spinner_wall);
        spinner_rack=root.findViewById(R.id.spinner_rack);
        edtName=root.findViewById(R.id.edtName);
        btnSubmit=root.findViewById(R.id.btnSubmit);
        progressDialog=new ProgressDialog(getActivity());


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                String model_no=edtModel.getText().toString();
                String price=edtPrice.getText().toString();
                String purchase_date=edtPurchaseDate.getText().toString();
                String wall_number=spinner_wall.getSelectedItem().toString();
                String rack_number=spinner_rack.getSelectedItem().toString();
                String section = edtSection.getText().toString();
                String box=edtBox.getText().toString();


                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(model_no)||TextUtils.isEmpty(price)||
                TextUtils.isEmpty(purchase_date)||TextUtils.isEmpty(section)||TextUtils.isEmpty(box)){
                    Toast.makeText(getActivity(), "Please Enter All Fields Properly", Toast.LENGTH_SHORT).show();
                }else if (wall_number.equalsIgnoreCase("Select Wall")){
                    Toast.makeText(getActivity(), "Select Wall", Toast.LENGTH_SHORT).show();
                }else if (rack_number.equalsIgnoreCase("Select Rack")){
                    Toast.makeText(getActivity(), "Select Rack", Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.show();
                    addProduct(name,model_no,price,purchase_date,wall_number,rack_number,section,box);
                }
            }
        });

        return root;
    }

    private void addProduct(String name, String model_no, String price, String purchase_date, String wall_number, String rack_number, String section, String box) {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIServices api=retrofit.create(APIServices.class);
        Call<DataModel> call= api.addDriver(name,model_no,price,purchase_date,wall_number,rack_number,section,box);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel resp = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (resp != null) {
                        if (resp.getRegistrationResult().getMessage().equals("Inserted Successfully")) {
                            Toast.makeText(getActivity(), "Success.....", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }else {
                            Toast.makeText(getActivity(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    } else {
                        Toast.makeText(getActivity(), "No User Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    progressDialog.dismiss();
                    // error case
                    System.out.println("Error : " + response.errorBody());
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(getActivity(), "Server Error 404", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(getActivity(), "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getActivity(), "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

    }
}