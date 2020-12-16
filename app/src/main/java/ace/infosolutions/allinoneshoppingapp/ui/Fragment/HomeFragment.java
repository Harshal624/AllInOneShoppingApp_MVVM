package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.Locale;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.databinding.FragmentHomeBinding;
import ace.infosolutions.allinoneshoppingapp.viewmodel.HomeViewModel;

import static ace.infosolutions.allinoneshoppingapp.utils.Constants.GOOGLE_SEARCH_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.GSEARCH_DELAY;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.REQ_CODE;
import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            if (isEnabled() && !binding.editText.getText().toString().equals("")) {
                binding.editText.setText("");
            } else {
                setEnabled(false);
                requireActivity().onBackPressed();
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImages(view);


        binding.editText.setOnEditorActionListener((textView, i, keyEvent) -> {
            String inputString = null;
            try {
                inputString = binding.editText.getText().toString().trim();
            } catch (NullPointerException e) {
                inputString = "";
            }

            if (i == EditorInfo.IME_ACTION_SEARCH && !inputString.equals("")) {
                performSearch(binding.editText.getText().toString().trim());
                return true;
            }
            return false;
        });


        binding.imgBtnVoice.setOnClickListener(view12 -> Dexter.withContext(getContext())
                .withPermission(Manifest.permission.RECORD_AUDIO)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        initRecordVoice();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Snackbar.make(requireView(), "Denied", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check());

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

    private void performSearch(String searchString) {
        HomeFragmentDirections.ActionNavHomeToGoogleSearchFragment action = HomeFragmentDirections
                .actionNavHomeToGoogleSearchFragment();
        action.setUrl(GOOGLE_SEARCH_URL + searchString);
        if (getView() != null) {
            Navigation.findNavController(getView()).navigate(action);
        }
    }

    private void initRecordVoice() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Need to speak");
        try {
            startActivityForResult(intent, REQ_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(requireContext(),
                    "Sorry your device is not supported",
                    Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String resultString = result.get(0);
                    binding.editText.setText(resultString);
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        performSearch(resultString);
                    }, GSEARCH_DELAY);
                }
                break;
            }
        }
    }
}
