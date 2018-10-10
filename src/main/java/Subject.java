
public class Subject {

    private String text;
    private String picture_url;
    private String description;

    public Subject(String text, String picture_url, String description) {
        this.text = text;
        this.picture_url = picture_url;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
