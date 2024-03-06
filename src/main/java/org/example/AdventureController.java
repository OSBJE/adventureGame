package org.example;

public class AdventureController {


    // Her kalder vi de forskellige instancer af vores class

    public Map map;
    public Players players;


    // Det her er vores konstroktor

    public AdventureController() {
        map = new Map();
        players = new Players(map.getFirstRoom());
    }


    //////*********** Map ******************** ///////
    // At kalde den her funktion bygger vores kort.

    public void buildMap(){
        map.buildMap();
    }

    public String getCurrentRoom() { //Room name
        return players.currentRoom.getRoomName();
    }
    public String getCurrentRoomDescription() {
        return players.currentRoom.getRoomDescription();
    }


    ///////************** Players *********** ////////

    public void moveRoom(int input){
        players.moveRoom(input);
    }

    public int playerDirection(String input){
        return players.playerDirection(input);
    }




}
