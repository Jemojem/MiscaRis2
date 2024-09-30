package miscaris2.warehouse;
import java.util.Arrays;

abstract class User {
    private String username;
    private String password;
    protected Product[] products;

    public User(String username, String password, Product[] products) {
        this.username = username;
        this.password = password;
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getRole();

    public void sortProducts(int criterion) {
        switch (criterion) {
            case 1:
                Arrays.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
                System.out.println("Товары отсортированы по названию.");
                break;
            case 2:
                Arrays.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
                System.out.println("Товары отсортированы по цене.");
                break;
            case 3:
                Arrays.sort(products, (p1, p2) -> p2.getDateOfArrival().compareTo(p1.getDateOfArrival()));
                System.out.println("Товары отсортированы по дате поступления.");
                break;
            default:
                System.out.println("Неверный критерий сортировки.");
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProductByName(String name) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товар с названием \"" + name + "\" не найден.");
        }
    }

    public void searchProductByPriceRange(double minPrice, double maxPrice) {
        boolean found = false;
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товары в диапазоне цен " + minPrice + " - " + maxPrice + " не найдены.");
        }
    }

    public void searchProductByManufacturer(String manufacturer) {
        boolean found = false;
        for (Product product : products) {
            if (product.getManufacturer().equalsIgnoreCase(manufacturer)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товары производителя \"" + manufacturer + "\" не найдены.");
        }
    }
}
