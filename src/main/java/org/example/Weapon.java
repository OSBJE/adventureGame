package org.example;

import org.example.Item;

public abstract class Weapon extends Item {


    // Attributes ///

    int weaponDmg = 0;
    int weaponShoots = 0;


    // constructor //


    public Weapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription);
        this.weaponDmg = weaponDmg;
        this.weaponShoots = weaponShoots;
    }


    // getter methods //
    public int getWeaponDmg() {
        return weaponDmg;
    }

    public int getWeaponShoots() {
        return weaponShoots;
    }


    // Setter methods //
    public void setWeaponDmg(int weaponDmg) {
        this.weaponDmg = weaponDmg;
    }

    public void setWeaponShoots(int weaponShoots) {
        this.weaponShoots = weaponShoots;
    }


    // methods to do dmg ect //

    public abstract void attack();


}
