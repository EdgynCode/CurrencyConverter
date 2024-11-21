import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductList {
    private List<Product> list;

    public ProductList() {
        list = new ArrayList<>();
    }

    public void add(Product p) {
        list.add(p);
    }

    public void printList() {
        for (Product i : list) {
            i.printDetail();
        }
    }

    public String totalValue() {
        double totalSum = 0.0;
        for (Product i : list) {
            totalSum += i.getPrice();
        }

        StringBuilder out = new StringBuilder();
        out.append(String.format("%.2f", totalSum));
        String str = out.toString();

        // Insert commas
        int pos = str.indexOf('.');
        for (int i = pos - 3; i > 0; i -= 3) {
            str = new StringBuilder(str).insert(i, ",").toString();
        }

        return "Total inventory value: " + str;
    }

    public String findMax() {
        if (list.isEmpty())
            return "No products available.";

        double maxPrice = 0.0;
        String maxProductName = "";

        for (Product i : list) {
            if (i.getPrice() > maxPrice) {
                maxPrice = i.getPrice();
                maxProductName = i.getName();
            }
        }
        return "Most expensive product: " + maxProductName;
    }

    public boolean isExist(String productName) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getName().equals(productName))
                return true;
            if (list.get(mid).getName().compareTo(productName) < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public void sortByQuantity() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getQuantity() < list.get(j).getQuantity()) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public void sortByPrice() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getPrice() < list.get(j).getPrice()) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
