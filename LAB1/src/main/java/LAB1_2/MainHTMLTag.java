/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

import java.util.HashMap;

/**
 *
 * @author TAN
 */
//CLI LAB1_2
public class MainHTMLTag {
    Manager manager = new Manager();
    public void parsingArguments(String[] args){
        if(args.length==2){
            manager.Manager(args[0],args[1]);
            System.out.println("Xong ~!");
        }
        else{
            System.out.println("Error");
        }
    }
}
