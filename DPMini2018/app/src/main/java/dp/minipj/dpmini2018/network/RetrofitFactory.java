package dp.minipj.dpmini2018.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dp.minipj.dpmini2018.BuildConfig;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

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
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
