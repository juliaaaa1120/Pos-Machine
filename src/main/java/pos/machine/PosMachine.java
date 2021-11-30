package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        return null;
    }

    public List<ItemInfo> convertToItemInfos(List<String> barcodes) {
        List<ItemInfo> itemsInfo = ItemDataLoader.loadAllItemInfos();
        List<ItemInfo> itemsWithDetail = new ArrayList<>();
        for (int i = 0; i < barcodes.size(); i++) {
            for (int j = 0; j < itemsInfo.size(); j++) {
                if (barcodes.get(i).equals(itemsInfo.get(j).getBarcode())) {
                    itemsWithDetail.add(itemsInfo.get(j));
                }
            }
        }
        return itemsWithDetail;
    }

}
