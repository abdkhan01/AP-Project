package nest.angel.smd.angelnest.data.interactor;

import com.google.gson.JsonObject;

import java.util.Map;

import nest.angel.smd.angelnest.data.network.CentralApis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {

    private String TAG = "LoginInteractor";

    public interface RetrofitServerHit{
        void onResponse(Response<JsonObject> response);
        void onFailure();
    }


    public void sendLoginRequest(Map<String, String> request, final RetrofitServerHit retrofitServerHit) {
        //Sending Server Hit and giving response back to presenter
        CentralApis.getInstance().getAPIS().loginRequest(request, new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                retrofitServerHit.onResponse(response);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                retrofitServerHit.onFailure();
            }

        });
    }
}
