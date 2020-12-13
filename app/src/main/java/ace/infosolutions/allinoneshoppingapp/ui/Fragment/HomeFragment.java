package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.databinding.FragmentHomeBinding;
import ace.infosolutions.allinoneshoppingapp.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImages(view);

        binding.imgBtnMoreTopSites.setOnClickListener(view1 -> {
            HomeFragmentDirections.ActionNavHomeToResultListFragment action = HomeFragmentDirections.
                    actionNavHomeToResultListFragment();
            action.setTitle("Top Sites");
            Navigation.findNavController(view).navigate(action);
        });
        binding.imgBtnFashionMore.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fashionFragment);
        });
        binding.imgBtnGenShoppingMore.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_genShoppingFragment);
        });
        binding.imgBtnGrocFood.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_groceryFoodFragment);
        });
        binding.tvOthers.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_othersFragment);
        });

    }

    private void loadImages(View view) {
        Glide.with(view).load(R.drawable.shoppersstoplogo).into(binding.ivShoppersStopOthers);
        Glide.with(view).load(R.drawable.samsunglogo).into(binding.ivSamsungOthers);
        Glide.with(view).load(R.drawable.wishlogo).into(binding.ivWishOthers);

        Glide.with(view).load(R.drawable.liciouslogo).into(binding.ivLiciousGrocFood);
        Glide.with(view).load(R.drawable.swiggylogo).into(binding.ivSwiggyGrocFood);
        Glide.with(view).load(R.drawable.kfclogo).into(binding.ivKFCGrocFood);

        Glide.with(view).load(R.drawable.amazondailydealslogo).centerCrop().into(binding.tvAmazonDailyDeals);

        Glide.with(view).load(R.drawable.amazonlogo).into(binding.ivAmazonGenShopping);
        Glide.with(view).load(R.drawable.flipkartlogo).into(binding.ivFlipkartGenShopping);
        Glide.with(view).load(R.drawable.snapdeallogo).into(binding.ivSnapdealGenShopping);

        Glide.with(view).load(R.drawable.myntralogo).into(binding.ivMyntraaFashion);
        Glide.with(view).load(R.drawable.nykaalogo).into(binding.ivNykaaFashion);
        Glide.with(view).load(R.drawable.tatacliqlogo).into(binding.ivTataCliqFashion);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

/*
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.flipkart.com/");
        webView.setWebViewClient(new WebViewClient());

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) view;

                    switch (i) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });*/