package nest.angel.smd.angelnest.view.activity;

import java.util.Map;

import nest.angel.smd.angelnest.data.interactor.LoginInteractor;
import nest.angel.smd.angelnest.data.network.ObjectMapper;
import nest.angel.smd.angelnest.domain.parent.ParentActivity;
import nest.angel.smd.angelnest.domain.presenter.LoginPresenter;
import nest.angel.smd.angelnest.view.interfaces.ILoginView;

public class LoginActivity extends ParentActivity implements ILoginView {

    private void PerformLogin(String email, String password){
        Map<String, String> request = ObjectMapper.getLoginMapping("email@yahoo.com", "1234");

        LoginPresenter loginPresenter = new LoginPresenter(this, new LoginInteractor());
        loginPresenter.sendLoginRequest(request);
    }
    @Override
    public void showSuccess() {
        //it will be called by login presenter (on success) after it gets a success response from interactor.
    }

    @Override
    public void showError() {
        //it will be called by login presenter (on failure) after it gets a failure response from interactor.
    }
}
