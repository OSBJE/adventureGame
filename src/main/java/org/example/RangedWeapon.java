package org.example;

public class RangedWeapon extends Weapon {


    public RangedWeapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription, weaponDmg, weaponShoots);
    }

    @Override
    public void attack() {

    }

    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Weapons damage output: " + weaponDmg +
                "\n" + "Shoots in the weapon: " + weaponShoots;



    }

}
