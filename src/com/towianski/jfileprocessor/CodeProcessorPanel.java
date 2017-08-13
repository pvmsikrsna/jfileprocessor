/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towianski.jfileprocessor;

import com.towianski.jfileprocessor.services.CallGroovy;
import groovy.lang.Binding;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author stan
 */
public class CodeProcessorPanel extends javax.swing.JFrame {

        LinkedHashMap<String,String> savedPathsHm = new LinkedHashMap<String,String>();
        JFileFinderWin jFileFinderWin = null;
        DefaultComboBoxModel listOfFilesPanelModel = null;
        String currentDirectory = "";
        String currentFile = "";

    /**
     * Creates new form SavedPathsPanel
     */
    public CodeProcessorPanel( JFileFinderWin jFileFinderWin, DefaultComboBoxModel listOfFilesPanelModel ) {
        this.jFileFinderWin = jFileFinderWin;
        this.listOfFilesPanelModel = listOfFilesPanelModel;
        initComponents();
        
        if ( jFileFinderWin.getStartingFolder().equals( "" ) )
            {
            currentDirectory = ".";
            }
        else
            {
            currentDirectory = jFileFinderWin.getStartingFolder();
            }
        this.setLocationRelativeTo( getRootPane() );
        this.validate();
    }

    public void setJFileFinderWin( JFileFinderWin jFileFinderWin ) {
        this.jFileFinderWin = jFileFinderWin;
    }

    public LinkedHashMap<String, String> getSavedPathsHm() {
        return savedPathsHm;
    }

    public void setSavedPathsHm(LinkedHashMap<String, String> savedPathsHm) {
        this.savedPathsHm = savedPathsHm;
    }

    public DefaultComboBoxModel getModel() {
        return (DefaultComboBoxModel) PathsList.getModel();
    }

