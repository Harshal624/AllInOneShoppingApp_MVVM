package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ace.infosolutions.allinoneshoppingapp.databinding.FragmentResultlistBinding;
import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.ui.adapter.OnWebsiteClickListener;
import ace.infosolutions.allinoneshoppingapp.ui.adapter.SiteListRecyclerAdapter;
import ace.infosolutions.allinoneshoppingapp.viewmodel.ListViewModel;


public class ResultListFragment extends Fragment implements OnWebsiteClickListener {
    private static final String TAG = "ResultListFragment";
    private FragmentResultlistBinding binding;
    private SiteListRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultlistBinding.inflate(inflater, container, false);
        layoutManager = new LinearLayoutManager(getContext());
        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        adapter = new SiteListRecyclerAdapter(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerview.setAdapter(adapter);
        viewModel.getTopWebsites().observe(getViewLifecycleOwner(), websites -> adapter.submitList(websites));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void OnClick(Website website) {
        //open the webview here
        ResultListFragmentDirections.ActionResultListFragmentToWebViewFragment action =
                ResultListFragmentDirections.actionResultListFragmentToWebViewFragment(website, website.getTitle());
        Navigation.findNavController(getView()).navigate(action);
    }

}