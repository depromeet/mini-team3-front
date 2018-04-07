package dp.minipj.dpmini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

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

  private RecyclerView recyclerView;
  // private RecyclerAdapter recyclerAdapter;
  private LinearLayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    ////// layout manager setting
    recyclerView = (RecyclerView)findViewById(R.id.main_rv);
    layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    recyclerView.setLayoutManager(layoutManager);

  }

  public static Intent intent(AppCompatActivity activity) {
    Intent intent = new Intent(activity, MainActivity.class);
    return Intent.makeRestartActivityTask(intent.getComponent());
  }

  /*
  class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{


  }

  class MyViewHolder extends RecyclerView.ViewHolder{

  }
  */

}
