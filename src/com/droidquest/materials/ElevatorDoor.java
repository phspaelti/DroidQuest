package com.droidquest.materials;

import java.awt.Color;

import com.droidquest.avatars.GameCursor;
import com.droidquest.decorations.Graphix;
import com.droidquest.decorations.TextBox;
import com.droidquest.items.GenericRobot;
import com.droidquest.items.Item;
import com.droidquest.items.Magnet;

public class ElevatorDoor extends Material 
{
    // This material will open or close the elevator doors based on where
    // the player is. It is sensitive to the player being inside a robot.
    transient boolean checkedForMagnet = false;
    transient Item magnet = null;

    public ElevatorDoor() 
    {
        super(Color.black, true, false);
    }

    public void TouchedByItem(Item item) 
    {
        // Items which are being carried can be skipped
        if (item.carriedBy!=null) return;
        
        // Check if there is a magnet somewhere on the level
        if (!checkedForMagnet)
        {
            for (int a=0; a<level.items.size(); a++)
            {
                Item i = (Item) level.items.elementAt(a);
                if (i instanceof Magnet)
                {
                    magnet = i;
                    checkedForMagnet=true;
                }
            }
        }
        
        // Actual test starts here
        boolean test = false;
        
        // The toucher should be either the game cursor
        // or a robot with the game cursor inside
        if (item == level.player) 
            test = true;
        else if (item instanceof GenericRobot)
        {
            GameCursor gc = (GameCursor) level.gameCursor;
            if (gc.PlayerInRobot(null) == item)
                test=true;;
        }
        
        // Adjust the position of the graphic in the corner
        Graphix gr = (Graphix) item.room.graphix.elementAt(1);
        gr.x = 18*28;
        
        // Check if there is a magnet in the room
        // Move the graphic slightly if magnet is found
        if (magnet!=null)
            if (magnet.room == item.room)
            {
                test=false;
                gr.x = 18*28-10;
            }
        
        // Close the elevator door depending on the position of the
        // game cursor. (Disabled if there is a magnet in the room.)
        if (test)
        {
            int X = item.x/28;
            switch(X)
            {
            case 3: 
                item.room.SetMaterial(11,1,0);
                item.room.SetMaterial(11,2,0);
                item.room.SetMaterial(11,3,0);
                item.room.SetMaterial(11,4,0);
                item.room.SetMaterial(11,5,0);
                item.room.SetMaterial(11,6,0);
                item.room.SetMaterial(11,7,0);
                item.room.SetMaterial(11,8,0);
                item.room.SetMaterial(11,9,0);
                item.room.SetMaterial(11,10,0);
                break;
            case 4: 
                item.room.SetMaterial(11,1,2);
                item.room.SetMaterial(11,2,0);
                item.room.SetMaterial(11,3,0);
                item.room.SetMaterial(11,4,0);
                item.room.SetMaterial(11,5,0);
                item.room.SetMaterial(11,6,0);
                item.room.SetMaterial(11,7,0);
                item.room.SetMaterial(11,8,0);
                item.room.SetMaterial(11,9,0);
                item.room.SetMaterial(11,10,2);
                break;
            case 5: 
                item.room.SetMaterial(11,1,2);
                item.room.SetMaterial(11,2,2);
                item.room.SetMaterial(11,3,0);
                item.room.SetMaterial(11,4,0);
                item.room.SetMaterial(11,5,0);
                item.room.SetMaterial(11,6,0);
                item.room.SetMaterial(11,7,0);
                item.room.SetMaterial(11,8,0);
                item.room.SetMaterial(11,9,2);
                item.room.SetMaterial(11,10,2);
                break;
            case 6: 
                item.room.SetMaterial(11,1,2);
                item.room.SetMaterial(11,2,2);
                item.room.SetMaterial(11,3,2);
                item.room.SetMaterial(11,4,0);
                item.room.SetMaterial(11,5,0);
                item.room.SetMaterial(11,6,0);
                item.room.SetMaterial(11,7,0);
                item.room.SetMaterial(11,8,2);
                item.room.SetMaterial(11,9,2);
                item.room.SetMaterial(11,10,2);
                break;
            case 7: 
                item.room.SetMaterial(11,1,2);
                item.room.SetMaterial(11,2,2);
                item.room.SetMaterial(11,3,2);
                item.room.SetMaterial(11,4,2);
                item.room.SetMaterial(11,5,0);
                item.room.SetMaterial(11,6,0);
                item.room.SetMaterial(11,7,2);
                item.room.SetMaterial(11,8,2);
                item.room.SetMaterial(11,9,2);
                item.room.SetMaterial(11,10,2);
                ((TextBox) item.room.textBoxes.elementAt(1)).textString = "\"Hold please!\"";
                break;
            case 8: 
                item.room.SetMaterial(11,1,2);
                item.room.SetMaterial(11,2,2);
                item.room.SetMaterial(11,3,2);
                item.room.SetMaterial(11,4,2);
                item.room.SetMaterial(11,5,2);
                item.room.SetMaterial(11,6,2);
                item.room.SetMaterial(11,7,2);
                item.room.SetMaterial(11,8,2);
                item.room.SetMaterial(11,9,2);
                item.room.SetMaterial(11,10,2);
                ((TextBox) item.room.textBoxes.elementAt(1)).textString = "\"Going up!\"";
                break;
            }
        }
    }

}
