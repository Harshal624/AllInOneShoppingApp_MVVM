package ace.infosolutions.allinoneshoppingapp.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.model.Website;

import static ace.infosolutions.allinoneshoppingapp.utils.Constants.AMAZON_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.FLIPKART_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.KFC_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.LICIOUS_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.LIMEROAD_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.MYNTRA_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.NYKAA_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.SAMSUNG_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.SHOPPERSSTOP_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.SNAPDEAL_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.SWIGGY_URL;
import static ace.infosolutions.allinoneshoppingapp.utils.Constants.WISH_URL;

public class ListRepo implements WebsiteRepository {
    private static final String TAG = "ListRepo";
    private final MutableLiveData<List<Website>> mTopwebsiteMLD = new MutableLiveData<>();
    private final MutableLiveData<List<Website>> mGenShoppingMLD = new MutableLiveData<>();
    private final MutableLiveData<List<Website>> mFashionMLD = new MutableLiveData<>();
    private final MutableLiveData<List<Website>> mGrocFoodMLD = new MutableLiveData<>();
    private final MutableLiveData<List<Website>> mOthersMLD = new MutableLiveData<>();
    private static ListRepo instance;

    ListRepo() {
        retrieveTopWebsites();
        retrieveFashionWebsites();
        retrieveGenShoppingWebsites();
        retrieveGrocFoodWebsites();
        retrieveOtherWebsites();
    }

    public static synchronized ListRepo getInstance() {
        if (instance == null)
            instance = new ListRepo();
        return instance;
    }

    public void retrieveTopWebsites() {
        Log.d(TAG, "retrieveTopWebsites: ");
        List<Website> topWebsiteList = new ArrayList<>();
        topWebsiteList.add(new Website("Amazon", R.drawable.amazonlogo, true, AMAZON_URL));
        topWebsiteList.add(new Website("Flipkart", R.drawable.flipkartlogo, true, FLIPKART_URL));
        topWebsiteList.add(new Website("Snapdeal", R.drawable.snapdeallogo, true, SNAPDEAL_URL));
        topWebsiteList.add(new Website("Myntra", R.drawable.myntralogo, true, MYNTRA_URL));
        mTopwebsiteMLD.setValue(topWebsiteList);
    }

    public void retrieveGenShoppingWebsites() {
        List<Website> genShoppingWebsitesList = new ArrayList<>();
        genShoppingWebsitesList.add(new Website("Amazon", R.drawable.amazonlogo, true, "https://www.amazon.in/"));
        genShoppingWebsitesList.add(new Website("Flipkart", R.drawable.flipkartlogo, true, "https://www.flipkart.com/"));
        genShoppingWebsitesList.add(new Website("Snapdeal", R.drawable.snapdeallogo, true, "https://www.snapdeal.com/"));
        genShoppingWebsitesList.add(new Website("Ebay", R.drawable.ebaylogo, false, "https://www.ebay.com/"));
        genShoppingWebsitesList.add(new Website("Shopclues", R.drawable.shopclueslogo, false, "https://www.shopclues.com/"));
        genShoppingWebsitesList.add(new Website("AJIO", R.drawable.ajiologo, false, "https://www.ajio.com/"));
        genShoppingWebsitesList.add(new Website("Paytm Mall", R.drawable.paytmmalllogo, false, "https://paytmmall.com/"));
        genShoppingWebsitesList.add(new Website("Tata CliQ", R.drawable.tatacliqlogo, false, "https://www.tatacliq.com/"));
        genShoppingWebsitesList.add(new Website("Alibaba", R.drawable.alibabalogo, false, "https://www.alibaba.com/"));
        mGenShoppingMLD.setValue(genShoppingWebsitesList);
    }

    public void retrieveFashionWebsites() {
        List<Website> genShoppingWebsitesList = new ArrayList<>();
        genShoppingWebsitesList.add(new Website("Myntra", R.drawable.myntralogo, true, "https://www.myntra.com/"));
        genShoppingWebsitesList.add(new Website("ZARA", R.drawable.zaralogo, false, "https://www.zara.com/in/"));
        genShoppingWebsitesList.add(new Website("Nykaa", R.drawable.nykaalogo, true, NYKAA_URL));
        genShoppingWebsitesList.add(new Website("Lime road ", R.drawable.limeroadlogo, true, LIMEROAD_URL));
        genShoppingWebsitesList.add(new Website("Lifestyle", R.drawable.lifestylelogo, false, "https://www.lifestylestores.com/in/en/"));
        genShoppingWebsitesList.add(new Website("Koovs shopping", R.drawable.koovslogo, false, "https://www.koovs.com/"));
        genShoppingWebsitesList.add(new Website("Shein", R.drawable.sheinlogo, false, "https://www.shein.in/"));
        mFashionMLD.setValue(genShoppingWebsitesList);
    }

    public void retrieveGrocFoodWebsites() {
        List<Website> grocFoodWebsiteList = new ArrayList<>();
        grocFoodWebsiteList.add(new Website("Jio Mart", R.drawable.jiomartlogo, false, "https://www.jiomart.com/"));
        grocFoodWebsiteList.add(new Website("Bigbasket", R.drawable.bigbasketlogo, false, "https://www.bigbasket.com/"));
        grocFoodWebsiteList.add(new Website("KFC", R.drawable.kfclogo, true, KFC_URL));
        grocFoodWebsiteList.add(new Website("Swiggy", R.drawable.swiggylogo, true, SWIGGY_URL));
        grocFoodWebsiteList.add(new Website("Licious", R.drawable.liciouslogo, true, LICIOUS_URL));
        mGrocFoodMLD.setValue(grocFoodWebsiteList);
    }

    public void retrieveOtherWebsites() {
        List<Website> otherWebsiteList = new ArrayList<>();
        otherWebsiteList.add(new Website("Samsungshop", R.drawable.samsunglogo, true, SAMSUNG_URL));
        otherWebsiteList.add(new Website("Shoppers stop", R.drawable.shoppersstoplogo, false, SHOPPERSSTOP_URL));
        otherWebsiteList.add(new Website("Bang good", R.drawable.banggoodlogo, true, "https://www.banggood.in/"));
        otherWebsiteList.add(new Website("Wish shopping", R.drawable.wishlogo, false, WISH_URL));
        otherWebsiteList.add(new Website("Gearbest ", R.drawable.gearbestlogo, false, "https://www.gearbest.com/"));
        mOthersMLD.setValue(otherWebsiteList);
    }

    @Override
    public LiveData<List<Website>> getTopWebSites() {
        return mTopwebsiteMLD;
    }

    @Override
    public LiveData<List<Website>> getGenShoppingWebsites() {
        return mGenShoppingMLD;
    }

    @Override
    public LiveData<List<Website>> getFashionWebsites() {
        return mFashionMLD;
    }

    @Override
    public LiveData<List<Website>> getGrocFoodWebsites() {
        return mGrocFoodMLD;
    }

    @Override
    public LiveData<List<Website>> getOtherWebsites() {
        return mOthersMLD;
    }

}
