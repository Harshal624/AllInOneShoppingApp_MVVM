package ace.infosolutions.allinoneshoppingapp.di;


import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import ace.infosolutions.allinoneshoppingapp.R;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions.placeholderOf(R.color.white)
                .error(R.color.white);
    }

    @Provides
    static RequestManager provideRequestManager(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }
}
