package ace.infosolutions.allinoneshoppingapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.repo.ListRepo;

public class ListViewModel extends ViewModel {

    private ListRepo repo;

    public ListViewModel() {
        repo = ListRepo.getInstance();
    }


    public LiveData<List<Website>> getTopWebsites() {
        return repo.getTopWebSites();
    }


}
