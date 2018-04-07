package dp.minipj.dpmini2018.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import dp.minipj.dpmini2018.R;

public class LoginActivity extends AppCompatActivity {

    private EditText email_et;
    private EditText pw_et;
    private ImageButton signIn_btn;
    private ImageButton signUp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /////
        email_et = (EditText)findViewById(R.id.login_email_et);
        pw_et = (EditText)findViewById(R.id.login_pw_et);
        signIn_btn = (ImageButton)findViewById(R.id.login_btn);
        signUp_btn = (ImageButton)findViewById(R.id.signup_btn);
        /////

        String userEmail = email_et.getText().toString();
        String userPW = pw_et.getText().toString();

    }
}
