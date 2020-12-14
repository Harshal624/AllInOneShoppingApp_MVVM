package ace.infosolutions.allinoneshoppingapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.repo.ListRepo;

public class ListViewModel extends ViewModel {
    private LiveData<List<Website>> mTopWebLiveData;
    private LiveData<List<Website>> mGenShopWebLiveData;

    private ListRepo repo;

    public ListViewModel() {
        repo = ListRepo.getInstance();
    }

    public void initTopWebsites() {
        if (mTopWebLiveData == null) {
            repo.retrieveTopWebSites();
            mTopWebLiveData = repo.getTopWebSites();
        }
    }

    public void initGenShopWebsites() {
        if (mGenShopWebLiveData == null) {
            repo.retrieveGenShopWebsites();
            mGenShopWebLiveData = repo.getGenShopwebsites();
        }
    }

    public LiveData<List<Website>> getTopWebSites() {
        return mTopWebLiveData;
    }

    public LiveData<List<Website>> getGenShoppingWebsites() {
        return mGenShopWebLiveData;
    }
}
