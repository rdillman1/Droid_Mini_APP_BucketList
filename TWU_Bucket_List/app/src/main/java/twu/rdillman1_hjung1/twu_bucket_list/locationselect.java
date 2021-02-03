package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class locationselect extends AppCompatActivity {

    private Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationselect);
        getSupportActionBar().hide();
        check = findViewById(R.id.button);
        final EditText locate = (EditText) findViewById(R.id.location);

     check.setOnClickListener(view -> {
Bundle extras = new Bundle();

extras.putString("location", locate.getText().toString());
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtras(extras);
        startActivity(intent);

    });
}}