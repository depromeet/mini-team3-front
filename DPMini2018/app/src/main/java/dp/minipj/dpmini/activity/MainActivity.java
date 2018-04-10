package dp.minipj.dpmini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.minipj.dpmini.R;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.main_hamburger_btn)
  ImageButton mainHamburgerBtn;
  @BindView(R.id.main_search_btn)
  ImageButton mainSearchBtn;
  @BindView(R.id.main_day_tv)
  TextView mainDayTv;
  @BindView(R.id.main_rv)
  RecyclerView mainRv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

  }

  public static Intent intent(AppCompatActivity activity) {
    Intent intent = new Intent(activity, MainActivity.class);
    return Intent.makeRestartActivityTask(intent.getComponent());
  }
}
