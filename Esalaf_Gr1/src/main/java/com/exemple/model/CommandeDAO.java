package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends  BaseDAO<Commande> {

        public CommandeDAO() throws SQLException {

            super();
        }

        // mapping objet --> relation
        @Override
        public void save(Commande object) throws SQLException {

            String req = "insert into commande (id_client , produit , quantite , etat ) values (? , ? , ? , ?) ;";


            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1 , object.getId_client());
            this.preparedStatement.setString(2 , object.getProduit());
            this.preparedStatement.setString(3 , object.getQuantite());
            this.preparedStatement.setString(4 , object.getEtat());


            this.preparedStatement.execute();

        }

        @Override
        public void update(Commande object) throws SQLException {

            String req = "UPDATE commande SET produit=?, quantite=?, etat=? WHERE id_client=?";

            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1, object.getProduit());
            this.preparedStatement.setString(2, object.getQuantite());
            this.preparedStatement.setString(3, object.getEtat());
            this.preparedStatement.setString(4, object.getId_client());

            this.preparedStatement.executeUpdate();

        }

        @Override
        public void delete(Commande object) throws SQLException {

            String req = "delete from commande where id_client = ? ;";

            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1, object.getId_client());

            this.preparedStatement.execute();

        }

        @Override
        public Commande getOne(Long id) throws SQLException {
            return null;
        }


        // mapping relation --> objet
        @Override
       public List<Commande> getAll() throws SQLException{

            List<Commande> mylist = new ArrayList<Commande>();
            String req = " select * from commande" ;


            this.statement = this.connection.createStatement();

            this.resultSet =  this.statement.executeQuery(req);

            while (this.resultSet.next()){

                mylist.add( new Commande(this.resultSet.getString(1) , this.resultSet.getString(2),
                        this.resultSet.getString(3) , this.resultSet.getString(4)));


            }

            return mylist;
        }
}
