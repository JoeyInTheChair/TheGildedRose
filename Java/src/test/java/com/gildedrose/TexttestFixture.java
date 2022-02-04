package com.gildedrose;

public class TexttestFixture {
    private final StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        new TexttestFixture().runGildedRose(args);
    }

    String runGildedRose(String[] args) {
        appendLine("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 31;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            itemStatus(i, items);
            app.updateQuality();
        }
        return output.toString();
    }
    private void itemStatus(int i, Item[] items) {
        appendLine("-------- day " + i + " --------");
        appendLine("name, sellIn, quality");
        for (Item item : items) {
            appendLine(item.toString());
        }
        appendLine("");
    }
    private void appendLine(String text) {
        output.append(text).append(System.lineSeparator());
    }

}
