package ace.infosolutions.allinoneshoppingapp.di;

import ace.infosolutions.allinoneshoppingapp.ui.Fragment.HomeFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

}
