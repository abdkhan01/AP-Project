package nest.angel.smd.angelnest.data.network;

import com.google.gson.JsonObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import nest.angel.smd.angelnest.BuildConfig;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class CentralApis {

        private static CentralApis centralApis = null;
        private APIS apis;


        public static CentralApis getInstance(){
            if(centralApis ==  null){
                centralApis = new CentralApis();
            }
            return centralApis;
        }

        private CentralApis(){

            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("TLS");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            }else{
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };
            try {
                if (sslContext != null) {
                    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                    okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder()
                            .sslSocketFactory(sslContext.getSocketFactory())
                            .readTimeout(60, TimeUnit.SECONDS)
                            .writeTimeout(60, TimeUnit.SECONDS)
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .addInterceptor(interceptor)
                            .addInterceptor(new UserAgentInterceptor("AngelNest - " + BuildConfig.VERSION_NAME))
                            .build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(APIUrl.BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    apis = retrofit.create(APIS.class);
                }
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }

        public interface APIS{

            @FormUrlEncoded
            @POST("/" + APIUrl.API_LOGIN)
            void loginRequest(@FieldMap Map<String, String> params, Callback<JsonObject> response);

        }
        public APIS getAPIS(){
            return apis;
        }
    }

