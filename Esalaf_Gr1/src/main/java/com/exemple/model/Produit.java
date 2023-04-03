package com.exemple.model;

public class Produit {

        public String id_produit ;

        private String categorie ;

        private String prix ;

        public Produit() {
        }

        public Produit(String id_produit, String categorie, String prix) {
            this.id_produit = id_produit;
            this.categorie = categorie;
            this.prix = prix;
        }

        public String getId_produit() {
            return id_produit;
        }

        public void setId_produit(String id_client) {
            this.id_produit = id_produit;
        }

        public String getCategorie() {
            return categorie;
        }

        public void setCategorie(String categorie) {
            this.categorie = categorie;
        }

        public String getPrix() {
            return prix;
        }

        public void setPrix(String prix) {
            this.prix = prix;
        }

        @Override
        public String toString() {
            return "Produit{" +
                    "id_produit=" + id_produit +
                    ", categorie='" + categorie + '\'' +
                    ", prix='" + prix + '\'' +
                    '}';
        }
    }


