package org.example;
import java.util.ArrayList;
import java.util.List;

// Den class er beregnet til at oprette "Rooms"

import java.util.ArrayList;

public class Room {

    //*** ATTRIBUTES ***//
    // Et Room har følgende egenskaber (attributes) et navn (String), En beskrivelse og fire forbindelser (Room).
    // Angiv de nødvendige attributes

    private String roomName;  // roomNavn
    private String roomDescription;   // Skal indhold hvilke "Rooms" den er konktet til
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
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

    public ArrayList<Items> getitemsArrayList (){  // really nice Mette og Daniel
        return itemsArrayList;
    }
    public void displayItemsInRoom() { //Metode til at displaye items i room. Items bliver foreløbigt sat i buildMap().
        if(!itemsArrayList.isEmpty()) {
            System.out.println("You spot items that may be of use to you in this room: ");
            for(Items item : itemsArrayList) { //For each loop leder efter items
                System.out.println(item.getItem());
            }
        } else {
            System.out.println("You see nothing of use to you in this room.");
        }
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


    //////******* en adder metode til vores Arraylist *******/////////
    public void addItemsArrayList(Items Item){
        itemsArrayList.add(Item);
    }

    public void removeItemsArrayList(String itemToRemove){
       for(Items searchItems : itemsArrayList) {
           if(searchItems.getItem().contains(itemToRemove)) {   //// Vi skal have en bedre metode en getItem til at fjerne fra liste.
               itemsArrayList.remove(searchItems);
           }
       }

        // Jeg vil gerne have lavet en for løkke i stedet for en for each lykke.

        /* for (int i = 0; i < itemsArrayList.size(); i++ ) {
            if (Items )
        }*/


    }

    //////////////////////////////////////////////////////////////////

    public void setRoomDoorEast(Room roomDoorEast) {
        this.roomDoorEast = roomDoorEast;
    }

    public void setRoomDoorWest(Room roomDoorWest) {
        this.roomDoorWest = roomDoorWest;
    }


}
