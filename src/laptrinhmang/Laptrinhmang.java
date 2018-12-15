/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

/**
 *
 * @author Nho Xuan
 */
public class Laptrinhmang {

    /**
     * @param args the command line arguments
     */
    public static  AdminForm frmAdmin=new AdminForm();
     public static database.clsConnectDB connection = new  database.clsConnectDB ();
    public static void main(String[] args) {
        // TODO code application logic here
          LoginForm frmDN= new  LoginForm();
            frmDN.show();
    }
    
}
