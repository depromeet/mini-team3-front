package dp.minipj.dpmini;

import android.app.Application;

import dp.minipj.dpmini.network.Api;

public class TripApps extends Application {
  private static TripApps apps;
  private Api api;


  @Override public void onCreate() {
    super.onCreate();
    apps = this;
  }

  public final Api api() {
    return api == null ? api = Api.getInstance() : api;
  }

  public static TripApps getInstance() {
    return apps;
  }
}
