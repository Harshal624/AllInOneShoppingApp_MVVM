package ace.infosolutions.allinoneshoppingapp.ui.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import ace.infosolutions.allinoneshoppingapp.R;
import ace.infosolutions.allinoneshoppingapp.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AppBarConfiguration mAppBarConfiguration;
    private ListViewModel viewModel;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = new ViewModelProvider(this).get(ListViewModel.class);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.genShoppingFragment,
                R.id.fashionFragment, R.id.groceryFoodFragment,
                R.id.othersFragment)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.genShoppingFragment) {
                setUpToolbarStatusbar(View.VISIBLE, R.color.app_green_color);
            } else if (destination.getId() == R.id.webViewFragment || destination.getId() == R.id.googleSearchFragment
                    || destination.getId() == R.id.anotherWebView) {
                setUpToolbarStatusbar(View.GONE, R.color.transparent);
            } else if (destination.getId() == R.id.fashionFragment) {
                setUpToolbarStatusbar(View.VISIBLE, R.color.fashion_pink);
            } else if (destination.getId() == R.id.groceryFoodFragment) {
                setUpToolbarStatusbar(View.VISIBLE, R.color.grocery_brown);
            } else if (destination.getId() == R.id.othersFragment) {
                setUpToolbarStatusbar(View.VISIBLE, R.color.others_purple);
            } else {
                setUpToolbarStatusbar(View.VISIBLE, R.color.purple_500);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setUpToolbarStatusbar(int visibility, int color) {
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL |
                AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        if (color == R.color.transparent) {
            toolbar.setVisibility(visibility);
            getWindow().setStatusBarColor(getResources().getColor(color));
        } else {
            toolbar.setVisibility(visibility);
            getWindow().setStatusBarColor(getResources().getColor(color));
            toolbar.setBackgroundColor(getResources().getColor(color));
        }
    }

}