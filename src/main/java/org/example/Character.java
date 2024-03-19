package org.example;

public class Character {

    private String name;
    private Double healthscore;
    private Item[] weaponEquipt = new Item[1];

    public Character (String name, double healthscore) {
        this.name = name;
        this.healthscore = healthscore;
    }

    public String getName() {
        return name;
    }

    public Double getHealthscore() {
        return healthscore;
    }

    public Item[] getWeaponEquipt() {
        return weaponEquipt;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHealthscore(Double healthscore) {
        this.healthscore = healthscore;
    }

    public void setWeaponEquipt(Item weaponEquipt) {
        this.weaponEquipt = new Item[]{weaponEquipt};
    }

    public Item getEnenmyWeapon () {
        Item[] returnWeapon = weaponEquipt;
        Item weapon = returnWeapon[0];
        return weapon;
    }
}
