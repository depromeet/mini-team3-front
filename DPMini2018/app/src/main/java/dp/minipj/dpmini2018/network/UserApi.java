package dp.minipj.dpmini2018.network;

import dp.minipj.dpmini2018.models.SignInRequest;
import dp.minipj.dpmini2018.models.SignInResponse;
import dp.minipj.dpmini2018.models.SignUpRequest;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

  @GET("/register")
  Completable signUp(@Body SignUpRequest signUpRequest);

  @POST("/login")
  Single<Response<SignInResponse>> signIn(@Body SignInRequest signInRequest);
}
