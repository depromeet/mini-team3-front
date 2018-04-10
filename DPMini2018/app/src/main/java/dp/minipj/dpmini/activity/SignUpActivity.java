package dp.minipj.dpmini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dp.minipj.dpmini.R;
import dp.minipj.dpmini.TripApps;
import dp.minipj.dpmini.models.SignUpRequest;
import dp.minipj.dpmini.network.Api;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignUpActivity extends AppCompatActivity {
  @BindView(R.id.image_profile) ImageView imageProfile;
  @BindView(R.id.edit_emails) EditText editEmails;
  @BindView(R.id.edit_nickname) EditText editNickname;
  @BindView(R.id.edit_phone) EditText editPhone;
  @BindView(R.id.edit_password) EditText editPassword;
  @BindView(R.id.button_signup) ImageView buttonSignup;

  CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.button_signup) void onSignInClicked() {
    Disposable disposable = TripApps.getInstance().api()
        .user()
        .signUp(new SignUpRequest(
            editEmails.getText().toString(), "", editNickname.getText().toString(),
            editPassword.getText().toString(), editPhone.getText().toString()))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            () -> finish(),
            e -> {
              e.printStackTrace();
              Toast.makeText(this, "에러가 발생했습니다 : " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        );
    compositeDisposable.add(disposable);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    compositeDisposable.dispose();
  }

  public static Intent intent(AppCompatActivity activity) {
    return new Intent(activity, SignUpActivity.class);
  }
}
