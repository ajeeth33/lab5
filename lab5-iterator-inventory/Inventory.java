import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("(inventory empty)");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    // Finds and removes two items safely using Iterator, then adds a combined item
    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();

            if (!found1 && current.getName().equalsIgnoreCase(name1)) {
                found1 = true;
                iter.remove(); // safe removal
            } else if (!found2 && current.getName().equalsIgnoreCase(name2)) {
                found2 = true;
                iter.remove(); // safe removal
            }

            // stop early if both found
            if (found1 && found2) break;
        }

        if (found1 && found2) {
            String combinedName = name1 + " + " + name2;
            items.add(new Item(combinedName));
            System.out.println("Combined into: " + combinedName);
        } else {
            System.out.println("Combine failed. Missing item(s): "
                    + (found1 ? "" : name1 + " ")
                    + (found2 ? "" : name2));
        }
    }
}
