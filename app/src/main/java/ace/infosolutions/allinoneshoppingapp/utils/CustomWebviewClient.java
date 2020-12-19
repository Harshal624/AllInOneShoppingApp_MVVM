package ace.infosolutions.allinoneshoppingapp.utils;

import android.graphics.Bitmap;
import android.os.Handler;
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
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            loadinganim.setVisibility(View.GONE);
        }, 3000);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

    }

}
