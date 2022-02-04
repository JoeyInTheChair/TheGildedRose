package com.gildedrose;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseUnitTest {

    @Test
    public void standardItem_sellInAndQualityReduceByOne() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 1, 20) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 0, 19);
    }

    @Test
    public void standardItem_passSellByDateQualityReduceByTwo() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 7) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], -2, 5);
    }

    @Test
    public void standardItem_initialSellByDateIsZeroQualityReduceByTwo() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 7) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], -1, 5);
    }

    @Test
    public void standardItem_maxQualityAboveFiftySameBehaviour() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 7, 53) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 6, 52);
    }

    @Test
    public void standardItem_initialQualityIsNegative() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 7, -10) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 6, -10);
    }

    @Test
    public void agedBrieAlwaysIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 1, 1);
    }

    @Test
    public void sulfurasHandOfRagnaros_pastSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], -1, 80);
    }

    @Test
    public void sulfurasHandOfRagnaros_beforeSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 1, 80);
    }

    @Test
    public void standardBackstagePassesToATAFKAL80ETCConcertUpdate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 9, 42);
    }

    @Test
    public void BackstagePassesToATAFKAL80ETCConcert_withElevenDaysTillSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 10, 41);
    }

    @Test
    public void BackstagePassesToATAFKAL80ETCConcert_pastSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 40) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], -2, 0);
    }

    @Test
    public void BackstagePassesToATAFKAL80ETCConcert_qualityStopsIncreasingPastFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };
        GildedRose itemTest = new GildedRose(items);
        itemTest.updateQuality();
        assertSellInAndQuality(items[0], 4, 50);
    }

    private void assertSellInAndQuality(Item item, int sellIn, int quality) {
        assertEquals("Unexpected sellIn value", sellIn, item.sellIn);
        assertEquals("Unexpected quality value", quality, item.quality);
    }
}
