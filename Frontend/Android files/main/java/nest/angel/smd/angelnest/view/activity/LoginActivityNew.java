package nest.angel.smd.angelnest.view.activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nest.angel.smd.angelnest.R;
import nest.angel.smd.angelnest.data.network.LoginNew;
import nest.angel.smd.angelnest.domain.model.login.request.LoginRequest;
import nest.angel.smd.angelnest.domain.model.login.response.LoginResponseNew;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivityNew extends AppCompatActivity {

    public static String API_BASE_URL = "http://10.0.2.2:8000/";
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private String key;
    @InjectView(R.id.input_email) EditText _emailText;
    @InjectView(R.id.input_password) EditText _passwordText;
    @InjectView(R.id.btn_login) Button _loginButton;
    @InjectView(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
        Log.d("loginTAg","LoginComplete");
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() ) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private void initiateRestaurantApi(String username, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();




        LoginRequest loginRequest = new LoginRequest(username,password);
        LoginNew api = retrofit.create(LoginNew.class);
        Call<LoginResponseNew> call = api.doLogin(loginRequest);
        call.enqueue(new Callback<LoginResponseNew>() {

            @Override
            public void onResponse(Call<LoginResponseNew> call, Response<LoginResponseNew> response) {
                if(response.isSuccessful()) {
                    String result = response.body().toString();
                    LoginResponseNew loginResponseNew = response.body();
                    Log.d("LOGIN",loginResponseNew.getKey().toString());
                    Log.d("LOGIN",Integer.toString(loginResponseNew.getId()));

                    Intent intent = new Intent(LoginActivityNew.this, MainActivity.class);
                    startActivity(intent);



                } else {
                    Log.d("LOGIN", "failure response is " + response.raw().toString());

                }
            }

            @Override
            public void onFailure(Call<LoginResponseNew> call, Throwable t) {
                Log.d("LOGIN", " Error :  " + t.getMessage());

            }
        });



    }
    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivityNew.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        initiateRestaurantApi(email,password);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    }