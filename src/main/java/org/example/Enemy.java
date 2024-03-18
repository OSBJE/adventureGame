package org.example;

public class Enemy extends Character {

    private String enemyDescription;

    public Enemy(String name, double healthscore, String description) {
        super(name, healthscore);
        this.enemyDescription = description;
    }
    public String getEnemyDescription() {
        return enemyDescription;
    }
    public void setEnemyDescription(String enemyDescription) {
        this.enemyDescription = enemyDescription;
    }
    public void looseItemByDeath(Item weaponToLoose) {
        //kode skal skrives

    }
}
