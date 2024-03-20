package org.example;

import java.util.ArrayList;

public class Enemy extends Character {

    private String enemyDescription;
    private Weapon equippedWeapon;
    private Room room;


    public Enemy(String name, double healthscore, String description, Room room) {
        super(name, healthscore);
        this.enemyDescription = description;
        this.room = room;
    }


    public String getEnemyDescription() {
        return enemyDescription;
    }

    public void attackPlayer(Player player) { //DOJ
        if(getWeaponEquipt() != null) {
            int damage = equippedWeapon.getWeaponDmg();

            player.setHealthPlayer(player.getHealthPlayer()-damage);
        }
        System.out.println("nothing equiped ?");
    }
    public void enemyDies(Enemy enemy) { // DOJ Eventuelt
        if (getHealthscore() <= 0){
            dropWeapon();
            room.getEnemyArrayList().remove(enemy);
        }
    }

    public void dropWeapon() {
        Item toDrop = getWeaponEquipt();
        room.addItemsArrayList(toDrop);
    }

    @Override
    public String toString() {
        return "\n" + "Enemy: " + getName() + " Enemy description: " + enemyDescription;
    }

    public void setEnemyDescription(String enemyDescription) {
        this.enemyDescription = enemyDescription;
    }

}
