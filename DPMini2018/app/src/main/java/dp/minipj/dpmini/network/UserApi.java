package dp.minipj.dpmini.network;

import dp.minipj.dpmini.models.SignInRequest;
import dp.minipj.dpmini.models.SignInResponse;
import dp.minipj.dpmini.models.SignUpRequest;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

  @POST("/register")
  Completable signUp(@Body SignUpRequest signUpRequest);

  @POST("/login")
  Single<SignInResponse> signIn(@Body SignInRequest signInRequest);
}
