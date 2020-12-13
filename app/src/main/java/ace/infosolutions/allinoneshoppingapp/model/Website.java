package ace.infosolutions.allinoneshoppingapp.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Website {
    public static final DiffUtil.ItemCallback<Website> DIFF_CALLBACK = new DiffUtil.ItemCallback<Website>() {
        @Override
        public boolean areItemsTheSame(@NonNull Website oldItem, @NonNull Website newItem) {
            return oldItem.title.equals(newItem.title);
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Website oldItem, @NonNull Website newItem) {
            return oldItem.equals(newItem);
        }
    };
    private String title;
    private int icon;
    private boolean isaddedtofav;
    private String url;

    public Website(String title, int icon, boolean isaddedtofav, String url) {
        this.title = title;
        this.icon = icon;
        this.isaddedtofav = isaddedtofav;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isIsaddedtofav() {
        return isaddedtofav;
    }

    public void setIsaddedtofav(boolean isaddedtofav) {
        this.isaddedtofav = isaddedtofav;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return icon == website.icon &&
                isaddedtofav == website.isaddedtofav &&
                url.equals(website.url) &&
                title.equals(website.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, icon, isaddedtofav, url);
    }
}