    public void setSavedPathsList(JList<String> savedPathsList) {
        this.PathsList = savedPathsList;
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

        jPanel1 = new javax.swing.JPanel();
        cmdCb = new javax.swing.JComboBox<>();
        listOfLists = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PathsList = new javax.swing.JList<>();
        saveToFile = new javax.swing.JButton();
        readFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        codePane = new javax.swing.JEditorPane();

        setMinimumSize(new java.awt.Dimension(650, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        cmdCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Run on List" }));
        cmdCb.setMinimumSize(new java.awt.Dimension(150, 25));
        cmdCb.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(cmdCb, gridBagConstraints);

        listOfLists.setModel( listOfFilesPanelModel );
        listOfLists.setMinimumSize(new java.awt.Dimension(150, 25));
        listOfLists.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(listOfLists, gridBagConstraints);

        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        PathsList.setModel(new DefaultComboBoxModel() );
        PathsList.setPreferredSize(new java.awt.Dimension(150, 200));
        jScrollPane1.setViewportView(PathsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        saveToFile.setText("Save to File");
        saveToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        jPanel1.add(saveToFile, gridBagConstraints);

        readFile.setText("Read File");
        readFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(readFile, gridBagConstraints);

        jScrollPane2.setViewportView(codePane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println( "before call: new callGroovy();" );
        File currentDir = new File( currentDirectory );
//        this.pathRoots = new String[] { currentDir.getAbsolutePath() };
        CallGroovy callGroovy = new CallGroovy( new String[] { currentDir.getAbsolutePath() } );
        System.out.println( "before call: callGroovy.testGroovyScriptEngineVsGroovyShell();" );
        Binding binding = new Binding();
        System.out.println( "start codeProcessorPanel.jFileFinderWin.getStartingFolder() =" + this.jFileFinderWin.getStartingFolder() + "=" );

        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) jFileFinderWin.getListPanelModel( (String) listOfLists.getSelectedItem() );
        
        binding.setProperty( "codeProcessorPanel", this );
        binding.setProperty( "defaultComboBoxModel", defaultComboBoxModel );
        File tmpFile = new File( currentFile );
        callGroovy.testGroovyScriptEngineVsGroovyShell( tmpFile.getName(), binding );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileHidingEnabled( true );
        chooser.setDialogTitle( "File to Save To" );
        chooser.setCurrentDirectory( new File( currentDirectory ) );
        chooser.setSelectedFile( new File( currentFile ) );
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        //chooser.setAcceptAllFileFilterUsed(false);
    
    if ( chooser.showDialog( this, "Select" ) == JFileChooser.APPROVE_OPTION )
        {
        File selectedFile = chooser.getSelectedFile();
        System.out.println( "File to save to =" + selectedFile + "=" );
        currentDirectory = selectedFile.getParent();
        currentFile = selectedFile.getAbsolutePath();
        System.out.println( "File to save to =" + selectedFile + "=" );
        System.out.println( "File to save to =" + selectedFile + "=" );
        
        try
            {
            if( ! selectedFile.exists() )
                {
                selectedFile.createNewFile();
                }

            FileWriter fw = new FileWriter( selectedFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            codePane.write(bw);
//            int numItems = thisListModel.getSize();
//            System.out.println( "thisListModel.getSize() num of items =" + numItems + "=" );
//            
//            //loop for jtable rows
//            for( int i = 0; i < numItems; i++ )
//                {
//                bw.write( (String) thisListModel.getElementAt( i ) );
//                bw.write( "\n" );
//            }
            //close BufferedWriter
            bw.close();
            //close FileWriter 
            fw.close();
            JOptionPane.showMessageDialog(null, "Data Exported");        
            this.setTitle( "code - " + currentFile );
            }
        catch( Exception ex )
            {

            }
        }

    }//GEN-LAST:event_saveToFileActionPerformed

    private void readFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileHidingEnabled( true );
        chooser.setDialogTitle( "File to Save To" );
        chooser.setCurrentDirectory( new File( currentDirectory ) );
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        //chooser.setAcceptAllFileFilterUsed(false);
    
    if ( chooser.showDialog( this, "Select" ) == JFileChooser.APPROVE_OPTION )
        {
        File selectedFile = chooser.getSelectedFile();
        System.out.println( "File to read =" + selectedFile + "=" );
        currentDirectory = selectedFile.getParent();
        currentFile = selectedFile.getAbsolutePath();
        System.out.println( "File to read to =" + selectedFile + "=" );
        System.out.println( "File to read to =" + selectedFile + "=" );
        
        try
            {
            if( ! selectedFile.exists() )
                {
                selectedFile.createNewFile();
                }

            FileReader fr = new FileReader( selectedFile.getAbsoluteFile() );
            BufferedReader br = new BufferedReader(fr);

            codePane.read(br, evt);
//            int numItems = thisListModel.getSize();
//            System.out.println( "thisListModel.getSize() num of items =" + numItems + "=" );
//            
//            String line = "";
//            while ( ( line = br.readLine() ) != null )
//                {
//                System.out.println( "read line =" + line + "=" );
//                thisListModel.addElement( line );
//                }
            //close BufferedWriter
            br.close();
            //close FileWriter 
            fr.close();
            this.setTitle( "code - " + currentFile );
            }
        catch( Exception ex )
            {

            }
        }
    }//GEN-LAST:event_readFileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        jFileFinderWin.removeListPanel( this.getTitle() );
    }//GEN-LAST:event_formWindowClosing

        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                           String[] data = {"Fe", "Fi", "Fo", "Fum"};

           final DefaultComboBoxModel listOfFilesPanelModel = new DefaultComboBoxModel(data);
                CodeProcessorPanel dialog = new CodeProcessorPanel( null, listOfFilesPanelModel );
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });

                dialog.setSize( 800, 600 );
                dialog.setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> PathsList;
    private javax.swing.JComboBox<String> cmdCb;
    private javax.swing.JEditorPane codePane;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listOfLists;
    private javax.swing.JButton readFile;
    private javax.swing.JButton saveToFile;
    // End of variables declaration//GEN-END:variables
}