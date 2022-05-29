package onlineShop.app.onlineShop.entities.product;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @GeneratedValue
    @Id
    private long id;
    private String title;
    private String description;
    private String image;
    private long price;
    private boolean enable;
    private boolean exists;
    private Date addDate;



    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @JoinColumn(name = "visit_count")
    private long visitCount;

    @ManyToMany
    private List<Color> colors;

    @ManyToMany
    private List<Size> sizes;

    @ManyToMany
    private List<Feature> feature;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(long visitCount) {
        this.visitCount = visitCount;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<Feature> getFeature() {
        return feature;
    }

    public void setFeature(List<Feature> feature) {
        this.feature = feature;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void RemoveFeature(long id){
        Feature feature  = getFeature().stream().filter(x->x.getId() == id ).findFirst().get();
        getFeature().remove(feature);
    }

    public void addFeature(Feature feature){
        getFeature().add(feature);
    }
    public void RemoveColor(long id){
        Color color = getColors().stream().filter(x->x.getId() == id ).findFirst().get();
        getColors().remove(color);
    }

    public void addColor(Color color){
        getColors().add(color);
    }
    public void RemoveSize(long id){
        Size size = getSizes().stream().filter(x->x.getId() == id ).findFirst().get();
        getSizes().remove(size);
    }

    public void addSize (Size size){
        getSizes().add(size);
    }



}
