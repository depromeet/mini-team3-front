package dp.minipj.dpmini2018.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dp.minipj.dpmini2018.R;

public class LoginActivity extends AppCompatActivity {

  @BindView(R.id.edit_email) EditText editEmail;
  @BindView(R.id.edit_password) EditText editPassword;
  @BindView(R.id.button_login) ImageButton buttonLogin;
  @BindView(R.id.text_sign_up) TextView textSignUp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.button_login) void onLoginButtonClicked() {
    startActivity(MainActivity.intent(this));
  }

  @OnClick(R.id.text_sign_up) void onSignUpTextClicked() {
    startActivity(SignUpActivity.intent(this));
  }
}
