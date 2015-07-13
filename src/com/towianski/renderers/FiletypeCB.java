/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towianski.renderers;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author Stan Towianski
 */
public class FiletypeCB extends JCheckBox {

    private ImageIcon fileicon;
    private ImageIcon foldericon;

    public FiletypeCB() {
        try {
            foldericon = new ImageIcon(ImageIO.read(getClass().getResource("/icons/yellow/Folder-Blank-icon-16.png")));
            fileicon = new ImageIcon(ImageIO.read(getClass().getResource("/icons/yellow/document-icon-16.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setIcon(foldericon);
        } else {
            setIcon(fileicon);
        }
    }
 
}