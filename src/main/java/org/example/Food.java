package org.example;

public class Food extends Item{

    //****************** ATTRIBUTES **************************************************//
    private double healthGain;
    private boolean poison;

    /// "Instance of" check om det er object Food ///

    // ***************** Constructor *********************************************** ///
    public Food(String item, String itemDescription, double healthGain, boolean poison) {
        super(item, itemDescription);
        this.healthGain = healthGain;
        this.poison = poison;
    }


    /// ************************* Getter methods **********************************////
    public double getHealthGain() {
        return healthGain;
        }

    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() + " Item Description: " + getItemDescription() + " Health given: " + healthGain +" Poison?: " + (poison ? "Yes" : "No"); //ternary operator til if-else statement.
    }


    /// ************************* Setter methods **********************************////

}
