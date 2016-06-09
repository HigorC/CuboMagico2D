package br.ufms.view;

import javafx.scene.layout.GridPane;

public class CuboLayout {

    private FaceCuboPane frente;
    private FaceCuboPane atras;
    private FaceCuboPane direita;
    private FaceCuboPane esquerda;
    private FaceCuboPane cima;
    private FaceCuboPane baixo;

    public FaceCuboPane getFrente() {
        return frente;
    }

    public FaceCuboPane getAtras() {
        return atras;
    }

    public FaceCuboPane getDireita() {
        return direita;
    }

    public FaceCuboPane getEsquerda() {
        return esquerda;
    }

    public FaceCuboPane getCima() {
        return cima;
    }

    public FaceCuboPane getBaixo() {
        return baixo;
    }

    public void setFrente(FaceCuboPane face) {
        GridPane.setConstraints(face, 1, 1);//central
        frente = face;
    }

    public void setAtras(FaceCuboPane face) {
        GridPane.setConstraints(face, 3, 1);//atras
        atras = face;
    }

    public void setDireita(FaceCuboPane face) {
        GridPane.setConstraints(face, 2, 1);//direita
        direita = face;
    }

    public void setEsquerda(FaceCuboPane face) {
        GridPane.setConstraints(face, 0, 1);//esquerda
        esquerda = face;
    }

    public void setCima(FaceCuboPane face) {
        GridPane.setConstraints(face, 1, 0);  //cima 
        cima = face;
    }

    public void setBaixo(FaceCuboPane face) {
        GridPane.setConstraints(face, 1, 2);//baixo
        baixo = face;
    }
}
