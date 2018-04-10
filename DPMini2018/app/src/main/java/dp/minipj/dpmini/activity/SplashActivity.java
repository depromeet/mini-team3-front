package dp.minipj.dpmini.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.minipj.dpmini.R;

public class SplashActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        intent = new Intent(getApplicationContext(), LoginActivity.class);

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            startActivity(intent);
            finish();
        }, 3000); // splash 3초
    }
}
