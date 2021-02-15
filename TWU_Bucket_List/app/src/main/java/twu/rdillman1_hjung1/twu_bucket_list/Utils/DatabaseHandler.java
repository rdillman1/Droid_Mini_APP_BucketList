package twu.rdillman1_hjung1.twu_bucket_list.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import twu.rdillman1_hjung1.twu_bucket_list.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "Database";
    private static final String DB_TABLE = "dbList";
    private static final String ID = "id";
    private static final String TASK = "task";
   // private static final String LATITUDE = "latitude";
   // private static final String LONGITUDE = "longitude";
    //private static final String DESCRIPTION = "description";
    private static final String STATUS = "status";
    private static final String CREATE_DB_TABLE = "CREATE TABLE " + DB_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
           TASK + " TEXT, "+ STATUS + " INTEGER)";

    private SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void openDatabase() {
        db = this.getWritableDatabase();
    }

    public void insertTask(Model task){
        ContentValues cv = new ContentValues();
        cv.put(TASK, task.getTask());
       // cv.put(DESCRIPTION, task.getDescription());
        cv.put(STATUS, 0);
        db.insert(DB_TABLE, null, cv);
    }

    public List<Model> getAllTasks(){
        List<Model> taskList = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try{
            cur = db.query(DB_TABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        Model task = new Model();
                        task.setId(cur.getInt(cur.getColumnIndex(ID)));
                        task.setTask(cur.getString(cur.getColumnIndex(TASK)));
                        task.setStatus(cur.getInt(cur.getColumnIndex(STATUS)));
                        taskList.add(task);
                    }
                    while(cur.moveToNext());
                }
            }
        }
        finally {
            db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return taskList;
    }

    public void updateStatus(int id, int status){
        ContentValues cv = new ContentValues();
        cv.put(STATUS, status);
        db.update(DB_TABLE, cv, ID + "= ?", new String[] {String.valueOf(id)});
    }

    public void updateTask(int id, String task) {
        ContentValues cv = new ContentValues();
        cv.put(TASK, task);
        db.update(DB_TABLE, cv, ID + "= ?", new String[] {String.valueOf(id)});
    }

    public void deleteTask(int id){
        db.delete(DB_TABLE, ID + "= ?", new String[] {String.valueOf(id)});
    }
    public int getCurrentID(int id){
      Cursor grabID = null;
      int tempid = grabID.getColumnIndex("id");
      return tempid;
    }
}