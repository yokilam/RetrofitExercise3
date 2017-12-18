package nyc.c4q.retrofitexercise3;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yokilam on 12/17/17.
 */

public interface DogService {

    @GET("/api/breed/hound/images")
    Call<Hound> getHoundImages();
}
