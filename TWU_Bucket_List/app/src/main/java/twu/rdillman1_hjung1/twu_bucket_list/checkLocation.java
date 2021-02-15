package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class checkLocation extends BottomSheetDialogFragment {
    public static final String TAG1 = "ActionBottomDialog";
    private Button check;
    private FloatingActionButton back;

    public static checkLocation newInstance() {
        return new checkLocation();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
        Toast toast=Toast.makeText(getContext(),"You can drag me up! \n Click a text box and drap up.",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_check_location, container, false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        check = getView().findViewById(R.id.button);
back = getView().findViewById(R.id.goback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });




        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText locate = Objects.requireNonNull(getView()).findViewById(R.id.location);
                Bundle extras = new Bundle();

                extras.putString("location", locate.getText().toString());

                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}