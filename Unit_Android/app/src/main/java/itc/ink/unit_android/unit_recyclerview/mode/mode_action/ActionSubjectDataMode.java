package itc.ink.unit_android.unit_recyclerview.mode.mode_action;

/**
 * Created by yangwenjiang on 2018/9/17.
 */

public class ActionSubjectDataMode {

    private String title = "TITLE";
    private String summary = "SUMMARY";
    private String gifurl = "";

    public ActionSubjectDataMode() {
    }

    public ActionSubjectDataMode(String title, String summary, String gifurl) {
        this.title = title;
        this.summary = summary;
        this.gifurl = gifurl;
    }

    @Override
    public String toString() {
        return "ActionSubjectDataMode{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
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

    public String getGifurl() {
        return gifurl;
    }

    public void setGifurl(String gifurl) {
        this.gifurl = gifurl;
    }
}
