package org.example;

import java.util.ArrayList;

public class Enemy {

    //****************** ATTRIBUTES **************************************************//
    private String name;
    private Double healthscore;
    private Item weaponEquipt;

    private String enemyDescription;
    private Weapon equippedWeapon;
    private Room room;


    // ***************** Constructor *********************************************** ///
    public Enemy(String name, double healthscore, String description, Room room, Weapon weapon) {
        this.healthscore = healthscore;
        this.name = name;
        this.enemyDescription = description;
        this.room = room;
        this.equippedWeapon = weapon;
    }


    /// ************************* Getter methods **********************************////

    public String getName() {
        return name;
    }

    public Double getHealthscore() {
        return healthscore;
    }

    public Item getWeaponEquipt() {
        return weaponEquipt;
    }

    public Item getEnenmyWeapon () {
        Item weapon = weaponEquipt;
        return weapon;
    }

    @Override
    public String toString() {
        return "\n" + "Enemy: " + getName() + " Enemy description: " + enemyDescription;
    }

    /// ************************* Setter methods **********************************////

    public void setHealthscore(Double healthscore) {
        this.healthscore = healthscore;
    }

    public void setWeaponEquipt(Item weaponEquipt) {
        this.weaponEquipt = weaponEquipt;

    }

    /// ************************* Attack and die functions ************************////

    // --- Attack this player --- //

    public void attackPlayer(Player player) {
        if(equippedWeapon != null) {
            int damage = equippedWeapon.getWeaponDmg(); // forklaring det her sette player health

            player.setHealthPlayer(player.getHealthPlayer()-damage);
        }
    }

    // --- Die function but is behaviours --- //
    public void enemyDies(Enemy enemy) { // DOJ Eventuelt
        if (getHealthscore() <= 0){
            dropWeapon();
            room.getEnemyArrayList().remove(enemy);
        }
    }

    // --- Helper method --- //
    public void dropWeapon() {
        Item toDrop = getWeaponEquipt();
        room.addItemsArrayList(toDrop);
    }

}
