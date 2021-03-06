/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towianski.jfileprocessor;

import com.towianski.jfileprocess.actions.WatchDir;
import com.towianski.jfileprocess.actions.WatchDirPost;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stan
 */
public class WatchDirSw {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    JFileFinderWin jFileFinderWin = null;
    Thread watchThread = null;
    Thread watchDirPostThread = null;
    WatchDir watchDir = null;
    static long count = 0;
    Object LockObj = "";
    
    public WatchDirSw( JFileFinderWin jFileFinderWin )
        {
        this.jFileFinderWin = jFileFinderWin;
        }

    public synchronized void cancelWatch() 
        {
        System.out.println( "enter watchDirSw.cancelWatch()" );
        if ( watchDir != null )
            {
            watchDir.cancelWatch();
            }
        if ( watchDirPostThread != null )
            {
            System.out.println( "watchDirSw.cancelWatch() - before watchDirPostThread.join()" );
            if ( watchDirPostThread.isAlive() )
                {
                try
                    {
                    watchDirPostThread.join();
                    } catch (InterruptedException ex)
                    {
                    Logger.getLogger(WatchDirSw.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            System.out.println( "watchDirSw.cancelWatch() - after watchDirPostThread.join()" );
            }
        System.out.println( "exit watchDirSw.cancelWatch()" );
        }

    public void actionPerformed(java.awt.event.ActionEvent evt) {                                         
        if ( jFileFinderWin.searchBtn.getText().equalsIgnoreCase( jFileFinderWin.PROCESS_STATUS_SEARCH_CANCELED ) )
            {
            this.cancelWatch();
            }
        else
            {
            try {
                System.out.println( "WatchDirSw doCmdBtnActionPerformed start" );
                System.out.println( "on EDT? = " + javax.swing.SwingUtilities.isEventDispatchThread() );
//                watchDirSwingWorker = new WatchDirSwingWorker( jFileFinderWin, this, startingPath );
//                watchDir = watchDirSwingWorker.getWatchDir();
//                watchDirSwingWorker.execute();   //doInBackground();

                WatchDirPost watchDirPost = new WatchDirPost( jFileFinderWin, LockObj );
                watchDirPostThread = newThread( watchDirPost );
                watchDirPostThread.setName( "watchdirPostThread=" + count );
                watchDirPostThread.start();

                watchDir = new WatchDir( jFileFinderWin, LockObj, watchDirPostThread, watchDirPost, Paths.get( jFileFinderWin.getStartingFolder() ), this, false );
                watchThread = newThread( watchDir );
                watchThread.setName( "watchDir=" + count++ );
                watchThread.start();
                System.out.println( "WatchDirSw after start watch thread, now exit actionPerformed" );
                } 
            catch (Exception ex) {
                Logger.getLogger(WatchDir.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }                                        

    public Thread newThread(final Runnable r) 
        {
        Thread thread = new Thread( r );
        thread.setName( "watchDir" + thread.getName());
        thread.setDaemon(true);
        return thread;
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WatchDirSwFrame().setVisible(true);
//            }
//        });
    }
}
