package miscaris2.warehouse;

import java.util.Scanner;

public class Main {
    static Product[] products = {
            new Product("Телевизор", "Samsung", 50000, 10, true, "2024-01-01"),
            new Product("Смартфон", "Apple", 80000, 5, true, "2024-02-01"),
            new Product("Ноутбук", "Dell", 60000, 3, true, "2024-03-01"),
        };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Добро пожаловать! Введите логин:");
            String username = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            if (username.equals("user") && password.equals("qwerty")) {
                Customer customer = new Customer(username, password, products);
                customerMenu(customer);
            } else if (username.equals("employee") && password.equals("admin")) {
                Employee employee = new Employee(username, password, products);
                employeeMenu(employee);
            } else {
                System.out.println("Неверные данные для входа.");
            }
        }

        private static void customerMenu(Customer customer) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            while (choice != 6) {
                System.out.println("\nМеню Покупателя:");
                System.out.println("1. Посмотреть товары");
                System.out.println("2. Оформить заказ");
                System.out.println("3. Зарегистрировать карту клиента");
                System.out.println("4. Поиск товара");
                System.out.println("5. Сортировка товаров");
                System.out.println("6. Выйти");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        customer.requestProductInfo();
                        break;
                    case 2:
                    	customer.requestProductInfo();
                        customer.placeOrder();
                        break;
                    case 3:
                        customer.registerClientCard();
                        break;
                    case 4:
                        searchMenu(customer);
                        break;
                    case 5:
                        sortMenu(customer);
                        break;
                    case 6:
                        System.out.println("Выход.");
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            }
        }


        private static void employeeMenu(Employee employee) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            while (choice != 7) {
                System.out.println("\nМеню Работника склада:");
                System.out.println("1. Посмотреть товары");
                System.out.println("2. Добавить новый товар");
                System.out.println("3. Удалить товар");
                System.out.println("4. Изменить товар");
                System.out.println("5. Поиск товаров");
                System.out.println("6. Сортировка товаров");
                System.out.println("7. Выйти");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        employee.viewProducts();
                        break;
                    case 2:
                        System.out.println("Введите название товара: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("Введите производителя: ");
                        String manufacturer = scanner.nextLine();
                        System.out.println("Введите цену: ");
                        double price = scanner.nextDouble();
                        System.out.println("Введите количество: ");
                        int quantity = scanner.nextInt();
                        System.out.println("Введите дату поступления: ");
                        scanner.nextLine();
                        String dateReceived = scanner.nextLine();
                        employee.registerNewProduct(name, manufacturer, price, quantity, dateReceived);
                        break;
                    case 3:
                        System.out.println("Введите индекс товара для удаления: ");
                        int productIndex = scanner.nextInt();
                        if (productIndex >= 0 && productIndex < products.length) {
                            employee.removeProduct(products[productIndex]);
                        } else {
                            System.out.println("Неверный индекс товара.");
                        }
                        break;
                    case 4:
                        System.out.println("Введите индекс товара для обновления: ");
                        productIndex = scanner.nextInt();
                        if (productIndex >= 0 && productIndex < products.length) {
                        	System.out.println("Введите новое название: ");
                            String newName = scanner.nextLine();
                            System.out.println("Введите новое название производителя: ");
                            String newManufacturer = scanner.nextLine();
                            System.out.println("Введите новую цену: ");
                            double newPrice = scanner.nextDouble();
                            System.out.println("Введите новое количество: ");
                            int newQuantity = scanner.nextInt();
                            System.out.println("Введите дату поступления: ");
                            String newDateOfArrival = scanner.nextLine();
                            employee.updateProduct(products[productIndex], newName, newManufacturer, newPrice, newQuantity, newDateOfArrival);
                        } else {
                            System.out.println("Неверный индекс товара.");
                        }
                        break;
                    case 5:
                        searchMenu(employee);

                        break;
                    case 6:
                        sortMenu(employee);
                        break; 
                    case 7:
                        System.out.println("Выход.");
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            }
        }

        private static void searchMenu(User user) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nМеню Поиска:");
            System.out.println("1. По названию");
            System.out.println("2. По производителю");
            System.out.println("3. По диапазону цен");
            int searchChoice = scanner.nextInt();

            switch (searchChoice) {
                case 1:
                    System.out.println("Введите название товара: ");
                    scanner.nextLine(); 
                    String name = scanner.nextLine();
                    user.searchProductByName(name);
                    break;
                case 2:
                    System.out.println("Введите производителя: ");
                    scanner.nextLine();
                    String manufacturer = scanner.nextLine();
                    user.searchProductByManufacturer(manufacturer);
                    break;
                case 3:
                    System.out.println("Введите минимальную цену: ");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Введите максимальную цену: ");
                    double maxPrice = scanner.nextDouble();
                    user.searchProductByPriceRange(minPrice, maxPrice);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }

        private static void sortMenu(User user) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nМеню Сортировки:");
            System.out.println("1. По названию");
            System.out.println("2. По цене");
            System.out.println("3. По дате поступления");
            int sortChoice = scanner.nextInt();

            user.sortProducts(sortChoice);
        }
    }