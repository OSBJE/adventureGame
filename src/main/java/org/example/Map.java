package org.example;

public class Map {
    //****************** ATTRIBUTES **************************************************//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.
    private Room startRoom;
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    // ***************** Constructor *********************************************** ///
    // Når et spil startes, kalder den sin metode buildGame.
    // kald metoden i constructor

    public Map() {
        buildMap();
    }


    //*** Methods ***//
    // Nedståden metode bygger vores "rooms map"


    /// ************************* Getter methods **********************************////

    // --- method to get player started --- //
    public Room getFirstRoom() {
        return startRoom;
    }


    /// *********************** Map construction **********************************////
    // --- build map opskrift ---//
    public void buildMap() {
        // vi starter med at lave 9 room objekter, et som repræsenterer hvert room i vores spil
        //

        this.room1 = new Room("Room 1", "This is a beautiful green hill with a nice view.\nIn the distance you spot a cozy cottage. You spot fire coming out of the chimney and \nyou get the sense that this meadow is safe. For now.\n");
        this.room2 = new Room("Room 2", "This is a dark cave with a thousand bats. Watch out! \nWhen entering the room you are immediately greeted by the shrieking noise of large bats.\nYou stumble to the ground in an attempt to get your footing.");
        this.room3 = new Room("Room 3", "You close the door behind you and turn around. This is a cold icy mountain. The mountaintop \nis covered by a cover of untouched snow. You see the wind in a tumultuous fight with the peaks forever destined to\nstrip the snow from the mountaintop.");
        this.room4 = new Room("Room 4", "You somehow find yourself in a wooden cottage on the verge of collapse. You get the sense \nthat you need to be careful to escape unscathed.");
        this.room5 = new Room("Room 5", "On the wall you see the logo of a Goose followed by the words 'JYSK'. You enter an enormous warehouse \nfilled with things that seem out of place.");
        this.room6 = new Room("Room 6", "You close the door and are met with an unnatural heat. You start sweating. You realise this is an erupting volcano.");
        this.room7 = new Room("Room 7", "You see huge buildings reaching beyond the blue sky. You hear the bustling noise of polluting traffic.\nThese people have no idea what's beyond their metropolis.");
        this.room8 = new Room("Room 8", "You find respite in an olive grove. You hear the noise of a busy waterfall in the distance. This is an olive grove filled with butterflies.\nStay a moment, maybe.");
        this.room9 = new Room("Room 9", "You encroach upon the memories of the dead. This is a battlefield lost in time. Based on the uniforms of \nthe soldiers you believe them to be german. The sound of artillery being fired and the smell of gunpowder\nhas you aware. Keep your head down.");

        // Her skal vi have forbindelserne mellem de forskellige "Rooms"

        // Her er forbindelserne mellem room1
        room1.setRoomDoorEast(room2);
        room1.setRoomDoorSouth(room4);

        // Her er forbindelserne mellem room2
        room2.setRoomDoorWest(room1);
        room2.setRoomDoorEast(room3);

        // her er forbindelserne mellem room 3
        room3.setRoomDoorWest(room2);
        room3.setRoomDoorSouth(room6);

        // her forbindelserne mellem room 4
        room4.setRoomDoorNorth(room1);
        room4.setRoomDoorSouth(room7);

        // Her er forbindelserne mellem room 5
        room5.setRoomDoorSouth(room8);

        // her er forbindelserne mellem room 6
        room6.setRoomDoorNorth(room3);
        room6.setRoomDoorSouth(room9);

        // Her er forbindelserne mellem room 7
        room7.setRoomDoorNorth(room4);
        room7.setRoomDoorEast(room8);

        // Her er forbindelserne mellem room 8
        room8.setRoomDoorNorth(room5);
        room8.setRoomDoorWest(room7);
        room8.setRoomDoorEast(room9);

        // Her er forbindelserne mellem room 9
        room9.setRoomDoorNorth(room6);
        room9.setRoomDoorWest(room8);

        // Her har vi det endelig kort.

        startRoom = room1;
        buildAndPlaceItems();
        buildAndPlaceEnemies();

    }

