package ace.infosolutions.allinoneshoppingapp.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.model.Website;

public class ListRepo {
    private static final String TAG = "ListRepo";
    private static ListRepo instance;
    private MutableLiveData<List<Website>> topWebsiteslistMutableLiveData = new MutableLiveData<>();

    public static synchronized ListRepo getInstance() {
        if (instance == null)
            instance = new ListRepo();
        return instance;
    }

    public void retrieveTopWebSites() {
        Log.d(TAG, "retrieveTopWebSites: ");
        List<Website> list = new ArrayList<>();
        list.add(new Website("Amazon", R.drawable.amazonlogo, true, "www.amazon.in"));
        list.add(new Website("Flipkart", R.drawable.flipkartlogo, false, "www.flipkart.in"));
        list.add(new Website("Nykaa", R.drawable.nykaalogo, true, "www.nukaa.co.in"));
        list.add(new Website("Zara", R.drawable.zaralogo, false, "www.zaraindia.com"));
        topWebsiteslistMutableLiveData.setValue(list);
    }

    public LiveData<List<Website>> getTopWebSites() {
        return topWebsiteslistMutableLiveData;
    }


}
