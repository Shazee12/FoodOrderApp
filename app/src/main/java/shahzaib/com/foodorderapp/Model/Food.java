package shahzaib.com.foodorderapp.Model;

/**
 * Created by shahzaib on 4/6/2018.
 */

public class Food {
    private String  Name , Image, Description ,Price ,Discount ,MenuId;
    public  Food() {}

    public Food(String name, String image, String description, String price, String discount, String menuid) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuId = menuid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuid() {
        return MenuId;
    }

    public void setMenuid(String menuid) {
        MenuId = menuid;
    }
}
