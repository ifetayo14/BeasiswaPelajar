package stud11418004.develops.beasiswapelajar.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "http://192.168.43.135/BeasiswaPelajarAPI/public/";
    private static APIClient mInstance;
    private Retrofit retrofit;

    private APIClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized APIClient getInstance() {
        if (mInstance == null) {
            mInstance = new APIClient();
        }
        return mInstance;
    }

    public APIServices getAPI(){
        return retrofit.create(APIServices.class);
    }
}
