package itc.ink.unit_android.unit_recyclerview.mode.mode_solution;

/**
 * Created by yangwenjiang on 2018/9/16.
 */

public class SolutionDataMode {
    private String title = "方案名称";
    private String summary = "方案描述";
    private String imageurl = "";
    private String imageurl_left = "";
    private String imageurl_right = "";
    private String gifurl = "";

    public SolutionDataMode() {
    }

    public SolutionDataMode(String title, String summary, String imageurl, String imageurl_left, String imageurl_right, String gifurl) {
        this.title = title;
        this.summary = summary;
        this.imageurl = imageurl;
        this.imageurl_left = imageurl_left;
        this.imageurl_right = imageurl_right;
        this.gifurl = gifurl;
    }

    @Override
    public String toString() {
        return "SolutionDataMode{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", imageurl_left='" + imageurl_left + '\'' +
                ", imageurl_right='" + imageurl_right + '\'' +
                ", gifurl='" + gifurl + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl_left() {
        return imageurl_left;
    }

    public void setImageurl_left(String imageurl_left) {
        this.imageurl_left = imageurl_left;
    }

    public String getImageurl_right() {
        return imageurl_right;
    }

    public void setImageurl_right(String imageurl_right) {
        this.imageurl_right = imageurl_right;
    }

    public String getGifurl() {
        return gifurl;
    }

    public void setGifurl(String gifurl) {
        this.gifurl = gifurl;
    }
}
