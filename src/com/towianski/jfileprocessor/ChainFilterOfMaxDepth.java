/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towianski.jfileprocessor;

import com.towianski.utils.FilterChainFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Stan Towianski - June 2015
 */
public class ChainFilterOfMaxDepth extends FilterChainFilter {

    int maxDepth;
    
    public ChainFilterOfMaxDepth()
        {
        //System.out.println( "new ChainFilterOfMaxDepth()" );
        }
    
    public ChainFilterOfMaxDepth( String startingFolder, String maxDepth ) 
        {
        this.maxDepth = Paths.get( startingFolder ).getNameCount() + Integer.parseInt( maxDepth ) - 1;
        System.out.println( "Paths.get( startingFolder ).getNameCount() =" + Paths.get( startingFolder ).getNameCount() + "   Integer.parseInt( maxDepth ) =" + Integer.parseInt( maxDepth ) );
        }
    
    // These must be the same parms for all filters that get used.
    public Boolean accept( Path fpath, BasicFileAttributes attr )
        {
        //System.out.println( "maxdepth for path =" + fpath + "   depthcount =" + fpath.getNameCount() + "   max =" + maxDepth + "true/false =" + (fpath.getNameCount() == maxDepth) );
        return fpath.getNameCount() <= maxDepth ? true : false;
        }
}
