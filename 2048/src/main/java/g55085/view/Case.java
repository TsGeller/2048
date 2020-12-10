/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55085.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Case extends Label {

    public Case(int valeur) {
        this.setText(Integer.toString(valeur));
        this.setAlignment(Pos.CENTER);
        this.setMinWidth(50);
        this.setMinHeight(50);
        this.setTextAlignment(TextAlignment.CENTER);

    }
}
