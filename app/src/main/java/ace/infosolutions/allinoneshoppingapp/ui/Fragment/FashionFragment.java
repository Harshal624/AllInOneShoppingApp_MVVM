package ace.infosolutions.allinoneshoppingapp.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ace.infosolutions.allinoneshoppingapp.databinding.FragmentFashionBinding;
import ace.infosolutions.allinoneshoppingapp.model.Website;
import ace.infosolutions.allinoneshoppingapp.ui.adapter.OnWebsiteClickListener;
import ace.infosolutions.allinoneshoppingapp.ui.adapter.SiteListRecyclerAdapter;
import ace.infosolutions.allinoneshoppingapp.viewmodel.ListViewModel;

public class FashionFragment extends Fragment implements OnWebsiteClickListener {
    private FragmentFashionBinding binding;
    private SiteListRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFashionBinding.inflate(inflater, container, false);
        //layoutManager = new LinearLayoutManager(getContext());
        layoutManager = new GridLayoutManager(getContext(), 2);
        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        adapter = new SiteListRecyclerAdapter(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setHasFixedSize(true);
        //   binding.recyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerview.setAdapter(adapter);

        viewModel.getFashionWesites().observe(getViewLifecycleOwner(), new Observer<List<Website>>() {
            @Override
            public void onChanged(List<Website> websites) {
                adapter.submitList(websites);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void OnClick(Website website) {
        FashionFragmentDirections.ActionFashionFragmentToWebViewFragment action =
                FashionFragmentDirections.actionFashionFragmentToWebViewFragment(website, website.getTitle());
        Navigation.findNavController(binding.getRoot()).navigate(action);

    }
}