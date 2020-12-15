package ace.infosolutions.allinoneshoppingapp.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Website implements Parcelable {
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
    private boolean istopsite;
    private String url;


    public Website(String title, int icon, boolean istopsite, String url) {
        this.title = title;
        this.icon = icon;
        this.istopsite = istopsite;
        this.url = url;
    }

    protected Website(Parcel in) {
        title = in.readString();
        icon = in.readInt();
        istopsite = in.readByte() != 0;
        url = in.readString();
    }

    public static final Creator<Website> CREATOR = new Creator<Website>() {
        @Override
        public Website createFromParcel(Parcel in) {
            return new Website(in);
        }

        @Override
        public Website[] newArray(int size) {
            return new Website[size];
        }
    };

    @Override
    public int hashCode() {
        return Objects.hash(title, icon, istopsite, url);
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

    public boolean getIstopsite() {
        return istopsite;
    }

    public void setIstopsite(boolean istopsite) {
        this.istopsite = istopsite;
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
                url.equals(website.url) &&
                title.equals(website.title);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(icon);
        parcel.writeByte((byte) (istopsite ? 1 : 0));
        parcel.writeString(url);
    }
}
