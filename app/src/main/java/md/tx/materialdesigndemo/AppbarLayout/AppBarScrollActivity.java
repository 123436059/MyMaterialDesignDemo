package md.tx.materialdesigndemo.AppbarLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import md.tx.materialdesigndemo.R;

public class AppBarScrollActivity extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_scroll);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BaseAdapter());
    }

    private class BaseAdapter extends RecyclerView.Adapter<ViewHodler> {
        @Override
        public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            View content = LayoutInflater.from(AppBarScrollActivity.this).inflate(R.layout.item_recyclerview, parent, false);
            return new ViewHodler(content);
        }

        @Override
        public void onBindViewHolder(ViewHodler holder, int position) {
            holder.tvContent.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class ViewHodler extends RecyclerView.ViewHolder {
        TextView tvContent;

        public ViewHodler(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
        }
    }

}
