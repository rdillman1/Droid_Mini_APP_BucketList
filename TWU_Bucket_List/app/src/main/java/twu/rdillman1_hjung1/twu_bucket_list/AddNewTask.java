package twu.rdillman1_hjung1.twu_bucket_list;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import twu.rdillman1_hjung1.twu_bucket_list.Model.Model;
import twu.rdillman1_hjung1.twu_bucket_list.Utils.DatabaseHandler;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class AddNewTask extends BottomSheetDialogFragment {

    public static final String TAG = "ActionBottomDialog";
    private EditText newTaskText;
    private EditText newDescriptionText;
    private Button newTaskSaveButton;
   private  EditText newLatitudeText;
   private EditText newLongitudeText;
    private FloatingActionButton back;

    public String d1,d2,d3,d4;
    public String[] run1;
    public String la1,la2,la3,la4;
  public  String lo1,lo2,l03,lo4;
/*
    public class ArrayHelper {
        public static <T> T[] push(T[] arr, T item) {
            T[] tmp = Arrays.copyOf(arr, arr.length + 1);
            tmp[tmp.length - 1] = item;
            return tmp;
        }

        public static <T> T[] pop(T[] arr) {
            T[] tmp = Arrays.copyOf(arr, arr.length - 1);
            return tmp;
        }
    }*/
    private DatabaseHandler db;

    public static AddNewTask newInstance(){
        return new AddNewTask();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);

        /*
        final Bundle bundle = getArguments();
        int tempID = 0;
        assert bundle != null;
        tempID= db.getCurrentID(bundle.getInt("id"));
        toastMessage(" Current ID = "+tempID);

*/  Toast toast=Toast.makeText(getContext(),"You can drag me up! \n Click a text box and drap up.",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();



    }
    public void toastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_task, container, false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newTaskText = Objects.requireNonNull(getView()).findViewById(R.id.newTaskText);
        newDescriptionText = Objects.requireNonNull(getView()).findViewById(R.id.newDescriptionText);
        newTaskSaveButton = getView().findViewById(R.id.newTaskButton);
        newLatitudeText = getView().findViewById(R.id.newLatitudeText);
        newLongitudeText = getView().findViewById(R.id.newLongitudeText);

        back = getView().findViewById(R.id.goBackA);
        back.setOnClickListener(v -> {
            Intent intenter = new Intent(getActivity(), MainActivity.class);
            startActivity(intenter);
        });


        boolean isUpdate = false;

        final Bundle bundle = getArguments();
        if (bundle != null) {
            isUpdate = true;
            String task = bundle.getString("task");

            //String description = bundle.getString("description");
            newTaskText.setText(task);
            //newDescriptionText.setText(description);
            int tempID = 1;

            switch (tempID) {
                case 1:
                    newDescriptionText.setText(d1);
                    newLatitudeText.setText(la1);
                    newLongitudeText.setText(lo1);
                    break;
                            /*
                        case 1:
                            d2 = newDescriptionText.toString();
                            break;
                        case 2:
                            d3 = newDescriptionText.toString();
                            break;
                        case 3:
                            d4 = newDescriptionText.toString();
                            break;*/
                            }
            ++tempID;


                assert task != null;
                if (task.length() > 0)
                    newTaskSaveButton.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.colorPrimaryDark));
            }

            db = new DatabaseHandler(getActivity());
            db.openDatabase();

            newTaskText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().equals("")) {
                        newTaskSaveButton.setEnabled(false);
                        newTaskSaveButton.setTextColor(Color.RED);
                    } else {
                        newTaskSaveButton.setEnabled(true);
                        newTaskSaveButton.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.colorAccent));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            final boolean finalIsUpdate = isUpdate;
            newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = newTaskText.getText().toString();


                    //String description = newDescriptionText.getText().toString();
                    //int tempID;
                    // assert bundle != null;
                    // tempID= db.getCurrentID(bundle.getInt("id"));


                    if (finalIsUpdate) {
                        db.updateTask(bundle.getInt("id"), text);
                        // db.updateDescription(bundle.getInt("id"), description);
                        // switch(tempID){}
                    } else {
                        int tempID = 0;
                        switch (tempID) {
                            case 0:
                                d1 = newDescriptionText.toString();
                                la1 = newLatitudeText.toString();
                                lo1 = newLongitudeText.toString();
                               String[] run1 = new String[]{d1, la1, la2};
                                break;
/*
                            case 1:
                                d2 = newDescriptionText.toString();
                                break;
                            case 2:
                                d3 = newDescriptionText.toString();
                                break;
                            case 3:
                                d4 = newDescriptionText.toString();
                                break;

                            default:
                                throw new IllegalStateException("Unexpected value: " + tempID);*/
                        }
                        ++tempID;
                        Model task = new Model();
                        task.setTask(text);
                        //task.setDescription(description);
                        task.setStatus(0);
                        db.insertTask(task);
                    }
                    dismiss();
                }
            });
        }
    @Override
    public void onDismiss(@NonNull DialogInterface dialog){
        Activity activity = getActivity();
        if(activity instanceof DialogCloseListener)
            ((DialogCloseListener)activity).handleDialogClose(dialog);
    }


}
