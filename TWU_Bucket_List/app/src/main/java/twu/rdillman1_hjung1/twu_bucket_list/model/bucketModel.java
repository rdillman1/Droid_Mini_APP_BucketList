package twu.rdillman1_hjung1.twu_bucket_list.model;

import android.widget.Button;

public class bucketModel {
    private int id, checked;
    private String goal;
    private float lat;
    private float lon;
    private String desc;

    public Button getEdit() {
        return Edit;
    }

    public void setEdit(Button edit) {
        Edit = edit;
    }

    private Button Edit;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}

