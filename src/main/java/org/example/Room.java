package org.example;
import java.util.*;

// Den class er beregnet til at oprette "Rooms"

import java.util.ArrayList;

public class Room {

    //*** ATTRIBUTES ***//
    // Et Room har følgende egenskaber (attributes) et navn (String), En beskrivelse og fire forbindelser (Room).
    // Angiv de nødvendige attributes

    private String roomName;  // roomNavn
    private String roomDescription;   // Skal indhold hvilke "Rooms" den er konktet til
    private ArrayList<Item> itemsArrayList = new ArrayList<>();

    private ArrayList<Enemy> enemyArrayList = new ArrayList<>();
    private Room roomDoorNorth;
    private Room roomDoorSouth;
    private Room roomDoorEast;
    private Room roomDoorWest;


    //*** CONSTRUCTOR ***//
    // når et Room objekt skabes, så gives det et navn (som argument), og en beskrivelse - det er det eneste.


    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomDoorNorth = null;
        this.roomDoorSouth = null;
        this.roomDoorEast = null;
        this.roomDoorWest = null;
    }

    // getter Methods

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Item> getitemsArrayList (){  // really nice Mette og Daniel
        return itemsArrayList;
    }

    public String getRoomsArrayListWithDescription (){
        String roomsArrayList = " ";
        for (int i = 0; i < itemsArrayList.size();i++){
            roomsArrayList = itemsArrayList.get(i).toString();
        } return roomsArrayList;
    }

    // this getter methods is used to check if it is okay go into the room. The value will either be a room or null

    public Room getRoomDoorNorth() {
        return roomDoorNorth;
    }

    public Room getRoomDoorSouth() {
        return roomDoorSouth;
    }

    public Room getRoomDoorEast() {
        return roomDoorEast;
    }

    public Room getRoomDoorWest() {
        return roomDoorWest;
    }


    // Setter Methods

    public void setRoomDoorNorth(Room roomDoorNorth) {
        this.roomDoorNorth = roomDoorNorth;
    }

    public void setRoomDoorSouth(Room roomDoorSouth) {
        this.roomDoorSouth = roomDoorSouth;
    }

    public void setRoomDoorEast(Room roomDoorEast) {
        this.roomDoorEast = roomDoorEast;
    }

    public void setRoomDoorWest(Room roomDoorWest) {
        this.roomDoorWest = roomDoorWest;
    }


    //////******* en adder og remove metode til vores Arraylist *******/////////

    // vi kan gøre det her trick fordi Room. er connected to Item.
    public void addItemsArrayList(Item Item){
        itemsArrayList.add(Item);
    }

    public void removeItemsArrayList(Item Item) {
        itemsArrayList.remove(Item);
    }

    public void addEnemyArrayList(Enemy enemy){
        enemyArrayList.add(enemy);
    }

    public void removeEnemyArrayList(Enemy enemy) {
        enemyArrayList.remove(enemy);
    }
    public ArrayList<Enemy> getEnemyArrayList() {
        return enemyArrayList;
    }

    ////////************* sorting our array list in Room ****************/////////

    public void sortArrayListEnemy () {
        enemyArrayList.sort(new Comparator<Enemy>() {
            @Override
            public int compare(Enemy o1, Enemy o2) {
                return o1.getHealthscore().compareTo(o2.getHealthscore());
            }
        });
    }
    //------Other sorting methods I dont use ------ //
    public void sortArrayListItem () {
        itemsArrayList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getItem().compareTo(o2.getItem());
            }
        });
    }

    public void altenativesortArrayListItem1 () {
        Collections.sort(itemsArrayList, (p1, p2) -> p1.getItem().compareTo(p2.getItem()));
    }

    public void altenativesortArrayListItem2 () {
       Item temp = null;
        for (int i = 0; i < itemsArrayList.size(); i++){
           for (int j=i+1; j < itemsArrayList.size(); j++){
               if(itemsArrayList.get(i).getItem().compareTo(itemsArrayList.get(j).getItem())>0){

                   temp = itemsArrayList.get(i);
                   itemsArrayList.set(i, itemsArrayList.get(j));
                   itemsArrayList.set(j,temp);
               }
           }
       }
    }
    //---------------------------------end of other sort methods I dont use -----------------------------//
}
