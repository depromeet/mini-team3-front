package dp.minipj.dpmini2018.network;

public enum Api {
  INSTANCE;

  private UserApi user;

  Api() {
    user = RetrofitFactory.createService(UserApi.class);
  }

  public UserApi user() {
    return user;
  }

  public static Api getInstance() {
    return INSTANCE;
  }
}