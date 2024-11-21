public class Main {
    public static void main(String[] args) {
        ProductList list = new ProductList();
        String productName = "Headphones";

        Product p1 = new Product("Laptop", 999.99, 5);
        Product p2 = new Product("Smartphone", 499.99, 10);
        Product p3 = new Product("Tablet", 299.99, 0);
        Product p4 = new Product("Smartwatch", 199.99, 3);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        System.out.println("Product List:\n");
        list.printList();

        System.out.println();
        System.out.println(list.totalValue());

        System.out.println();
        System.out.println(list.findMax());

        System.out.println();
        System.out.println(productName + " is in stock: " + list.isExist(productName));

        System.out.println();

        list.sortByQuantity();
        System.out.println("Product List sorted descending by quantity:");
        list.printList();

        System.out.println();

        list.sortByPrice();
        System.out.println("Product List sorted descending by price:");
        list.printList();
    }
}
