import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ProductManagement productManagement = new ProductManagement();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            menu();
            System.out.println("Mời bạn chọn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    addProduct();
                    break;
                }
                case 2: {
                    updateProductInfo();
                    break;
                }
                case 3: {
                    deleteProductInfo();
                    break;
                }
                case 4: {
                    displayAllProduct();
                    break;
                }
                case 5: {
                    writeToFile("product.txt");
                    break;
                }
                case 6: {
                    readFile("product.txt");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        } while (choice != 0);
    }

    private static void displayAllProduct() {
        productManagement.displayAll();
    }

    private static void deleteProductInfo() {
        System.out.println("Nhập mã sản phẩm : ");
        String id = scanner.nextLine();
        int index = productManagement.findIndex(id);
        if (index != -1) {
            productManagement.deleteProduct(index);
        } else {
            System.out.println("Không thấy mã sản phẩm này!!");
        }
    }

    private static void updateProductInfo() {
        System.out.println("Nhập mã sản phẩm : ");
        String id = scanner.nextLine();
        int index = productManagement.findIndex(id);
        if (index != -1) {
            Product product = initProduct();
            productManagement.updateProduct(index, product);
        } else {
            System.out.println("Không thấy mã sản phẩm này!!");
        }
    }

    private static void addProduct() {
        Product product = initProduct();
        productManagement.addNew(product);
    }

    private static Product initProduct() {
        System.out.println("Mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Tên công ty: ");
        String company = scanner.nextLine();
        System.out.println("Giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ngày sản xuất: ");
        String date = scanner.nextLine();
        return new Product(id, name, company, price, date);

    }

    public static void readFile(String path) {
        try {
            InputStream inputStream = new FileInputStream(path);
            ObjectInputStream dataInputStream = new ObjectInputStream(inputStream);
            productManagement.productList = (List<Product>) dataInputStream.readObject();
        } catch (IOException e) {
            System.out.println("File nguồn không tồn tại hoặc đường dẫn bị lỗi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String path) {
        try {
            OutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(productManagement.productList);
        } catch (IOException e) {
            System.out.println("File nguồn không tồn tại hoặc đường dẫn bị lỗi");
        }
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị sản phẩm");
        System.out.println("5. Lưu dữ liêu");
        System.out.println("6. Xuất dữ liệu đã lưu");
        System.out.println("0. Thoát");
    }
}
