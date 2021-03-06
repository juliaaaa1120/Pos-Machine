package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<ItemInfo> itemInfos = convertToItemInfos(barcodes);
        String receipt = renderReceipt(itemInfos);
        return receipt;
    }

    public List<ItemInfo> convertToItemInfos(List<String> barcodes) {
        List<ItemInfo> itemsInfo = ItemDataLoader.loadAllItemInfos();
        List<ItemInfo> itemsWithDetail = new ArrayList<>();
        Collections.sort(barcodes);
        for (int i = 0; i < barcodes.size(); i++) {
            for (int j = 0; j < itemsInfo.size(); j++) {
                if (barcodes.get(i).equals(itemsInfo.get(j).getBarcode())) {
                    itemsWithDetail.add(itemsInfo.get(j));
                }
            }
        }
        return itemsWithDetail;
    }

    public List<ReceiptItem> calculateReceiptItems(List<ItemInfo> itemsWithDetail) {
        List<ReceiptItem> receiptItems = new ArrayList<>();
        int currentCount = 1;
        for (int i = 1; i < itemsWithDetail.size(); i++) {
            if (itemsWithDetail.get(i).getBarcode().equals(itemsWithDetail.get(i - 1).getBarcode())) {
                currentCount += 1;
            } else {
                ReceiptItem receiptItem = new ReceiptItem(itemsWithDetail.get(i - 1).getBarcode(), itemsWithDetail.get(i - 1).getName(), itemsWithDetail.get(i - 1).getPrice(), currentCount);
                receiptItems.add(receiptItem);
                currentCount = 1;
            }
            if (i == itemsWithDetail.size() - 1) {
                ReceiptItem receiptItem = new ReceiptItem(itemsWithDetail.get(i).getBarcode(), itemsWithDetail.get(i).getName(), itemsWithDetail.get(i).getPrice(), currentCount);
                receiptItems.add(receiptItem);
            }
        }
        return receiptItems;
    }

    public int calculateTotalPrice(List<ReceiptItem> receiptItems) {
        int totalPrice = 0;
        for (int i = 0; i < receiptItems.size(); i++) {
            totalPrice += receiptItems.get(i).getPrice() * receiptItems.get(i).getQuantity();
        }
        return totalPrice;
    }

    public String renderReceipt(List<ItemInfo> itemsWithDetail) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("***<store earning no money>Receipt***\n");
        List<ReceiptItem> receiptItems = calculateReceiptItems(itemsWithDetail);
        for (int i = 0; i < receiptItems.size(); i++) {
            receipt.append("Name: " + receiptItems.get(i).getName() + ", ");
            receipt.append("Quantity: " + receiptItems.get(i).getQuantity() + ", ");
            receipt.append("Unit price: " + receiptItems.get(i).getPrice() + " (yuan), ");
            receipt.append("Subtotal: " + receiptItems.get(i).getPrice() * receiptItems.get(i).getQuantity() + " (yuan)\n");
        }
        receipt.append("----------------------\n");
        receipt.append("Total: " + calculateTotalPrice(receiptItems) + " (yuan)\n");
        receipt.append("**********************");
        return receipt.toString();
    }

}
