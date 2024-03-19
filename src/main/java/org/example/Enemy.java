package org.example;

import java.util.ArrayList;

public class Enemy extends Character {

    private String enemyDescription;
    private Weapon equippedWeapon;


    public Enemy(String name, double healthscore, String description, Weapon weapon) {
        super(name, healthscore);
        this.enemyDescription = description;
        this.equippedWeapon = weapon;
    }



    public String getEnemyDescription() {
        return enemyDescription;
    }

    public void attackPlayer(Player player) { //DOJ
        if(getWeaponEquipt() != null) {
            int damage = equippedWeapon.getWeaponDmg();

            player.setHealthPlayer(player.getHealthPlayer()-damage);
        }
    }
    public void enemyDies() { // DOJ Eventuelt
        if(getHealthscore() <= 0) {
            System.out.println("DEBUG enemy dør");
            //Skal connectes til room for drop våben?


        }
    }
    @Override
    public String toString() {
        return "\n" + "Enemy: " + getName() + " Enemy description: " + enemyDescription;
    }

    public void setEnemyDescription(String enemyDescription) {
        this.enemyDescription = enemyDescription;
    }
    public void looseItemByDeath(Item weaponToLoose) {
        //kode skal skrives

    }
}
