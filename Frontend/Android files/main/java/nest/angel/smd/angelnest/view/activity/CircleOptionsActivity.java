package nest.angel.smd.angelnest.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.classes.Circles;
import nest.angel.smd.angelnest.data.network.LoginNew;
import nest.angel.smd.angelnest.domain.model.GetCircles;
import nest.angel.smd.angelnest.domain.model.login.request.LoginRequest;
import nest.angel.smd.angelnest.domain.model.login.response.LoginResponseNew;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CircleOptionsActivity extends ParentActivity {
    private List<Circles> circlesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CircleOptionsRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_options);

        recyclerView = findViewById(R.id.circle_options_recyclerview);

        mAdapter = new CircleOptionsRecyclerAdapter(circlesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        initiateCirclesApi();
    }

    private void initiateCirclesApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivityNew.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginNew api = retrofit.create(LoginNew.class);
        Call<GetCircles[]> call = api.RetrieveCircles();
        call.enqueue(new Callback<GetCircles[]>() {

            @Override
            public void onResponse(Call<GetCircles[]> call,Response<GetCircles[]> response) {
                if (response.isSuccessful()) {
                    String result = response.body().toString();
                    GetCircles[] circleAll = response.body();
                    Log.d("Circles","Circles fetched");


                } else {
                    Log.d("LOGIN", "failure response is " + response.raw().toString());

                }
            }

            @Override
            public void onFailure(Call<GetCircles[]> call, Throwable t) {
                Log.d("LOGIN", " Error :  " + t.getMessage());

            }
        });


    }
}
