package org.example;

public class Items {



    // alt + insert for at generere getter&setter samt constructor og andet smart

    /// for at genere automatisk setter og getter "alt insert" vælg getter og sætter

    // Attributes ///
    // holder dem ad skildt inden i vores constructor

    private String item = "";   /// kniv, økse, bue
    private String itemDescription = "";  /// hvordan en masgisk + itemName
    private int itemDmg = 0;   /// Tildele weapon en skade værdi


    /// Konstructor /////


    public Items (String item, String itemDescription){
        this.item = item;
        this.itemDescription = itemDescription;
    }

    //// Getter methods ////

    public String getItem(){
        return item;
    }

    public String getItemDescription(){
        return itemDescription;
    }


    //// Setter Methods //////



}
