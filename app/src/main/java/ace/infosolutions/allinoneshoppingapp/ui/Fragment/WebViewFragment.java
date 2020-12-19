package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ace.infosolutions.allinoneshoppingapp.databinding.FragmentWebViewBinding;
import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.utils.CustomWebviewClient;


public class WebViewFragment extends Fragment {
    private FragmentWebViewBinding binding;

    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            if (isEnabled() && binding.webview.canGoBack()) {
                binding.webview.goBack();
            } else {
                setEnabled(false);
                requireActivity().onBackPressed();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWebViewBinding.inflate(inflater, container, false);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Website website = WebViewFragmentArgs.fromBundle(getArguments()).getWebsite();
            loadWebSite(website);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadWebSite(Website website) {
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        binding.webview.getSettings().setBuiltInZoomControls(true);
        binding.webview.getSettings().setUseWideViewPort(true);
        binding.webview.getSettings().setLoadWithOverviewMode(true);
        binding.webview.setWebViewClient(new CustomWebviewClient(binding.lottieanim));
        binding.webview.loadUrl(website.getUrl());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}