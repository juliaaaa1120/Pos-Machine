package pos.machine;

public class ReceiptItem {
    private final String barcode;
    private final String name;
    private final int price;

    public ReceiptItem(String barcode, String name, int price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
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

}
