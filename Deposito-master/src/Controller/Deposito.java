/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao;
import View.TelaInicial;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author antun
 */
public class Deposito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testando conexão");
        Dao d = new Dao();
        d.connectToDb();
        
        TelaInicial t = new TelaInicial();
        t.setVisible(true);
    }

}
