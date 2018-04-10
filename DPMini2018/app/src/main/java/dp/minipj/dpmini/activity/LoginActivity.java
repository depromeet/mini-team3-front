package dp.minipj.dpmini.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dp.minipj.dpmini.R;
import dp.minipj.dpmini.TripApps;
import dp.minipj.dpmini.models.SignInRequest;
import dp.minipj.dpmini.models.SignUpRequest;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

  @BindView(R.id.edit_email) EditText editEmail;
  @BindView(R.id.edit_password) EditText editPassword;
  @BindView(R.id.button_login) ImageButton buttonLogin;
  @BindView(R.id.text_sign_up) TextView textSignUp;

  CompositeDisposable compositeDisposable;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    compositeDisposable = new CompositeDisposable();
  }

  @OnClick(R.id.button_login) void onLoginButtonClicked() {

    Disposable disposable = TripApps.getInstance().api()
        .user()
        .signIn(new SignInRequest(editEmail.getText().toString(), editPassword.getText().toString()))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            response -> startActivity(MainActivity.intent(this)), // 리스폰스는 현재 사용하지 않음.
            e -> {
              e.printStackTrace();
              Toast.makeText(this, "에러가 발생했습니다 : " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        );
    compositeDisposable.add(disposable);
  }

  @OnClick(R.id.text_sign_up) void onSignUpTextClicked() {
    startActivity(SignUpActivity.intent(this));
  }
}
