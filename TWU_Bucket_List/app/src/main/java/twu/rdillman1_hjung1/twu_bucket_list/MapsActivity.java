package twu.rdillman1_hjung1.twu_bucket_list;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
   private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String intentLocation = extras.getString("location");

        Log.d(TAG, "onMapReady: "+intentLocation);
/*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(12, 45);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Your Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
*/
        try {
          List<Address> addresses = geocoder.getFromLocationName(""+intentLocation,1);
          if(addresses.size() > 0){
              Address address = addresses.get(0);
              LatLng myLocation = new LatLng(address.getLatitude(), address.getLongitude());
              MarkerOptions markerOptions = new MarkerOptions().position(myLocation).title(address.getLocality());
              mMap.addMarker(markerOptions);
              mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,16));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}