import java.util.Arrays;
import java.util.Scanner;

public class Merchant {
    Scanner scanner = new Scanner(System.in);
    public void menu() {
        System.out.println("1. Купить зелье здоровья.");
        System.out.println("2. Купить зелье силы.");
    }

    public Product[] getProducts() {
        return products;
    }

    private Product[] products;

    public void equip(Product item) {
        if (products == null) {
            products = new Product[1];
        } else {
            products = Arrays.copyOf(products, products.length + 1);
        }
        products[products.length - 1] = item;
    }
    public Product equipProduct(){
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                return new HealPotion();
            case 2:
                return new StrengthPotion();
        }
        return null;
    }
}

