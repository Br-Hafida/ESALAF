package com.exemple.model;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {

// Classe Client___________________

        try {
                // entity
                Client cli  = new Client("1","nahid","9009990099");

                //Transacatio
                ClientDAO clidao = new ClientDAO();

                // save trasanction
                clidao.save(cli);
                // delete transaction
                clidao.delete(cli);
                // update transaction
                clidao.update(cli);

             List<Client> mylist =  clidao.getAll();

            for (Client temp :mylist) {

                System.out.println(temp.toString());

            }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

// Classe Commande______________________________________

        try {
            // entity
            Commande cmd  = new Commande("1", "Sidi Ali", "10" , "Non payer");

            //Transacatio
            CommandeDAO cmddao = new CommandeDAO();

            // save trasanction
            cmddao.save(cmd);
            // delete transaction
            cmddao.delete(cmd);
            // update transaction
            cmddao.update(cmd);

            List<Commande> mylist =  cmddao.getAll();

            for (Commande temp :mylist) {

                System.out.println(temp.toString());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

        try {
            // entity
            Produit prod  = new Produit("112","Boissans","120");

            //Transacatio
            ProduitDAO proddao = new ProduitDAO();

            // save trasanction
            proddao.save(prod);
            // delete transaction
            proddao.delete(prod);
            // update transaction
            proddao.update(prod);

            List<Produit> mylist =  proddao.getAll();

            for (Produit temp :mylist) {

                System.out.println(temp.toString());

            }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
