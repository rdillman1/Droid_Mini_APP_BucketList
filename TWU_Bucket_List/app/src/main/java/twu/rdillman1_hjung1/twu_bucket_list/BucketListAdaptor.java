package twu.rdillman1_hjung1.twu_bucket_list;
//push test 1/20/2021
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import twu.rdillman1_hjung1.twu_bucket_list.model.bucketModel;

import static androidx.core.content.ContextCompat.startActivity;


public class BucketListAdaptor extends RecyclerView.Adapter<BucketListAdaptor.ViewHolder> {

    private List<bucketModel> bucketModelList;
    private BucketListActivity activity;
    private ViewHolder holder;
    private int position;

    public BucketListAdaptor(BucketListActivity activity) {
        this.activity = activity;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bucket_item_layout, parent, false);
        return new ViewHolder(itemView);
    }


    public void onBindViewHolder(ViewHolder holder, int position){

        this.holder = holder;
        this.position = position;
        bucketModel bucket = bucketModelList.get(position);
      holder.checked.setText(bucket.getGoal());
      holder.checked.setChecked(toBool(bucket.getChecked()));
      holder.edit.setOnClickListener(v->{
          Intent intent = new Intent(activity, AddItemActivity.class);
          activity.startActivity(intent);

      });
    }


private boolean toBool(int x){
        return x!=0;
}
public void setGoal(List<bucketModel> bucketModelList){
        this.bucketModelList = bucketModelList;
        notifyDataSetChanged();
}


public int getItemCount(){
      return bucketModelList.size();
}



public static class ViewHolder extends RecyclerView.ViewHolder{
    CheckBox checked;
    BucketListActivity activity;
    Button edit;
    ViewHolder(View view) {
        super(view);
        checked = view.findViewById(R.id.bucketCheckbox);
        checked.setOnClickListener(v ->
                Log.d("demo", "OnClick: Check clicked"));
       edit = view.findViewById(R.id.buttonEdit);
    edit.setOnClickListener(v -> {
            Log.d("edit", "OnClick: edit clicked");
        });
    }
}
}

