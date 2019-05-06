package nest.angel.smd.angelnest.domain.presenter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

import nest.angel.smd.angelnest.data.interactor.LoginInteractor;
import nest.angel.smd.angelnest.domain.model.login.response.LoginResponse;
import nest.angel.smd.angelnest.view.interfaces.ILoginView;
import retrofit2.Response;

public class LoginPresenter {
    private ILoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(ILoginView loginView, LoginInteractor loginInteractor){
        this.loginView  =   loginView;
        this.loginInteractor = loginInteractor;
    }

    public void sendLoginRequest(Map<String, String> request){
        loginInteractor.sendLoginRequest(request, new LoginInteractor.RetrofitServerHit() {
            @Override
            public void onResponse(Response<JsonObject> response) {
                if (response.code() == 200) {
                    Gson gson = new Gson();
                    LoginResponse loginResponse = gson.fromJson(response.body(), LoginResponse.class);
                    //Model is mapped, not we can use login response.
                    loginView.showSuccess();
                }else{
                    loginView.showError();
                }

            }

            @Override
            public void onFailure() {
                loginView.showError();
            }
        });

    }
}
