package tommy_kw.esoutline.model;

/**
 * Created by tomita on 15/06/26.
 */
public abstract class CommonFeedContentModel extends ListLayoutModel {
    private static final String TAG = CommonFeedContentModel.class.getSimpleName();

    private String title;
    private String description;
    private String siteUrl;
    private String imageUrl;
    private String date;

    public CommonFeedContentModel() {
        setType(LAYOUT_TYPE_1);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
