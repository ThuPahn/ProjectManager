package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    static Scanner sc = new Scanner(System.in);
    static ProductService service = new ProductService();
    static ArrayList<Product> products = service.createProductList();

    public static void showMenu() {
        System.out.println("----------" + "Menu Chính" + "----------");
        System.out.println("1. Xem toàn bộ sản phẩm");
        System.out.println("2. Thêm một sản phẩm");
        System.out.println("3. Tìm theo tên sản phẩm");
        System.out.println("4. Tìm sản phẩm theo ID");
        System.out.println("5. Liệt kê sản phẩm theo mặt hàng");
        System.out.println("0. Thoát chương trình");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void showSubMenu(Product product) {
        System.out.println("----------" + "Menu Sản Phẩm" + "----------");
        System.out.println("1. Đổi tên sản phẩm");
        System.out.println("2. Đổi giá sản phẩm");
        System.out.println("3. Loại bỏ sản phẩm");
        System.out.println("0. Quay về Menu chính");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void chooseMenuItem() {
        boolean isContinue = true;

        while (isContinue) {
            showMenu();

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> service.showProducts(products);
                case 2 -> addProduct();
                case 3 -> {
                    System.out.println("Nhập tên sản phẩm: ");
                    String searchName = sc.nextLine();
                    service.searchProductsByName(products, searchName);
                }
                case 4 -> getProductById();
                case 5 -> showProductsByCategory();
                case 0 -> isContinue = false;
                default -> System.out.println("Không có lựa chọn này");
            }
        }
    }

    private static void getProductById() {
        System.out.print("Nhập ID sản phẩm: ");
        long id = Long.parseLong(sc.nextLine());
        Product product = service.getProductById(products, id);
        if (product == null) {
            System.out.println("Không có sản phẩm bạn cần tìm theo ID");
        } else {
            System.out.println("Sản phẩm của bạn là: ");
            System.out.println(product);
            chooseSubMenuItem(product); // Go to submenu
        }
    }

    private static void showProductsByCategory() {
        while (true) {
            System.out.println("Chọn loại mặt hàng: ");
            for (int i = 0; i < Category.values().length; i++) {
                System.out.print(i + ". " + Category.values()[i] + "\t");
            }
            System.out.println();
            System.out.print("NHập lựa chọn cảu bạn: ");
            int categoryChoice = Integer.parseInt(sc.nextLine());
            if (categoryChoice >= 0 && categoryChoice < Category.values().length) {
                Category category = Category.values()[categoryChoice];
                service.showProductsByCategory(products, category);
                break;
            } else {
                System.out.println("Không có lựa chọn này");
            }
        }
    }

    private static void addProduct() {
        Product product = service.createProduct();
        service.addProduct(products, product);
        System.out.println("Sản phẩm đã được thêm: ");
        System.out.println(product);
    }

    public static void chooseSubMenuItem(Product product) {
        boolean isContinue = true;

        while (isContinue) {
            showSubMenu(product);

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    updateProductName(product);
                    break;
                case 2:
                    updateProductPrice(product);
                    break;
                case 3:
                    service.deleteProduct(products, product);
                    System.out.println("Đã loại bỏ sản phẩm");
                    isContinue = false;
                    break;
                case 0:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    private static void updateProductPrice(Product product) {
        System.out.print("Update giá sản phẩm: ");
        long newPrice = Long.parseLong(sc.nextLine());
        service.updateProductPrice(product, newPrice);
        System.out.println("Sản phẩm sau khi được sửa giá: ");
        System.out.println(product);
    }

    private static void updateProductName(Product product) {
        System.out.print("Update tên mới cho sản phẩm: ");
        String newName = sc.nextLine();
        service.updateProductName(product, newName);
        System.out.println("Sản phẩm sau khi được đổi tên: ");
        System.out.println(product);
    }

    public static void run() {
        service.initProductList(products);
        chooseMenuItem();
    }
}
