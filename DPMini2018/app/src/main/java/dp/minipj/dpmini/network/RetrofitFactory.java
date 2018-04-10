package dp.minipj.dpmini.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dp.minipj.dpmini.BuildConfig;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

  public static <T> T createService(Class<T> serviceClass) {
    return getRetrofitObject().create(serviceClass);
  }

  private static Retrofit getRetrofitObject() {
    Dispatcher dispatcher = new Dispatcher();

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .dispatcher(dispatcher)
        .build();

    return new Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
