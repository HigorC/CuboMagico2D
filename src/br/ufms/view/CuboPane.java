package br.ufms.view;

import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CuboPane extends GridPane {

    private final FaceCuboPane[] faces;
    public final CuboLayout layout;
    private Color aux, aux2, aux3, aux4;
    private FaceCuboPane faceAmostra;
    FaceCuboPane cuboPaneOrigem;

    public CuboPane() {
        this.faces = new FaceCuboPane[6];
        faces[0] = new FaceCuboPane(Color.WHITE);
        faces[1] = new FaceCuboPane(Color.YELLOW);
        faces[2] = new FaceCuboPane(Color.BLUE);
        faces[3] = new FaceCuboPane(Color.GREEN);
        faces[4] = new FaceCuboPane(Color.ORANGE);
        faces[5] = new FaceCuboPane(Color.RED);
        this.layout = new CuboLayout();
        inicializar();
    }

    private void inicializar() {

        for (int i = 0; i < 6; i++) {
            getChildren().add(faces[i]);
        }

        brancoEvidencia();

    }

    public FaceCuboPane atualizarAmostra() {

        return layout.getFrente();
    }

    public void embaralhar() {
        System.out.println("embaralhar funfando");
        Random gerador = new Random();
        for (int i = 0; i < 100; i++) {
            int numero = gerador.nextInt(5);

            if (numero == 0) {
                brancoEvidencia();
            } else if (numero == 1) {
                amareloEvidencia();
            } else if (numero == 2) {
                azulEvidencia();
            } else if (numero == 3) {
                verdeEvidencia();
            } else if (numero == 4) {
                laranjaEvidencia();
            } else if (numero == 5) {
                vermelhoEvidencia();
            }

            numero = gerador.nextInt(14);
            if (numero == 0) {
                btnEsquerdaDireita(0, 0);
            } else if (numero == 1) {
                btnEsquerdaDireita(0, 1);
            } else if (numero == 2) {
                btnEsquerdaDireita(0, 2);
            } else if (numero == 3) {
                btnEsquerdaDireita(2, 0);
            } else if (numero == 4) {
                btnEsquerdaDireita(2, 1);
            } else if (numero == 5) {
                btnEsquerdaDireita(2, 2);
                //-----------------
            } else if (numero == 6) {
                btnCimaBaixo(0, 0);
            } else if (numero == 7) {
                btnCimaBaixo(0, 1);
            } else if (numero == 8) {
                btnCimaBaixo(0, 2);
            } else if (numero == 9) {
                btnCimaBaixo(2, 0);
            } else if (numero == 10) {
                btnCimaBaixo(2, 1);
            } else if (numero == 11) {
                btnCimaBaixo(2, 2);
                //----------
            } else if (numero == 12) {
                rotacionar(0);
            } else if (numero == 13) {
                rotacionar(1);
            }
        }

    }

    public void arrumarEvidencia(int antigo, int novo) {
        if (antigo == 0) {//branco
            if (novo == 1) {//amarelo
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
                girarFaceHorario(layout.getBaixo());
            } else if (novo == 2) {//azul
                girarFaceHorario(layout.getCima());
                girarFaceAntiHorario(layout.getBaixo());
            } else if (novo == 3) {//verde
                girarFaceAntiHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
            }
        } else if (antigo == 1) {//amarelo
            if (novo == 0) {//branco
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
                girarFaceHorario(layout.getBaixo());
            } else if (novo == 2) {//azul
                girarFaceAntiHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
            } else if (novo == 3) {//verde
                girarFaceHorario(layout.getCima());
                girarFaceAntiHorario(layout.getBaixo());
            }
        } else if (antigo == 2) {//azul
            if (novo == 0) {//branco
                girarFaceAntiHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
            } else if (novo == 1) {//amarelo
                girarFaceHorario(layout.getCima());
                girarFaceAntiHorario(layout.getBaixo());
            } else if (novo == 3) {//verde
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
                girarFaceHorario(layout.getBaixo());
            }
        } else if (antigo == 3) {//verde
            if (novo == 0) {//branco
                girarFaceHorario(layout.getCima());
                girarFaceAntiHorario(layout.getBaixo());
            } else if (novo == 1) {//branco
                girarFaceAntiHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
            } else if (novo == 2) {//azul
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
                girarFaceHorario(layout.getBaixo());
            }
        }

    }

    public void azulEvidencia() {

        layout.setFrente(faces[2]);
        layout.setAtras(faces[3]);
        layout.setDireita(faces[1]);
        layout.setEsquerda(faces[0]);
        layout.setCima(faces[4]);
        layout.setBaixo(faces[5]);
    }

    public void vermelhoEvidencia() {

        layout.setFrente(faces[5]);
        layout.setAtras(faces[4]);
        layout.setDireita(faces[2]);
        layout.setEsquerda(faces[3]);
        layout.setCima(faces[0]);
        layout.setBaixo(faces[1]);
    }

    public void amareloEvidencia() {

        layout.setFrente(faces[1]);
        layout.setAtras(faces[0]);
        layout.setDireita(faces[3]);
        layout.setEsquerda(faces[2]);
        layout.setCima(faces[4]);
        layout.setBaixo(faces[5]);

//        girarFaceHorario(faces[4]);
//        girarFaceHorario(faces[4]);
//
//        girarFaceHorario(faces[5]);
//        girarFaceHorario(faces[5]);
//        girarFaceHorario(faces[1]);
//        girarFaceHorario(faces[1]);
    }

    public void verdeEvidencia() {

        layout.setFrente(faces[3]);
        layout.setAtras(faces[2]);
        layout.setDireita(faces[0]);
        layout.setEsquerda(faces[1]);
        layout.setCima(faces[4]);
        layout.setBaixo(faces[5]);
    }

    public void brancoEvidencia() {

        layout.setFrente(faces[0]);
        layout.setAtras(faces[1]);
        layout.setDireita(faces[2]);
        layout.setEsquerda(faces[3]);
        layout.setCima(faces[4]);
        layout.setBaixo(faces[5]);

//        girarFaceHorario(faces[4]);
//        girarFaceHorario(faces[4]);
//
//        girarFaceHorario(faces[5]);
//        girarFaceHorario(faces[5]);
//        girarFaceHorario(faces[0]);
//        girarFaceHorario(faces[0]);
    }

    public void laranjaEvidencia() {

        layout.setFrente(faces[4]);
        layout.setAtras(faces[5]);
        layout.setDireita(faces[2]);
        layout.setEsquerda(faces[3]);
        layout.setCima(faces[1]);
        layout.setBaixo(faces[0]);
    }

    public void rotacionarAnti() {
        girarFaceAntiHorario(layout.getFrente());
    }

    public void rotacionarHora() {
        girarFaceHorario(layout.getFrente());
    }

    public void btnEsquerdaDireita(int lado, int botao) {
        if (botao == 0) {
            if (lado == 0) {
                girarLinhaEsquerda(0);
                girarFaceHorario(layout.getCima());
            } else if (lado == 1) {

                girarLinhaDireita(0);
                girarLinhaDireita(2);
                girarFaceAntiHorario(layout.getCima());
                girarFaceHorario(layout.getBaixo());
            } else if (lado == 2) {
                girarLinhaEsquerda(2);
                girarFaceAntiHorario(layout.getBaixo());
            }
        } else {
            if (lado == 0) {
                girarLinhaDireita(0);
                girarFaceAntiHorario(layout.getCima());
            } else if (lado == 1) {
                girarLinhaEsquerda(0);
                girarLinhaEsquerda(2);
                girarFaceHorario(layout.getCima());
                girarFaceAntiHorario(layout.getBaixo());
            } else if (lado == 2) {
                girarLinhaDireita(2);
                girarFaceHorario(layout.getBaixo());
            }

        }
//        atualizarAmostra();
    }

    public void btnCimaBaixo(int lado, int botao) {
        if (botao == 0) {
            if (lado == 3) {
                girarColunaCima(0, 2);
                inverterCantos(layout.getBaixo(), 0);
                girarFaceAntiHorario(layout.getEsquerda());
                inverterCantos(layout.getAtras(), 2);
            } else if (lado == 4) {
                girarColunaBaixo(0, 2);
                girarColunaBaixo(2, 0);
                girarFaceHorario(layout.getEsquerda());
                girarFaceAntiHorario(layout.getDireita());
                inverterCantos(layout.getCima(), 0);
                inverterCantos(layout.getCima(), 2);
                inverterCantos(layout.getAtras(), 0);
                inverterCantos(layout.getAtras(), 2);
            } else if (lado == 5) {
                girarColunaCima(2, 0);
                girarFaceHorario(layout.getDireita());
                inverterCantos(layout.getBaixo(), 2);
                inverterCantos(layout.getAtras(), 0);

            }

        } else {
            if (lado == 3) {
                girarColunaBaixo(0, 2);
                girarFaceHorario(layout.getEsquerda());
                inverterCantos(layout.getCima(), 0);
                inverterCantos(layout.getAtras(), 2);
            } else if (lado == 4) {

                girarColunaCima(0, 2);
                girarColunaCima(2, 0);
                girarFaceAntiHorario(layout.getEsquerda());
                girarFaceHorario(layout.getDireita());
                inverterCantos(layout.getBaixo(), 0);
                inverterCantos(layout.getBaixo(), 2);
                inverterCantos(layout.getAtras(), 0);
                inverterCantos(layout.getAtras(), 2);
            } else if (lado == 5) {
                girarColunaBaixo(2, 0);
                girarFaceAntiHorario(layout.getDireita());
                inverterCantos(layout.getCima(), 2);
                inverterCantos(layout.getAtras(), 0);

            }
            //inverterCantos(layout.getAtras());
        }
    }

    public void girarLinhaEsquerda(int linha) {
        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getFrente().retangulos[i][linha].getFill();
            layout.getFrente().setCor((Color) layout.getDireita().retangulos[i][linha].getFill(), i, linha);
            aux2 = (Color) layout.getEsquerda().retangulos[i][linha].getFill();
            aux3 = (Color) layout.getAtras().retangulos[i][linha].getFill();
            layout.getEsquerda().setCor((Color) aux, i, linha);
            layout.getAtras().setCor((Color) aux2, i, linha);
            layout.getDireita().setCor((Color) aux3, i, linha);
        }

    }

    public void girarLinhaDireita(int linha) {
        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getFrente().retangulos[i][linha].getFill();
            layout.getFrente().setCor((Color) layout.getEsquerda().retangulos[i][linha].getFill(), i, linha);
            aux2 = (Color) layout.getDireita().retangulos[i][linha].getFill();
            aux3 = (Color) layout.getAtras().retangulos[i][linha].getFill();
            layout.getDireita().setCor((Color) aux, i, linha);
            layout.getAtras().setCor((Color) aux2, i, linha);
            layout.getEsquerda().setCor((Color) aux3, i, linha);
        }

    }

    public void girarColunaCima(int linha, int auxAtras) {
        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getFrente().retangulos[linha][i].getFill();
            layout.getFrente().setCor((Color) layout.getBaixo().retangulos[linha][i].getFill(), linha, i);
            aux2 = (Color) layout.getCima().retangulos[linha][i].getFill();
            aux3 = (Color) layout.getAtras().retangulos[auxAtras][i].getFill();
            layout.getCima().setCor((Color) aux, linha, i);
            layout.getAtras().setCor((Color) aux2, auxAtras, i);
            layout.getBaixo().setCor((Color) aux3, linha, i);
        }
    }

    public void girarColunaBaixo(int linha, int auxAtras) {
        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getFrente().retangulos[linha][i].getFill();
            layout.getFrente().setCor((Color) layout.getCima().retangulos[linha][i].getFill(), linha, i);
            aux2 = (Color) layout.getBaixo().retangulos[linha][i].getFill();
            aux3 = (Color) layout.getAtras().retangulos[auxAtras][i].getFill();
            layout.getBaixo().setCor((Color) aux, linha, i);
            layout.getAtras().setCor((Color) aux2, auxAtras, i);
            layout.getCima().setCor((Color) aux3, linha, i);
        }
    }

    public void girarFaceAntiHorario(FaceCuboPane face) {
        aux = (Color) face.retangulos[0][0].getFill();
        aux2 = (Color) face.retangulos[2][0].getFill();
        aux3 = (Color) face.retangulos[0][2].getFill();
        aux4 = (Color) face.retangulos[2][2].getFill();

        face.setCor(aux, 0, 2);
        face.setCor(aux2, 0, 0);
        face.setCor(aux3, 2, 2);
        face.setCor(aux4, 2, 0);

        aux = (Color) face.retangulos[0][1].getFill();
        aux2 = (Color) face.retangulos[1][0].getFill();
        aux3 = (Color) face.retangulos[1][2].getFill();
        aux4 = (Color) face.retangulos[2][1].getFill();

        face.setCor(aux, 1, 2);
        face.setCor(aux2, 0, 1);
        face.setCor(aux3, 2, 1);
        face.setCor(aux4, 1, 0);
    }

    public void girarFaceHorario(FaceCuboPane face) {
        aux = (Color) face.retangulos[0][0].getFill();
        aux2 = (Color) face.retangulos[0][2].getFill();
        aux3 = (Color) face.retangulos[2][0].getFill();
        aux4 = (Color) face.retangulos[2][2].getFill();

        face.setCor(aux, 2, 0);
        face.setCor(aux2, 0, 0);
        face.setCor(aux3, 2, 2);
        face.setCor(aux4, 0, 2);

        aux = (Color) face.retangulos[1][0].getFill();
        aux2 = (Color) face.retangulos[0][1].getFill();
        aux3 = (Color) face.retangulos[2][1].getFill();
        aux4 = (Color) face.retangulos[1][2].getFill();

        face.setCor(aux, 2, 1);
        face.setCor(aux2, 1, 0);
        face.setCor(aux3, 1, 2);
        face.setCor(aux4, 0, 1);
    }

    public void girarFrontalAntiHorario() {
        if (layout.getFrente().getColor() == Color.WHITE) {
            vermelhoEvidencia();
            girarLinhaDireita(0);
            brancoEvidencia();

        }
    }

    public void girarFrontalHorario() {
        if (layout.getFrente().getColor() == Color.WHITE) {
            vermelhoEvidencia();
            girarLinhaEsquerda(0);
            brancoEvidencia();

        }
    }

    public FaceCuboPane getFaceCubo(Color cor) {
        if (cor == Color.WHITE) {
            return faces[0];
        } else if (cor == Color.YELLOW) {
            return faces[1];
        } else if (cor == Color.BLUE) {
            return faces[2];
        } else if (cor == Color.GREEN) {
            return faces[3];
        } else if (cor == Color.ORANGE) {
            return faces[4];
        } else if (cor == Color.RED) {
            return faces[5];
        } else {
            return null;
        }
    }

    public void rotacionar(int op) {
        if (op == 0) {
            girarFaceAntiHorario(layout.getFrente());
            rotacionarCantoFaceAntHora();
            inverterCantos(layout.getEsquerda(), 2);
            inverterCantos(layout.getDireita(), 0);
            //inverterCantos(layout.getCima(), 2);
        } else if (op == 1) {
            inverterCantos(layout.getEsquerda(), 2);
            inverterCantos(layout.getDireita(), 0);
            girarFaceHorario(layout.getFrente());
            rotacionarCantoFaceHora();
        }
    }

    public void rotacionarCantoFaceAntHora() {

        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getBaixo().retangulos[i][0].getFill();
            aux2 = (Color) layout.getDireita().retangulos[0][i].getFill();
            aux3 = (Color) layout.getCima().retangulos[i][2].getFill();
            aux4 = (Color) layout.getEsquerda().retangulos[2][i].getFill();
            layout.getDireita().setCor((Color) aux, 0, i);
            layout.getCima().setCor((Color) aux2, i, 2);
            layout.getEsquerda().setCor((Color) aux3, 2, i);
            layout.getBaixo().setCor((Color) aux4, i, 0);

        }
    }

    public void rotacionarCantoFaceHora() {
        for (int i = 0; i < 3; i++) {
            aux = (Color) layout.getBaixo().retangulos[i][0].getFill();
            aux2 = (Color) layout.getDireita().retangulos[0][i].getFill();
            aux3 = (Color) layout.getCima().retangulos[i][2].getFill();
            aux4 = (Color) layout.getEsquerda().retangulos[2][i].getFill();
            layout.getDireita().setCor((Color) aux3, 0, i);
            layout.getCima().setCor((Color) aux4, i, 2);
            layout.getEsquerda().setCor((Color) aux, 2, i);
            layout.getBaixo().setCor((Color) aux2, i, 0);

        }
    }

    public void inverterCantos(FaceCuboPane face, int coluna) {
        if (coluna == 0) {
            aux = (Color) face.retangulos[0][0].getFill();
            aux2 = (Color) face.retangulos[0][2].getFill();

            face.setCor(aux, 0, 2);
            face.setCor(aux2, 0, 0);

        } else if (coluna == 2) {

            aux = (Color) face.retangulos[2][0].getFill();
            aux2 = (Color) face.retangulos[2][2].getFill();

            face.setCor(aux, 2, 2);
            face.setCor(aux2, 2, 0);

        }
    }

}
