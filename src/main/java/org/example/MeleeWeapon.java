package org.example;

public class MeleeWeapon extends Weapon {



    // Constructor //
    public MeleeWeapon(String item, String itemDescription, int weaponDmg, int weaponShoots) {
        super(item, itemDescription, weaponDmg, weaponShoots);
    }


    @Override
    public void attack() {
        int weaponDMG =  getWeaponDmg();
        int remainingShots = getWeaponShoots() -1;
        //setWeaponShoots(remainingShots);
        // Vi behøver ikke at "deplete" vores shoots på vores melee weapon, medmindre vi ønsker at implementere "Durability" på melee weapons.
        // I så fald kommenter setter metoden tilbage og tilpas toString metoden til at display durability mm.

    }

    @Override
    public String toString() {
        return "\n" + "Item: " + getItem() +
                "\n" + "Item Description: " + getItemDescription() +
                "\n" + "Weapons damage output: " + weaponDmg;

    }
}
