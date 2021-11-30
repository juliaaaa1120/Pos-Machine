package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        return null;
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
                ReceiptItem receiptItem = new ReceiptItem(itemsWithDetail.get(i - 1).getBarcode(), currentCount);
                receiptItems.add(receiptItem);
                currentCount = 1;
            }
            if (i == itemsWithDetail.size() - 1) {
                ReceiptItem receiptItem = new ReceiptItem(itemsWithDetail.get(i).getBarcode(), currentCount);
                receiptItems.add(receiptItem);
            }
        }
        return receiptItems;
    }

}
