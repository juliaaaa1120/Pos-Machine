package pos.machine;

public class ReceiptItem {
    private final String barcode;
    private final String name;
    private final int price;
    private final int quantity;

    public ReceiptItem(String barcode, String name, int price, int quantity) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
