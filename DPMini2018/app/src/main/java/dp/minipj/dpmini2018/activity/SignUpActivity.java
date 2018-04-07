package dp.minipj.dpmini2018.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import dp.minipj.dpmini2018.R;

public class SignUpActivity extends AppCompatActivity {

  @BindView(R.id.image_profile) ImageView imageProfile;
  @BindView(R.id.edit_emails) EditText editEmails;
  @BindView(R.id.edit_nickname) EditText editNickname;
  @BindView(R.id.edit_phone) EditText editPhone;
  @BindView(R.id.edit_password) EditText editPassword;
  @BindView(R.id.button_signin) ImageView buttonSignin;
  @BindView(R.id.layout_button) RelativeLayout layoutButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);


  }
}