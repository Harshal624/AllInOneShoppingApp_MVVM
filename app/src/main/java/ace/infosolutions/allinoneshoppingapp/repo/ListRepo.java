package ace.infosolutions.allinoneshoppingapp.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.model.Website;

public class ListRepo implements WebsiteRepository {
    private static final String TAG = "ListRepo";
    private MutableLiveData<List<Website>> mTopwebsiteMLD = new MutableLiveData<>();
    private static ListRepo instance;

    ListRepo() {
        retrieveTopWebsites();
    }

    public static synchronized ListRepo getInstance() {
        if (instance == null)
            instance = new ListRepo();
        return instance;
    }

    public void retrieveTopWebsites() {
        Log.d(TAG, "retrieveTopWebsites: ");
        List<Website> topWebsiteList = new ArrayList<>();
        topWebsiteList.add(new Website("Amazon", R.drawable.amazonlogo, true, "www.amazon.in"));
        topWebsiteList.add(new Website("Flipkart", R.drawable.flipkartlogo, true, "www.flipkart.in"));
        topWebsiteList.add(new Website("Snapdeal", R.drawable.snapdeallogo, true, "www.snapdeal.in"));
        topWebsiteList.add(new Website("Zara", R.drawable.zaralogo, true, "www.zara.in"));
        mTopwebsiteMLD.setValue(topWebsiteList);
    }

    @Override
    public LiveData<List<Website>> getTopWebSites() {
        return mTopwebsiteMLD;
    }

    @Override
    public LiveData<List<Website>> getGenShoppingWebsites() {
        return null;
    }

    @Override
    public LiveData<List<Website>> getFashionWebsites() {
        return null;
    }

    @Override
    public LiveData<List<Website>> getGrocFoodWebsites() {
        return null;
    }

    @Override
    public LiveData<List<Website>> getOtherWebsites() {
        return null;
    }

}
