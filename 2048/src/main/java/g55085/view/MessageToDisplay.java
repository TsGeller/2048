/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55085.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class MessageToDisplay {
    
    public static String gameOver(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime()) + "-Partie Terminée!\n"+format.format(calendar.getTime()) + "-Perdu !";
    }
    public static String winGame(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime()) + "-Gagné !";
         
    }
    public static String movementImpossible(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime()) + "-Mouvement impossible !";
         
    }
    public static String restartGame(){
        DateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime()) + "-Partie recommencée!";
         
    }
}
