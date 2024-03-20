package org.example;

public class Item {

    //****************** ATTRIBUTES **************************************************//
    private String item;   /// kniv, økse, bue
    private String itemDescription;  /// hvordan en masgisk + itemName

    // ***************** Constructor *********************************************** ///

    public Item (String item, String itemDescription){
        this.item = item;
        this.itemDescription = itemDescription;
    }

    /// ************************* Getter methods **********************************////
    public String getItem(){
        return item;
    }

    public String getItemDescription(){
        return itemDescription;
    }
    @Override
    public String toString() {
        return "\n" + "Item: " + item + " Item Description: " + itemDescription;
    }


    /// ************************* Setter methods **********************************////

}
