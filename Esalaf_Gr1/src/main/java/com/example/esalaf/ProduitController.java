package com.example.esalaf;

import com.exemple.model.Produit;
import com.exemple.model.ProduitDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


        @FXML
        private TextField id_pro;

        @FXML
        private TextField cat;

        @FXML
        private TextField pri;


        @FXML
        private TableView<Produit> mytab;

        @FXML
        private TableColumn<Produit, String> colpro;

        @FXML
        private TableColumn<Produit, String> colcat;

        @FXML
        private TableColumn<Produit, String> colpri;


        @FXML
        protected void onSaveButtonClick(){

            Produit prod = new Produit(id_pro.getText() , cat.getText() , pri.getText());

            try {
                ProduitDAO proddao = new ProduitDAO();

                proddao.save(prod);



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();

        }
        @FXML
        protected void onDeleteButtonClick(){
            // Récupération de l'ID du client à supprimer
            Produit prod = new Produit(id_pro.getText() , cat.getText() , pri.getText());

            try {
                ProduitDAO proddao = new ProduitDAO();

                proddao.delete(prod);



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();

        }
        @FXML
        protected void onUpdateButtonClick(){
            // Récupération des nouvelles informations du client à mettre à jour
            Produit prod = new Produit(id_pro.getText() , cat.getText() , pri.getText());

            try {
                ProduitDAO proddao = new ProduitDAO();

                proddao.update(prod);



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();

        }


        public void UpdateTable(){
            colpro.setCellValueFactory(new PropertyValueFactory<Produit,String>("id_produit"));
            colcat.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));

            colpri.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));


            mytab.setItems(getDataProduit());
        }

        public static ObservableList<Produit> getDataProduit(){

            ProduitDAO proddao = null;

            ObservableList<Produit> listfx = FXCollections.observableArrayList();

            try {
                proddao = new ProduitDAO();
                for(Produit ettemp : proddao.getAll())
                    listfx.add(ettemp);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return listfx ;
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            UpdateTable();
        }
    }


