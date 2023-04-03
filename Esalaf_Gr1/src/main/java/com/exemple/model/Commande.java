package com.exemple.model;

public class Commande {

        public String id_client ;

        private String etat ;

        private String produit ;

        private String quantite ;

    public Commande() {
        }

        public Commande(String id_client, String produit, String quantite , String etat) {
            this.id_client = id_client;
            this.produit = produit;
            this.quantite = quantite;
            this.etat = etat;

        }

        public String getId_client() {
            return id_client;
        }

        public void setId_client(String id_client) {
            this.id_client = id_client;
        }

        public String getProduit() {
            return produit;
        }

        public void setProduit(String produit) {
            this.produit = produit;
        }

        public String getEtat() {
            return etat;
        }

        public void setEtat(String etat) {
            this.etat = etat;
        }

         public String getQuantite() {
        return quantite;
    }

         public void setQuantite(String quantite) { this.quantite = quantite; }

        @Override
        public String toString() {
            return "Commande{" +
                    "id_client=" + id_client +
                    ", produit='" + produit + '\'' +
                    ", etat='" + etat + '\'' +
                    ", quantite='" + quantite + '\'' +
                    '}';
        }
    }