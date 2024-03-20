package org.example;

import java.util.ArrayList;

public class Enemy extends Character {

    //****************** ATTRIBUTES **************************************************//
    private String enemyDescription;
    private Weapon equippedWeapon;
    private Room room;


    // ***************** Constructor *********************************************** ///
    public Enemy(String name, double healthscore, String description, Room room, Weapon weapon) {
        super(name, healthscore);
        this.enemyDescription = description;
        this.room = room;
        this.equippedWeapon = weapon;
    }


    /// ************************* Getter methods **********************************////

    @Override
    public String toString() {
        return "\n" + "Enemy: " + getName() + " Enemy description: " + enemyDescription;
    }

    /// ************************* Setter methods **********************************////


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
