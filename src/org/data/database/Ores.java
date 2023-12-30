package org.data.database;

public enum Ores {
    SILVER_ORE(442);

    private final int itemId;

    Ores(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }
}
