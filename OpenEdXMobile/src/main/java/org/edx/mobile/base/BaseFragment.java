package org.edx.mobile.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.edx.mobile.event.NewRelicEvent;
import org.edx.mobile.interfaces.NetworkObserver;
import org.edx.mobile.interfaces.NetworkSubject;

import de.greenrobot.event.EventBus;
import roboguice.fragment.RoboFragment;

public class BaseFragment extends RoboFragment implements NetworkObserver {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().post(new NewRelicEvent(getClass().getSimpleName()));
    }

    @Override
    public void onStart(){
        super.onStart();

        if (getActivity() != null && getActivity() instanceof NetworkSubject) {
            NetworkSubject activity = (NetworkSubject) getActivity();
            activity.registerNetworkObserver(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (getActivity() != null && getActivity() instanceof NetworkSubject) {
            NetworkSubject activity = (NetworkSubject) getActivity();
            activity.unregisterNetworkObserver(this);
        }
    }

    @Override
    public void onOnline() {

    }

    @Override
    public void onOffline() {

    }
}
