package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    public ArrayList<Product> createProductList() {
        return new ArrayList<Product>();
    }

    public void initProductList(ArrayList<Product> products) {
        Product p1 = new Product(1, "Bánh", 2000, 25, Category.FOOD, 19);
        products.add(p1);

        Product p2 = new Product(2, "Sách giáo khoa", 50000, 260, Category.HOUSEHOLD, 153);
        products.add(p2);

        Product p3 = new Product(3, "Áo sơ mi", 450000, 25, Category.FASHION, 5);
        products.add(p3);
        Product p4 = new Product(4, "Bánh", 2000, 25, Category.FOOD, 19);
        products.add(p1);

        Product p5 = new Product(5, "Sách giáo khoa", 50000, 260, Category.HOUSEHOLD, 153);
        products.add(p2);

        Product p6 = new Product(6, "Áo sơ mi", 450000, 25, Category.FASHION, 5);
        products.add(p3);
        Product p7 = new Product(7, "Bánh", 2000, 25, Category.FOOD, 19);
        products.add(p1);

        Product p8 = new Product(8, "Sách giáo khoa", 50000, 260, Category.HOUSEHOLD, 153);
        products.add(p2);

        Product p9 = new Product(9, "Áo sơ mi", 450000, 25, Category.FASHION, 5);
        products.add(p3);

    }

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập các thông tin của sản phẩm: ");

        System.out.print("Nhấp ID sản phẩm: ");
        long id = Long.parseLong(sc.nextLine());

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá bán: ");
        long price = Long.parseLong(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Category category;
        while (true) {
            System.out.println("Chọn loại mặt hàng: ");
            for (int i = 0; i < Category.values().length; i++) {
                System.out.print(i + ". " + Category.values()[i] + "\t");
            }
            System.out.println();
            System.out.print("Nhập lựa chọn của bạn: ");
            int categoryChoice = Integer.parseInt(sc.nextLine());
            if (categoryChoice >= 0 && categoryChoice < Category.values().length) {
                category = Category.values()[categoryChoice];
                break;
            } else {
                System.out.println("Không có lựa chọn này");
            }
        }

        System.out.print("Nhập số lượng bán: ");
        int soldQuantity = Integer.parseInt(sc.nextLine());

        Product product = new Product(id, name, price, quantity, category, soldQuantity);
        return product;
    }

    public void addProduct(ArrayList<Product> products, Product product) {
        products.add(product);
    }

    public Product getProductById(ArrayList<Product> products, long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductsByCategory(ArrayList<Product> products, Category category) {
        ArrayList<Product> productsOfCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsOfCategory.add(product);
            }
        }
        return productsOfCategory;
    }

    public void showProductsByCategory(ArrayList<Product> products, Category category) {
        ArrayList<Product> productsOfCategory = getProductsByCategory(products, category);
        if (productsOfCategory.size() == 0) {
            System.out.println("Không có sản phẩm nào của bạn tìm");
        } else {
            System.out.println("Các sản phẩm bạn tìm là " + category + ": ");
            for (Product product : productsOfCategory) {
                System.out.println(product);
            }
        }
    }

    public void showProducts(ArrayList<Product> products) {
        System.out.println("Danh sách sản phẩm1: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProductsByName(ArrayList<Product> products, String searchName) {
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    public void updateProductName(Product product, String newName) {
        product.setName(newName);
    }

    public void updateProductPrice(Product product, long newPrice) {
        product.setPrice(newPrice);
    }

    public void deleteProduct(ArrayList<Product> products, Product product) {
        products.remove(product);
    }
}
