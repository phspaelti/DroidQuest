package com.droidquest.operation.swing.mode;

import javax.swing.*;
import java.awt.FileDialog;

import com.droidquest.devices.SmallChip;
import com.droidquest.items.Item;
import com.droidquest.operation.Operation;
import com.droidquest.view.View;

/**
 * Swing-specific Operation that loads a SmallChip
 */
public class SwingLoadSmallChipOperation implements Operation {
    private final Item avatar;
    private final View view;

    public SwingLoadSmallChipOperation(Item avatar, View view) {
        this.avatar = avatar;
        this.view = view;
    }

    @Override
    public boolean canExecute() {
        return avatar.getCarrying() instanceof SmallChip;
    }

    @Override
    public void execute() {
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(getViewComponent());
        FileDialog fd = new FileDialog(parent,"Load Chip", FileDialog.LOAD);
        fd.setDirectory("chips");
        fd.setVisible(true);
        System.out.println("Dialog returned with "
                + fd.getDirectory()
                + fd.getFile());
        if (fd.getFile() != null)
        {
            ((SmallChip) avatar.getCarrying()).Empty();
            ((SmallChip) avatar.getCarrying()).LoadChip(fd.getDirectory()+fd.getFile());
        }
    }

    private JComponent getViewComponent() {
        return (JComponent) view;
    }
}
