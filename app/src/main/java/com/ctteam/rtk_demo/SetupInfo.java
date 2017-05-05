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
import android.widget.LinearLayout;

/**
 * Created by thang on 5/5/17.
 */

public class SetupInfo extends android.support.v4.app.Fragment {

  private LinearLayout iLayout;

  @Override
  public View onCreateView (LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
    View v = layoutInflater.inflate(R.layout.setup_layout, viewGroup, false);

    return v;
  }

}