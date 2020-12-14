package ace.infosolutions.allinoneshoppingapp.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.model.Website;

public class ListRepo {
    private static final String TAG = "ListRepo";
    private static ListRepo instance;
    private MutableLiveData<List<Website>> mtopWebsiteslistMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Website>> mGenShoppingWebsitesMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Website>> mFashionWebsitesMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Website>> mGrocFoodWebsiteMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Website>> mOtherWebsiteMutableLiveData = new MutableLiveData<>();

    public static synchronized ListRepo getInstance() {
        if (instance == null)
            instance = new ListRepo();
        return instance;
    }

    public void retrieveTopWebSites() {
        List<Website> list = new ArrayList<>();
        list.add(new Website("Amazon", R.drawable.amazonlogo, true, "https://www.amazon.in/"));
        list.add(new Website("Flipkart", R.drawable.flipkartlogo, false, "https://www.flipkart.com/"));
        list.add(new Website("Snapdeal", R.drawable.snapdeallogo, true, "www.snapdeal.in"));
        list.add(new Website("Myntra", R.drawable.myntralogo, false, "www.myntra.com"));
        mtopWebsiteslistMutableLiveData.setValue(list);
    }

    public void retrieveGenShopWebsites() {
        List<Website> list = new ArrayList<>();
        list.add(new Website("Amazon", R.drawable.amazonlogo, true, "www.amazon.in"));
        list.add(new Website("Flipkart", R.drawable.flipkartlogo, false, "www.flipkart.in"));
        list.add(new Website("Snapdeal", R.drawable.snapdeallogo, true, "www.snapdeal.in"));
        list.add(new Website("Paytm mall", R.drawable.paytmmalllogo, false, "www.paytmmall.com"));
        mGenShoppingWebsitesMutableLiveData.setValue(list);
    }

    public LiveData<List<Website>> getTopWebSites() {
        return mtopWebsiteslistMutableLiveData;
    }

    public LiveData<List<Website>> getGenShopwebsites() {
        return mGenShoppingWebsitesMutableLiveData;
    }


}
