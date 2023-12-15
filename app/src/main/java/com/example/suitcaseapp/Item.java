package com.example.suitcaseapp;

public class Item {
    private String itemName;
    private boolean isPurchased;

    public Item(String itemName, boolean isPurchased) {
        this.itemName = itemName;
        this.isPurchased = isPurchased;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }
}

