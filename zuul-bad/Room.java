import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room upExit;
    private Room downExit;
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null) {
            northExit = north;
            exits.put("north", north);
        }
        if(east != null) {
            eastExit = east;
            exits.put("east", east);
        }
        if(south != null) {
            southExit = south;
            exits.put("south", south);
        }
        if(west != null) {
            westExit = west;
            exits.put("west", west);
        }
        if(up != null) {
            upExit = up;
            exits.put("up", up);
        }
        if(down != null) {
            downExit = down;
            exits.put("down", down);
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String exit)
    {
        return exits.get(exit);
    }
    
    public String getExits()
    {
        String exitString = "";
        Set<String> keys = exits.keySet();
        
        for (String exit : keys)
        {
            exitString += exit + " ";
        }
                
        return exitString;
    }
}
