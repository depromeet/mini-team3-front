package dp.minipj.dpmini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.minipj.dpmini.R;
import dp.minipj.dpmini2018.models.MainResult;

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
  private RecyclerAdapter recyclerAdapter;
  private LinearLayoutManager layoutManager;
  private List<MainResult> data = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    ////// layout manager setting
    recyclerView = (RecyclerView) findViewById(R.id.main_rv);
    layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    recyclerView.setLayoutManager(layoutManager);

    recyclerAdapter = new RecyclerAdapter(data);
    recyclerView.setAdapter(recyclerAdapter);
    makeDummy();

  }


  private void makeDummy() {
    data.add(new MainResult("8", "MON", "R.drawable.rectalgle_3"));
    data.add(new MainResult("9", "Tus", "R.drawable.rectalgle_3"));
  }


  static class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public static final String TAG = RecyclerAdapter.class.getSimpleName();

    List<MainResult> mainLists;

    public RecyclerAdapter(ArrayList<MainResult> mainLists) {
      this.mainLists = mainLists;
    }

    public void setAdapter(List<MainResult> mainLists) {
      this.mainLists = mainLists;
      notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false);
      MyViewHolder viewHolder = new MyViewHolder(view);
      return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
      MainResult mainResult = mainLists.get(position);

      Log.i(TAG, "onBindViewHolder: " + holder.mDay);
      Log.i(TAG, "onBindViewHolder: " + mainResult.day);
      holder.mDay.setText(mainLists.get(position).day);
      holder.mDate.setText(mainLists.get(position).date);
      Glide.with(holder.mImg.getContext())
          .load(mainResult.img)
          .into(holder.mImg);
    }

    @Override
    public int getItemCount() {
      return mainLists != null ? mainLists.size() : 0;
    }
  }

  static class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView mDay; // 날짜
    private TextView mDate; // 요일
    private ImageView mImg;

    public MyViewHolder(View itemView) {
      super(itemView);

      mDay = (TextView) findViewById(R.id.item_main_day_tv);
      mDate = (TextView) findViewById(R.id.item_main_date_tv);
      mImg = (ImageView) findViewById(R.id.item_main_img);
    }
  }

  public static Intent intent(AppCompatActivity activity) {
    Intent intent = new Intent(activity, MainActivity.class);
    return Intent.makeRestartActivityTask(intent.getComponent());
  }

}
