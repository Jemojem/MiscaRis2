package miscaris2.warehouse;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends User {
    private boolean hasClientCard = false;

    public Customer(String username, String password, Product[] products) {
        super(username, password, products);
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public void registerClientCard() {
        if (hasClientCard) {
            System.out.println("Карта клиента уже зарегистрирована.");
        } else {
            hasClientCard = true;
            System.out.println("Карта клиента успешно зарегистрирована!");
        }
    }

    public boolean hasClientCard() {
        return hasClientCard;
    }

    public void requestProductInfo() {
    	System.out.println("Доступные товары:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ". " + products[i].getName() + " Производитель: " + products[i].getManufacturer() + " Цена: " + products[i].getPrice() + " руб.");
        }
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        List<Product> selectedProducts = new ArrayList<>();
        List<Integer> selectedQuantities = new ArrayList<>();
        double totalCost = 0;

        while (true) {
            System.out.println("Введите индекс товара для заказа (или -1 для завершения выбора): ");
            int productIndex = scanner.nextInt();
            if (productIndex == -1) {
                break;
            }
            if (productIndex >= 0 && productIndex < products.length) {
                Product selectedProduct = products[productIndex];
                System.out.println("Введите количество для " + selectedProduct.getName() + ": ");
                int quantity = scanner.nextInt();

                if (selectedProduct.isInStock() && selectedProduct.getQuantity() >= quantity) {
                    selectedProducts.add(selectedProduct);
                    selectedQuantities.add(quantity);
                    totalCost += selectedProduct.getPrice() * quantity;
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                    System.out.println("Товар добавлен в заказ: " + selectedProduct.getName() + " в количестве " + quantity + " шт.");
                } else {
                    System.out.println("Недостаточно товара на складе или неверный выбор.");
                }
            } else {
                System.out.println("Неверный индекс товара.");
            }
        }

        System.out.println("\nВаш заказ:");
        for (int i = 0; i < selectedProducts.size(); i++) {
            Product p = selectedProducts.get(i);
            int qty = selectedQuantities.get(i);
            double cost = p.getPrice() * qty;
            System.out.println("Товар: " + p.getName() + ", Количество: " + qty + ", Цена за это количество: " + cost + " руб.");
        }

        if (this.hasClientCard()) {
            double discount = totalCost * 0.05;
            totalCost -= discount;
            System.out.println("Применена скидка 5%. Экономия: " + discount + " руб.");
        }

        System.out.println("Итоговая стоимость заказа: " + totalCost + " руб.");
    }
}