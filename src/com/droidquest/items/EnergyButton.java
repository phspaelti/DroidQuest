package com.droidquest.items;

import java.awt.Color;

import com.droidquest.decorations.TextBox;

/**
 * Disables the player blocking material in the Energy room.
 * This button is usually invisible, but reappears for brief moments
 * at the location of the 'Not a Button'
 */
public class EnergyButton extends Button 
{
    transient NotAButton nb=null;
    int animationState=0;

    public EnergyButton() 
    {
        super(0,0,null,new Color(255,128,0));
        grabbable=false;
    }

    public void Animate() 
    {
        if (animationState==0)
            if (room != null)
                for (int a=0; a<level.items.size(); a++)
                {
                    Item item = (Item) level.items.elementAt(a);
                    if (Overlaps(item))
                    {
                        animationState=1;
                        nb.animationState=51;
                        for (int b=1; b<19; b++)
                            room.downRoom.SetMaterial(b,4,0);
                        TextBox line = (TextBox) room.downRoom.textBoxes.elementAt(1);
                        line.textString = " ";
                    }

                }
    }

}