    // --- Helper method to fill map --- //
    public void buildAndPlaceItems() {

        Food itemApple = new Food("Apple", "Seems to be from the tale of Snow White", -15, true);
        Food itemMeat = new Food("Meat", "You think it's from a cow.", 25, false);
        Food itemBanana = new Food("Banana", "You seem to remember this from minions.", 10, false);
        Food itemProteinBar = new Food("Protein Bar", "It says 'property of Arnold's gym.", 35, false);
        Item itemKnife = new MeleeWeapon("Knife", "It's magically ugly... Whatever that means.", 10, 1000);
        Item itemSword = new MeleeWeapon("Sword", "What you'd expect.", 10, 1000);
        Item itemAxe = new MeleeWeapon("Axe", "The name 'Gimli' is inscribed on the weapon.", 25, 1000);
        Item itemWashboard = new RangedWeapon("Washboard", "A small note is attached saying 'Remember to do your laundry.", 50, 2);
        Item jarOfHoney = new Food("The Jar of honey", "It tastes delicious.", 60, false);

        room3.addItemsArrayList(itemKnife);
        room3.addItemsArrayList(itemSword);
        room3.addItemsArrayList(itemAxe);
        room7.addItemsArrayList(itemWashboard);
        room2.addItemsArrayList(itemApple);
        room2.addItemsArrayList(itemMeat);
        room4.addItemsArrayList(itemBanana);
        room7.addItemsArrayList(itemProteinBar);
        room8.addItemsArrayList(jarOfHoney);


    }

    public void buildAndPlaceEnemies() {
        //Monster Items
        Item enemyItem1 = new MeleeWeapon("Rapier", "An elegant rapier.", 5, 1000);
        Item enemyItem2 = new RangedWeapon("Bow", "Sweet Jesus, it is big.", 10, 2);
        Item enemyItem3 = new RangedWeapon("Handgrenade", "It's very holy.", 20, 1);
        Item enemyItem4 = new MeleeWeapon("Mattress", "It's super cheap.", - 5, 1000);
        Item enemyItem5 = new RangedWeapon("Blaster", "Hard to hit with.", 0, 10);
        Item enemyItem6 = new MeleeWeapon("The Bee Stinger", "If you are allergic you will die.", 35, 1000);
        Item enemyItem7 = new RangedWeapon("The Portalgun", "It is missing fluid.", 10, 3);

        //Enemies with items
        Enemy enemy1 = new Enemy("Bob", 50, "Jose Mourinho", room2, (Weapon) enemyItem1); //new MeleeWeapon("Rapier", "", 10, 1000)
        enemy1.setWeaponEquipt(enemyItem1);// really wird but only this works !
        Enemy enemy2 = new Enemy("Legolas", 25, "Only 42.", room4, (Weapon) enemyItem2);
        enemy2.setWeaponEquipt(enemyItem2);
        Enemy enemy3 = new Enemy("Rabbit", 30, "Get the holy handgrenade.", room4, (Weapon) enemyItem3);
        enemy3.setWeaponEquipt(enemyItem3);
        Enemy enemy4 = new Enemy("Lars Larsen", 75,"Han har et godt tilbud.", room5, (Weapon) enemyItem4);
        enemy4.setWeaponEquipt(enemyItem4);
        Enemy enemy5 = new Enemy("Storm Trooper", 30, "Not very scary.", room6, (Weapon) enemyItem5);
        enemy5.setWeaponEquipt(enemyItem5);
        Enemy enemy6 = new Enemy("Bee", 10, "It's a honey Bee.", room7, (Weapon) enemyItem6);
        enemy6.setWeaponEquipt(enemyItem6);
        Enemy enemy7 = new Enemy("Morty", 2, "Ohh jeeeee", room9,(Weapon) enemyItem7);
        enemy7.setWeaponEquipt(enemyItem7);

        // enemy1.setWeaponEquipt((Weapon) itemAxe); //DOJ


        room2.addEnemyArrayList(enemy1);
        room4.addEnemyArrayList(enemy2);
        room4.addEnemyArrayList(enemy3);
        room5.addEnemyArrayList(enemy4);
        room6.addEnemyArrayList(enemy5);
        room7.addEnemyArrayList(enemy6);
        room9.addEnemyArrayList(enemy7);
    }
}
