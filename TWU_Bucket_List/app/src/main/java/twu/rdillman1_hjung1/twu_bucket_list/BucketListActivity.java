package twu.rdillman1_hjung1.twu_bucket_list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import twu.rdillman1_hjung1.twu_bucket_list.model.bucketModel;

public class BucketListActivity extends AppCompatActivity {
    private FloatingActionButton add;
    private BucketListAdaptor bucketAdaptor;
    private RecyclerView bucketRecyclerView;
    private List<bucketModel> bucketModelList;




    @Override
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bucket_list_activity);
        getSupportActionBar().hide();

        bucketModelList = new ArrayList<>();

            bucketRecyclerView =findViewById(R.id.bucketRecyclerView);

        bucketRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            bucketAdaptor = new BucketListAdaptor(this);

            bucketRecyclerView.setAdapter(bucketAdaptor);

           bucketModel goal = new bucketModel();
           goal.setGoal("Get good Grades");
           goal.setChecked(0);
           goal.setId(0);
           bucketModel goal2 = new bucketModel();
           goal2.setGoal("Get internship");
           goal2.setChecked(0);
           goal2.setId(1);


        bucketModelList.add(goal);
        bucketModelList.add(goal2);

        bucketAdaptor.setGoal(bucketModelList);
        add = findViewById(R.id.add_Button);
        add.setOnClickListener(view -> {
            Intent intent = new Intent(BucketListActivity.this, AddItemActivity.class);
            startActivity(intent);
        });

    }
}