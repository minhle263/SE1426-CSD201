/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String url="https://vnexpress.net/";
        String file= "outputTag.csv";
        checkWeb check= new checkWeb(url,file);
    }
}
