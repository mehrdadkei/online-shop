package onlineShop.app.onlineShop.entities.site;

import javax.persistence.*;

@Entity
@Table(name = "slider_nav")
public class Slider {

    @GeneratedValue
    @Id
    private long id;
    private String title;
    private String link;
    private String description;
    private Integer arrangement;
    private String image;
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getArrangement() {
        return arrangement;
    }

    public void setArrangement(Integer arrangement) {
        this.arrangement = arrangement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
