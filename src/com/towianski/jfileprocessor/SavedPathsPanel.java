/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towianski.jfileprocessor;

import com.towianski.jfileprocess.actions.JavaProcess;
import com.towianski.utils.DesktopUtils;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author stan
 */
public class SavedPathsPanel extends javax.swing.JPanel {

        HashMap<String,String> savedPathsHm = new HashMap<String,String>();
        JFileFinderWin jFileFinderWin = null;

    /**
     * Creates new form SavedPathsPanel
     */
    public SavedPathsPanel( JFileFinderWin jFileFinderWin ) {
        initComponents();
        this.jFileFinderWin = jFileFinderWin;
    }

    public void setJFileFinderWin( JFileFinderWin jFileFinderWin ) {
        this.jFileFinderWin = jFileFinderWin;
    }

    public HashMap<String, String> getSavedPathsHm() {
        return savedPathsHm;
    }

    public void setSavedPathsHm(HashMap<String, String> savedPathsHm) {
        this.savedPathsHm = savedPathsHm;
    }

    public JList<String> getSavedPathsList() {
        return savedPathsList;
    }

    public void setSavedPathsList(JList<String> savedPathsList) {
        this.savedPathsList = savedPathsList;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        savedPathsList = new javax.swing.JList<>();

        setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jButton1, gridBagConstraints);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(jButton2, gridBagConstraints);

        savedPathsList.setModel(new DefaultListModel() );
        savedPathsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savedPathsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(savedPathsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultListModel listModel = (DefaultListModel) savedPathsList.getModel();
        System.err.println( "add path() startingFolder.getText() =" + jFileFinderWin.getStartingFolder() + "=" );
        String ans = JOptionPane.showInputDialog( "Name: ", Paths.get( jFileFinderWin.getStartingFolder() ).getFileName() );
        if ( ans == null )
            {
            return;
            }
        savedPathsHm.put( ans, jFileFinderWin.getStartingFolder() );
        listModel.addElement( ans );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultListModel listModel = (DefaultListModel) savedPathsList.getModel();
        int index = savedPathsList.getSelectedIndex();
        String strPath = listModel.getElementAt(index).toString();
        System.err.println( "delete path() index =" + index + "   element =" + strPath + "=" );
        if ( strPath.equals( "New Window" ) || strPath.equals( "Trash" ) )
            {
            return;
            }
        savedPathsHm.remove( listModel.getElementAt(index).toString() );
        listModel.remove( index );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void savedPathsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedPathsListMouseClicked
        DefaultListModel listModel = (DefaultListModel) savedPathsList.getModel();
        int index = savedPathsList.getSelectedIndex();
        String strPath = listModel.getElementAt(index).toString();
        if ( strPath.equals( "New Window" ) )
            {
            try {
                int rc = JavaProcess.execJava( com.towianski.jfileprocessor.JFileFinderWin.class );
                System.err.println( "javaprocess.exec start new window rc = " + rc + "=" );
            } catch (IOException ex) {
                Logger.getLogger(JFileFinderWin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JFileFinderWin.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
            }
        else if ( strPath.equals( "Trash" ) )
            {
            try {
                int rc = JavaProcess.execJava( com.towianski.jfileprocessor.JFileFinderWin.class, DesktopUtils.getTrashFolder().toString() );
                System.err.println( "javaprocess.exec start new window rc = " + rc + "=" );
            } catch (IOException ex) {
                Logger.getLogger(JFileFinderWin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JFileFinderWin.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
            }
        jFileFinderWin.setStartingFolder( savedPathsHm.get( strPath ) );
        jFileFinderWin.callSearchBtnActionPerformed( null );

    }//GEN-LAST:event_savedPathsListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> savedPathsList;
    // End of variables declaration//GEN-END:variables
}