package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class editItemActivity extends AppCompatActivity {
    private FloatingActionButton goBack;
    private Button saveBtn;
    private String bucketGoal;
    private Float bucketLat;
    private Float bucketLong;
    private String bucketDiscription;
    private BucketListAdaptor bucketAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        getSupportActionBar().hide();
        goBack = findViewById(R.id.goBackA);

        goBack.setOnClickListener(view -> {
            Intent intent = new Intent(editItemActivity.this, BucketListActivity.class);
            startActivity(intent);
        });



    }
}