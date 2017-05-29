package org.edx.mobile.whatsnew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseAppActivity;

public class WhatsNewActivity extends BaseAppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_new);


        Fragment singleFragment = new WhatsNewFragment();

        //this activity will only ever hold this lone fragment, so we
        // can afford to retain the instance during activity recreation
        singleFragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, singleFragment, null);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();
    }
}
