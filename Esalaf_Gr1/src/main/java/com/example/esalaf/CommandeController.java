package com.example.esalaf;

import com.exemple.model.CommandeDAO;
import com.exemple.model.Commande;
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

    public class CommandeController implements Initializable {
        private Stage stage;
        private Scene scene;
        @FXML
        private TextField id_client;

        @FXML
        private TextField produit;

        @FXML
        private TextField quantite;

        @FXML
        private TextField etat;


        @FXML
        private TableView<Commande> mytabl;

        @FXML
        private TableColumn<Commande, String> col_id;

        @FXML
        private TableColumn<Commande, String> col_produit;

        @FXML
        private TableColumn<Commande, String> col_quantite;

        @FXML
        private TableColumn<Commande, String> col_etat;


        @FXML
        protected void onSaveButtonClick(){


            Commande cmd = new Commande(id_client.getText() , produit.getText() , quantite.getText() , etat.getText());

            try {
                CommandeDAO cmddao = new CommandeDAO();

                cmddao.save(cmd);



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();

        }
        @FXML
        protected void onDeleteButtonClick(){
            // Récupération de l'ID du client à supprimer
            Commande cmd = new Commande(id_client.getText() , produit.getText() , quantite.getText() , etat.getText());

            try {
                CommandeDAO cmddao = new CommandeDAO();

                cmddao.delete(cmd);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();
        }
        @FXML
        protected void onUpdateButtonClick(){
            // Récupération des nouvelles informations du commande à mettre à jour
            Commande cmd = new Commande(id_client.getText() , produit.getText() , quantite.getText() , etat.getText());

            try {
                CommandeDAO cmddao = new CommandeDAO();
                // Mise à jour du commande dans la base de données
                cmddao.update(cmd);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();
        }

        @FXML
        public void switchToMenu(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        public void UpdateTable(){
            col_id.setCellValueFactory(new PropertyValueFactory<Commande,String>("id_client"));
            col_produit.setCellValueFactory(new PropertyValueFactory<Commande,String>("produit"));
            col_quantite.setCellValueFactory(new PropertyValueFactory<Commande,String>("quantite"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Commande,String>("etat"));


            mytabl.setItems(getDataCommandes());
        }

        @FXML
        public static ObservableList<Commande> getDataCommandes(){

            CommandeDAO cmddao = null;

            ObservableList<Commande> listfx = FXCollections.observableArrayList();

            try {
                cmddao = new CommandeDAO();
                for(Commande ettemp : cmddao.getAll())
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
