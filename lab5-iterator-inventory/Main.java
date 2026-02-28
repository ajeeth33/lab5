public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        // Add starting items
        inv.addItem(new Item("Stick"));
        inv.addItem(new Item("Crystal"));
        inv.addItem(new Item("Rope"));

        System.out.println("Inventory BEFORE combine:");
        inv.display();

        System.out.println("\nCombining Stick and Crystal...");
        inv.combineItems("Stick", "Crystal");

        System.out.println("\nInventory AFTER combine:");
        inv.display();
    }
}
