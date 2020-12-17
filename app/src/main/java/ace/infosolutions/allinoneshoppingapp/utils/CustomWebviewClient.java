package ace.infosolutions.allinoneshoppingapp.utils;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;

public class CustomWebviewClient extends WebViewClient {

    private LottieAnimationView loadinganim;

    public CustomWebviewClient(LottieAnimationView loadinganim) {
        this.loadinganim = loadinganim;
        loadinganim.setVisibility(View.VISIBLE);
    }


    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        loadinganim.setVisibility(View.GONE);
    }

}
