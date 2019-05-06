package nest.angel.smd.angelnest.data.network;

import java.util.Map;

import nest.angel.smd.angelnest.domain.model.GetCircles;
import nest.angel.smd.angelnest.domain.model.login.request.LoginRequest;
import nest.angel.smd.angelnest.domain.model.login.response.LoginResponseNew;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginNew {

    @POST("api/v1/rest-auth/login/")
    Call<LoginResponseNew> doLogin(@Body LoginRequest loginRequest);

    @GET("api/v1/circles/")
    Call<GetCircles[]> RetrieveCircles();

}
