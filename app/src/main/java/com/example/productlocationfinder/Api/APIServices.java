package com.example.productlocationfinder.Api;







import com.example.productlocationfinder.Model.DataModel;
import com.example.productlocationfinder.Model.ProductList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIServices {
    @FormUrlEncoded
    @POST("addProducts.php")
    Call<DataModel> addDriver(
            @Field("name") String name,
            @Field("model_no") String model_no,
            @Field("price") String price,
            @Field("purchase_date") String purchase_date,
            @Field("wall_number") String wall_number,
            @Field("rack_number") String rack_number,
            @Field("section") String section,
            @Field("box") String box
    );

    @GET("getAllProducts.php")
    Call<ProductList>getAllProducts();

}