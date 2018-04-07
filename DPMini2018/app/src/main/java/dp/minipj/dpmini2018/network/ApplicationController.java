package dp.minipj.dpmini2018.network;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lynn on 2018-04-07.
 */

public class ApplicationController extends Application {

    private static ApplicationController instance;
    private static String baseUrl = "";
    private NetworkService networkService;

    public static ApplicationController getInstance(){
        return instance;
    }

    public NetworkService getNetworkService(){
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationController.instance = this;
        buildService();
    }

    public void buildService(){
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }
}