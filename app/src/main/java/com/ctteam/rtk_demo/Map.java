/*
 * // Copyright (c) CT Team. - All Rights Reserved
 * // Unauthorized copying of this file, via any medium is strictly prohibited
 * // Proprietary and confidential
 */

package com.ctteam.rtk_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends Fragment implements OnMapReadyCallback {

    private Context iContext;
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View v = layoutInflater.inflate(R.layout.rtk_map, viewGroup, false);
        mapView = (MapView) v.findViewById((R.id.map));
        mapView.onCreate(bundle);

        mapView.onResume();

        try{
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }

        mapView.getMapAsync(this);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        double latitude = 12.385044;
        double longitude = 65.486671;

        //create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Hello Maps");
        //changing marker icon
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        //Perform any camera updates
        //adding marker
        gMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(12.385044, 65.486671)).zoom(12).build();
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    @Override
    public final void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public final void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public final void onPause() {
        mapView.onPause();
        super.onPause();
    }
}
