package ace.infosolutions.allinoneshoppingapp.repo;

import androidx.lifecycle.LiveData;

import java.util.List;

import ace.infosolutions.allinoneshoppingapp.model.Website;

public interface WebsiteRepository {
    LiveData<List<Website>> getTopWebSites();

    LiveData<List<Website>> getGenShoppingWebsites();

    LiveData<List<Website>> getFashionWebsites();

    LiveData<List<Website>> getGrocFoodWebsites();

    LiveData<List<Website>> getOtherWebsites();
}
