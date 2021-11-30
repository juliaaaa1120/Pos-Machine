package pos.machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemDataLoader {
    public static List<ItemInfo> loadAllItemInfos(List<ItemInfo> database) {
        ItemInfo item1Info = new ItemInfo("ITEM000000", "Coca-Cola", 3);
        ItemInfo item2Info = new ItemInfo("ITEM000001", "Sprite", 3);
        ItemInfo item3Info = new ItemInfo("ITEM000004", "Battery", 2);
        database.add(item1Info);
        database.add(item2Info);
        database.add(item3Info);

        return database;
    }

    public static List<String> loadBarcodes() {
        return Arrays.asList("ITEM000000", "ITEM000000", "ITEM000000", "ITEM000000", "ITEM000001", "ITEM000001", "ITEM000004", "ITEM000004", "ITEM000004");
    }
}
