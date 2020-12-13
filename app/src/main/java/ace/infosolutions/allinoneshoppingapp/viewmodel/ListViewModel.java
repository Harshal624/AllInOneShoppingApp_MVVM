package ace.infosolutions.allinoneshoppingapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.repo.ListRepo;

public class ListViewModel extends ViewModel {
    private LiveData<List<Website>> topwebsitesLiveData;
    private ListRepo repo;

    public ListViewModel() {
        repo = ListRepo.getInstance();
        if (topwebsitesLiveData == null) {
            repo.retrieveTopWebSites();
            topwebsitesLiveData = repo.getTopWebSites();
        }
    }

    public LiveData<List<Website>> getTopWebSites() {
        return topwebsitesLiveData;
    }
}
