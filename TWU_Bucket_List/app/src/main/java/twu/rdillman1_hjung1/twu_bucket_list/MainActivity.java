package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import twu.rdillman1_hjung1.twu_bucket_list.Adapters.MainAdapter;
import twu.rdillman1_hjung1.twu_bucket_list.Model.Model;
import twu.rdillman1_hjung1.twu_bucket_list.Utils.DatabaseHandler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements DialogCloseListener{

    private DatabaseHandler db;

    private RecyclerView tasksRecyclerView;
    private MainAdapter tasksAdapter;
    private FloatingActionButton actionButton;
    private Button button1;

    private List<Model> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new MainAdapter(db,MainActivity.this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        actionButton = findViewById(R.id.fab);
button1 = findViewById(R.id.button);
        List = db.getAllTasks();
        Collections.reverse(List);
        tasksAdapter.setTasks(List);

button1.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        checkLocation.newInstance().show(getSupportFragmentManager(), checkLocation.TAG1);
    }
});
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
    }

    @Override
    public void handleDialogClose(DialogInterface dialog){
        List = db.getAllTasks();
        Collections.reverse(List);
        tasksAdapter.setTasks(List);
        tasksAdapter.notifyDataSetChanged();
    }
}