package harshit.app.spacex.Utils.restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static harshit.app.spacex.Utils.Constant.CONNECTION_TIMEOUT;
import static harshit.app.spacex.Utils.Constant.READ_TIMEOUT;
import static harshit.app.spacex.Utils.Constant.WRITE_TIMEOUT;

public class RetrofitBuilder {

    private static Gson gson = new GsonBuilder().setLenient().create();
    private static GsonConverterFactory gsonFactory = GsonConverterFactory.create(gson);
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build();


    public static Retrofit getInstance(String baseURL){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(gsonFactory)
                .client(client)
                .build();
    }

}
