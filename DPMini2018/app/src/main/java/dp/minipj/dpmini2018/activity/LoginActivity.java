package dp.minipj.dpmini2018.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dp.minipj.dpmini2018.R;

public class LoginActivity extends AppCompatActivity {
  @BindView(R.id.login_logo_img) ImageView loginLogoImg;
  @BindView(R.id.login_email_et) EditText loginEmailEt;
  @BindView(R.id.login_pw_et) EditText loginPwEt;
  @BindView(R.id.login_btn) ImageButton loginBtn;
  @BindView(R.id.login_content_layout) RelativeLayout loginContentLayout;
  @BindView(R.id.signup_btn) ImageButton signupBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.login_btn) void onLoginButtonClicked() {
    startActivity(MainActivity.intent(this));
  }

  @OnClick(R.id.signup_btn) void onSignUpButtonClicked() {
    startActivity(SignUpActivity.intent(this));
  }
}
