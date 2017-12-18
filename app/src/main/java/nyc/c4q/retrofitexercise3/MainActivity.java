package nyc.c4q.retrofitexercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Dog";
    private DogService dogService;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRetrofit();

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setUpRetrofit() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dogService = retrofit.create(DogService.class);

        Call<Hound> houndCall= dogService.getHoundImages();
        houndCall.enqueue(new Callback <Hound>() {
            @Override
            public void onResponse(Call <Hound> call, Response<Hound> response) {
             List <String> dogImage = response.body().getMessage();

                Log.d(TAG, "onResponse: " + dogImage.size());


                rv.setAdapter(new HoundAdapter(dogImage, getApplicationContext()));

            }

            @Override
            public void onFailure(Call <Hound> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }
}
