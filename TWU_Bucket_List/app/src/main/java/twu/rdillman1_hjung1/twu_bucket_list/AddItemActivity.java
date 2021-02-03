package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddItemActivity extends AppCompatActivity {
private FloatingActionButton goBack;
private Button check;
private Button saveBtn;
private String bucketGoal;

private String Lat;
private String Long;




private String bucketDiscription;
    private BucketListAdaptor bucketAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().hide();

        Lat = findViewById(R.id.bucketLat).toString();
        Long = findViewById(R.id.bucketLong).toString();

        goBack = findViewById(R.id.goBackA);
        check = findViewById(R.id.btn_checker);


        goBack.setOnClickListener(view -> {
            Intent intent = new Intent(AddItemActivity.this, BucketListActivity.class);
            startActivity(intent);
        });
        check.setOnClickListener(view -> {

            Intent intent = new Intent(AddItemActivity.this, locationselect.class);
            startActivity(intent);
        });



    }
}