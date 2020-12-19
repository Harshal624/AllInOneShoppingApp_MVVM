package ace.infosolutions.allinoneshoppingapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ace.infosolutions.allinoneshoppingapp.databinding.ItemSitelistBinding;
import ace.infosolutions.allinoneshoppingapp.model.Website;

public class SiteListRecyclerAdapter extends ListAdapter<Website, SiteListRecyclerAdapter.ViewHolder> {
    OnWebsiteClickListener listener;

    public SiteListRecyclerAdapter(OnWebsiteClickListener listener) {
        super(Website.DIFF_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSitelistBinding binding = ItemSitelistBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemSitelistBinding binding;

        public ViewHolder(@NonNull ItemSitelistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view -> {
                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION) {
                    Website website = getItem(position);
                    listener.OnClick(website);
                }
            });
        }

        private void bind(Website item) {
            binding.tvTitle.setText(item.getTitle());
            Glide.with(binding.getRoot()).load(item.getIcon()).fitCenter().into(binding.civLogo);
        }
    }
}
