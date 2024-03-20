package org.example;

import org.example.Item;

public abstract class Weapon extends Item {


    //****************** ATTRIBUTES **************************************************//
    int weaponDmg;
    int weaponShoots;

    // ***************** Constructor *********************************************** ///
    public Weapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription);
        this.weaponDmg = weaponDmg;
        this.weaponShoots = weaponShoots;
    }


    /// ************************* Getter methods **********************************////
    public int getWeaponDmg() {
        return weaponDmg;
    }

    public int getWeaponShoots() {
        return weaponShoots;
    }

    /// ************************* Setter methods **********************************////
    public void setWeaponDmg(int weaponDmg) {
        this.weaponDmg = weaponDmg;
    }

    public void setWeaponShoots(int weaponShoots) {
        this.weaponShoots = weaponShoots;
    }


    //*************************** Method to manage shoots **************************************////

    public abstract void attack();


}
