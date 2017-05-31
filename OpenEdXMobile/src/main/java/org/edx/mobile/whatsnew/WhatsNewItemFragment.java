package org.edx.mobile.whatsnew;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseFragment;
import org.edx.mobile.databinding.FragmentWhatsNewItemBinding;
import org.edx.mobile.util.UiUtil;

public class WhatsNewItemFragment extends BaseFragment {
    public static final String ARG_MODEL = "ARG_MODEL";

    private FragmentWhatsNewItemBinding binding;

    public static WhatsNewItemFragment newInstance(@NonNull WhatsNewModel model) {
        final WhatsNewItemFragment fragment = new WhatsNewItemFragment();
        final Bundle args = new Bundle();
        args.putParcelable(ARG_MODEL, model);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_whats_new_item, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Bundle args = getArguments();
        final WhatsNewModel model = args.getParcelable(ARG_MODEL);

        binding.title.setText(escapePlatformName(model.getTitle()));
        binding.message.setText(escapePlatformName(model.getMessage()));
        binding.image.setImageResource(UiUtil.getDrawable(getContext(), model.getImage()));
    }

    private String escapePlatformName(@NonNull String input) {
        return input.replaceAll("platform_name", getString(R.string.platform_name));
    }
}
