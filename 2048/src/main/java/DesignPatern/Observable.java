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
public interface Observable {

    /**
     * add observer to list observer
     *
     * @param observer observer to add
     */
    void addObserver(Observer observer);

    /**
     * notify the observer
     */
    void notifyObserver();
    /**
     * notify observer with param
     * @param arg the param
     */
    void notifyObserver(Object arg);

}
