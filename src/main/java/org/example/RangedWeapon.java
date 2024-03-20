package org.example;

public class RangedWeapon extends Weapon {

    //****************** ATTRIBUTES **************************************************//
    // Arv fra Weapon


    // ***************** Constructor *********************************************** ///
    public RangedWeapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription, weaponDmg, weaponShoots);
    }

    /// ************************* Getter methods **********************************////
    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Weapons damage output: " + weaponDmg +
                "\n" + "Shoots in the weapon: " + weaponShoots;



    }

    //*************************** Method to manage shoots ****************************////
    @Override
    public void attack() { // ---> rename
        int remainingShots = getWeaponShoots() -1;
        setWeaponShoots(remainingShots);
    }

}
