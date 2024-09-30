package miscaris2.warehouse;

class Employee extends User {

    public Employee(String username, String password, Product[] products) {
        super(username, password, products);
    }

    @Override
    public String getRole() {
        return "Employee";
    }

    public void viewProducts() {
        System.out.println("Список товаров:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ". " + products[i].getName() + " Производитель: " + products[i].getManufacturer() + " Цена: " + products[i].getPrice() + " руб." + " Количество на складе: " + products[i].getQuantity() + " Дата поступления: " + products[i].getDateOfArrival());
        }
    }

    public void registerNewProduct(String name, String manufacturer, double price, int quantity, String dateOfArrival) {
        Product newProduct = new Product(name, manufacturer, price, quantity, quantity > 0, dateOfArrival);
        System.out.println("Новый товар зарегистрирован: " + newProduct);
    }

    public void removeProduct(Product product) {
        product.setInStock(false);
        System.out.println("Товар " + product.getName() + " удалён.");
    }

    public void updateProduct(Product product, String newName, String newManufacturer, double newPrice, int newQuantity, String newDateOfArrival) {
        product.setName(newName);
        product.setManufacturer(newManufacturer);
        product.setDateOfArrival(newDateOfArrival);
    	product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        product.setInStock(newQuantity > 0);
        System.out.println("Товар обновлён: " + product);
    }
    public void registerClientCard(String clientName) {
        System.out.println("Карта клиента зарегистрирована для: " + clientName);
    }
}


