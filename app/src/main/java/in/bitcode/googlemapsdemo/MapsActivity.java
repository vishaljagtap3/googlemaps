package in.bitcode.googlemapsdemo;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    Marker markerHome, markerMum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        init();

        addMarkers();

    }

    private void addMarkers() {

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("Vishal's Home");
        markerOptions.snippet("A 505, Pebbles-2 Bavdhan")
                .position(new LatLng(18.5226, 73.7679))
                .draggable(true);

        markerHome = map.addMarker(markerOptions);

        markerMum = map.addMarker(
                new MarkerOptions()
                .title("Mumbai")
                .snippet("this is mumbai")
                .position( new LatLng(19.0760, 72.8777))
        );



    }


    @SuppressLint("MissingPermission")
    private void init() {

        map.setBuildingsEnabled(true);
        map.setIndoorEnabled(true);
        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        UiSettings settings = map.getUiSettings();
        settings.setCompassEnabled(true);
        settings.setIndoorLevelPickerEnabled(true);
        settings.setMapToolbarEnabled(true);
        settings.setMyLocationButtonEnabled(true);
        settings.setRotateGesturesEnabled(true);
        settings.setScrollGesturesEnabled(true);
        settings.setTiltGesturesEnabled(true);
        settings.setZoomControlsEnabled(true);
        settings.setZoomGesturesEnabled(true);
        settings.setScrollGesturesEnabledDuringRotateOrZoom(true);

    }
}













