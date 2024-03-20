package org.example;

public class MeleeWeapon extends Weapon {

    //****************** ATTRIBUTES **************************************************//
    // Arv fra Weapon

    // ***************** Constructor *********************************************** ///
    public MeleeWeapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription, weaponDmg, weaponShoots);
    }

    /// ************************* Getter methods **********************************////
    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Weapons damage output: " + weaponDmg;

    }

    //*************************** Method to manage shoots ****************************////
    @Override
    public void attack() {
    }

}
