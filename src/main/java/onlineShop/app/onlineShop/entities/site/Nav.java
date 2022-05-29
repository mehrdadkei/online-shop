package onlineShop.app.onlineShop.entities.site;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nav {

    @GeneratedValue
    @Id
    private long id;
    private String title;
    private String link ;
    private boolean enable;
    private int ItemOrder;

    public int getItemOrder() {
        return ItemOrder;
    }

    public void setItemOrder(int itemOrder) {
        ItemOrder = itemOrder;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
