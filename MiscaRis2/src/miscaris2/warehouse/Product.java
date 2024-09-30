package miscaris2.warehouse;

public class Product {
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private boolean inStock;
    private String dateOfArrival;

    public Product(String name, String manufacturer, double price, int quantity, boolean inStock, String dateOfArrival) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.dateOfArrival = dateOfArrival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", inStock=" + inStock +
                ", dateOfArrival='" + dateOfArrival + '\'' +
                '}';
    }
}
