package mvplazic.app;

public class GroceryItem {

    private String name;
    private String country;
    private Integer calories;
    private Double price;

    private Integer image;

    public GroceryItem(String name, String country, Integer calories, Double price, Integer image) {
        this.name = name;
        this.country = country;
        this.calories = calories;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
