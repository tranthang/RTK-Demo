/*
 * // Copyright (c) CT Team. - All Rights Reserved
 * // Unauthorized copying of this file, via any medium is strictly prohibited
 * // Proprietary and confidential
 */

package com.ctteam.rtk_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thang on 5/5/17.
 */

public class SetupInfo extends android.support.v4.app.Fragment {

  private Spinner iBluetoothDevice;
  private LinearLayout iLayout;
  private Spinner iServerAddress;
  private EditText iPortConnection;


  @Override
  public View onCreateView (LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
    View v = layoutInflater.inflate(R.layout.setup_layout, viewGroup, false);
    iBluetoothDevice = (Spinner)v.findViewById(R.id.bluetooth_device);
    iPortConnection = (EditText)v.findViewById(R.id.port_connection);
    List<String> list = new ArrayList<>();
    list.add("device 1");
    list.add("device 2");
    list.add("Find new device");
    findBluetoothDevices(list, iBluetoothDevice);
    iServerAddress = (Spinner)v.findViewById(R.id.ip);
    list = new ArrayList<>();
    list.add("rtkdemo.com");
    list.add("8080");
    list.add("192.168.0.1");
    findBluetoothDevices(list, iServerAddress);
    return v;
  } // onCreateView()


  private void findBluetoothDevices (List<String> list, Spinner spinner) {
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

} // SetupInfo