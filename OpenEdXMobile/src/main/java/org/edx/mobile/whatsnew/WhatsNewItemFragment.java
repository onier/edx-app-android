package org.edx.mobile.whatsnew;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.edx.mobile.R;
import org.edx.mobile.base.BaseFragment;
import org.edx.mobile.databinding.FragmentWhatsNewItemBinding;

public class WhatsNewItemFragment extends BaseFragment {
    public static String ARG_MODEL = "ARG_MODEL";

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
        @DrawableRes
        int imageDrawable = getResources().getIdentifier(model.getImage(), "drawable",
                getContext().getPackageName());
        binding.image.setImageResource(imageDrawable);
    }

    private String escapePlatformName(@NonNull String input) {
        final String toEscape = "platform_name";
        return input.contains(toEscape) ? input.replaceAll(toEscape,
                getString(R.string.platform_name)) : input;
    }
}
