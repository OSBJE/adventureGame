package org.example;

public class MeleeWeapon extends Weapon {



    // Constructor //
    public MeleeWeapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription, weaponDmg, weaponShoots);
    }


    @Override
    public void attack() {

    }

    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Weapons damage output: " + weaponDmg;

    }
}
