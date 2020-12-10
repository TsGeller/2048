/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55085.view;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class ListViewBis extends ListView {

    public ListViewBis() {
        this.setPrefWidth(250);
        this.setPrefHeight(50);        
        this.setFocusTraversable(false);

    }

    public void addStatus(String string) {
        this.getItems().add(string);
    }
    
}
