package org.example;

public class Food extends Item{

    /// Tilføjelse attributes til vores Food class /////

    private double healthGain;
    private boolean poison;



    /// Constructor ////
    public Food(String item, String itemDescription, double healthGain, boolean poison) {
        super(item, itemDescription);
        this.healthGain = healthGain;
        this.poison = poison;
    }


    /// Getter methods /////
    public double getHealthGain() {
    return healthGain;
    }

    public boolean isPoison() {
        return poison;
    }

    /// Setter methods /////
    public void setHealthGain(double healthGain) {
        this.healthGain = healthGain;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }


    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Health given: " + healthGain +
                "\n" + "is it poison: " + (poison ? "Yes" : "No"); //ternary operator til if-else statement.



    }

}
