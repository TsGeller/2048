/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatern;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public interface Observer {
    
    /**
     *
     * @param observer
     * @param arg
     */
    void update(Observable observer,Object arg);
}
