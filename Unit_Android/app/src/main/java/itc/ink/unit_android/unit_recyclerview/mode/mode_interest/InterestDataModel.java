package itc.ink.unit_android.unit_recyclerview.mode.mode_interest;

/**
 * Created by yangwenjiang on 2018/9/13.
 */

public class InterestDataModel {
    private String title = "产品/方案名称";
    private String summary = "产品/方案描述";
    private String supportnum = "支持票数";
    private String imageurl = "";

    public InterestDataModel() {
    }

    public InterestDataModel(String title, String summary, String supportnum, String imageurl) {
        this.title = title;
        this.summary = summary;
        this.supportnum = supportnum;
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "InterestDataModel{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", supportnum='" + supportnum + '\'' +
                ", imageurl='" + imageurl + '\'' +
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

    public String getSupportnum() {
        return supportnum;
    }

    public void setSupportnum(String supportnum) {
        this.supportnum = supportnum;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
