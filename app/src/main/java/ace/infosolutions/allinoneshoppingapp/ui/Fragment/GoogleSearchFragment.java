package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ace.infosolutions.allinoneshoppingapp.databinding.FragmentGoogleSearchBinding;


public class GoogleSearchFragment extends Fragment {
    private FragmentGoogleSearchBinding binding;

    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(true) {
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
        binding = FragmentGoogleSearchBinding.inflate(inflater, container, false);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), mOnBackPressedCallback);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String url = GoogleSearchFragmentArgs.fromBundle(getArguments()).getUrl();
            loadWebsite(url);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadWebsite(String url) {
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl(url);
        binding.webview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}