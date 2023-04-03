package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends  BaseDAO<Produit> {

    public ProduitDAO() throws SQLException {

        super();
    }

        // mapping objet --> relation
        @Override
        public void save(Produit object) throws SQLException {

            String req = "insert into produit (id_produit , categorie , prix) values (? , ? , ?) ;";


            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1 , object.getId_produit());
            this.preparedStatement.setString(2 , object.getCategorie());
            this.preparedStatement.setString(3 , object.getPrix());



            this.preparedStatement.execute();

        }

        @Override
        public void update(Produit object) throws SQLException {

            String req = "UPDATE produit SET categorie=?, prix=? WHERE id_produit=?";

            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1, object.getCategorie());
            this.preparedStatement.setString(2, object.getPrix());
            this.preparedStatement.setString(3, object.getId_produit());

            this.preparedStatement.executeUpdate();


        }

        @Override
        public void delete(Produit object) throws SQLException {

            String req = "delete from produit where id_produit = ? ;";

            this.preparedStatement = this.connection.prepareStatement(req);

            this.preparedStatement.setString(1, object.getId_produit());

            this.preparedStatement.execute();

        }

        @Override
        public Produit getOne(Long id) throws SQLException {
            return null;
        }


        // mapping relation --> objet
        @Override
        public List<Produit> getAll() throws SQLException{

            List<Produit> mylist = new ArrayList<Produit>();
            String req = " select * from produit" ;


            this.statement = this.connection.createStatement();

            this.resultSet =  this.statement.executeQuery(req);

            while (this.resultSet.next()){

                mylist.add( new Produit(this.resultSet.getString(1) , this.resultSet.getString(2),
                        this.resultSet.getString(3)));


            }

            return mylist;
        }
    }


