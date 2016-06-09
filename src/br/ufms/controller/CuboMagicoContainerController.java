package br.ufms.controller;

import br.ufms.view.CuboLayout;
import br.ufms.view.CuboPane;
import br.ufms.view.FaceCuboPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class CuboMagicoContainerController implements Initializable {

    @FXML
    private ToggleButton btnBranco;
    @FXML
    private ToggleButton btnAmarelo;
    @FXML
    private ToggleButton btnVerde;
    @FXML
    private ToggleButton btnAzul;
    @FXML
    private ToggleButton btnLaranja;
    @FXML
    private ToggleButton btnVermelho;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private ToggleGroup rowColumnToggleGroup;
    @FXML
    private StackPane faceCuboBackground;
    @FXML
    private StackPane container;
    private CuboPane cuboPane;
    private FaceCuboPane faceAmostra;
    private CuboLayout cuboLayout;
    @FXML
    private Button btnAntiHorario;
    @FXML
    private Button btnHorario;
    @FXML
    private Button btnEsquerdaBaixo;
    @FXML
    private Button btnDireitaCima;
    @FXML
    private RadioButton radioBtn1;
    @FXML
    private RadioButton radioBtn2;
    @FXML
    private RadioButton radioBtn3;
    @FXML
    private RadioButton radioBtn4;
    @FXML
    private RadioButton radioBtn5;
    @FXML
    private Button embaralharBtn;
    
    private int lado;

    FaceCuboPane cuboPaneOrigem = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cuboPane = new CuboPane();
        cuboLayout = new CuboLayout();
        faceAmostra = new FaceCuboPane(Color.WHITE);

        faceCuboBackground.getChildren().add(faceAmostra);
        container.getChildren().add(cuboPane);

        colorToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    if (newValue == btnBranco && oldValue != null) {
                        cuboPaneOrigem = cuboPane.getFaceCubo(Color.WHITE);
                        cuboPane.brancoEvidencia();
                        if (oldValue == btnAmarelo) {
                            cuboPane.arrumarEvidencia(1, 0);
                        } else if (oldValue == btnAzul) {
                            cuboPane.arrumarEvidencia(2, 0);
                        } else if (oldValue == btnVerde) {
                            cuboPane.arrumarEvidencia(3, 0);
                        }
                        //----------------------------------------    
                    } else if (newValue == btnAmarelo) {
                        cuboPaneOrigem = cuboPane.getFaceCubo(Color.YELLOW);
                        cuboPane.amareloEvidencia();
                        if (oldValue == btnBranco) {
                            cuboPane.arrumarEvidencia(0, 1);
                        } else if (oldValue == btnAzul) {
                            cuboPane.arrumarEvidencia(2, 1);
                        } else if (oldValue == btnVerde) {
                            cuboPane.arrumarEvidencia(3, 1);
                        }
                        //----------------------------------------    

                    } else if (newValue == btnAzul) {
                        cuboPaneOrigem = cuboPane.getFaceCubo(Color.BLUE);
                        cuboPane.azulEvidencia();
                        if (oldValue == btnBranco) {
                            cuboPane.arrumarEvidencia(0, 2);
                        } else if (oldValue == btnAmarelo) {
                            cuboPane.arrumarEvidencia(1, 2);
                        } else if (oldValue == btnVerde) {
                            cuboPane.arrumarEvidencia(3, 2);
                        }

                        //----------------------------------------  
                    } else if (newValue == btnVerde) {
                        cuboPaneOrigem = cuboPane.getFaceCubo(Color.GREEN);
                        cuboPane.verdeEvidencia();
                        if (oldValue == btnBranco) {
                            cuboPane.arrumarEvidencia(0, 3);
                        } else if (oldValue == btnAmarelo) {
                            cuboPane.arrumarEvidencia(1, 3);
                        } else if (oldValue == btnAzul) {
                            cuboPane.arrumarEvidencia(2, 3);
                        }
                    } else {
                        cuboPaneOrigem = cuboPane.getFaceCubo(Color.WHITE);
                        cuboPane.brancoEvidencia();
                        if (oldValue == btnAmarelo) {
                            cuboPane.arrumarEvidencia(1, 0);
                        } else if (oldValue == btnAzul) {
                            cuboPane.arrumarEvidencia(2, 0);
                        } else if (oldValue == btnVerde) {
                            cuboPane.arrumarEvidencia(3, 0);
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                        }
                    }

                }
            }

        });

        Image icone1 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/antihorario.png"));
        btnAntiHorario.setGraphic(new ImageView(icone1));
        Image icone2 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/horario.png"));
        btnHorario.setGraphic(new ImageView(icone2));
        Image icone3 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/cuboembaralhado.png"));
        icone1 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setaesquerda.png"));
        icone2 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setadireita.png"));
        btnEsquerdaBaixo.setGraphic(new ImageView(icone1));
        btnDireitaCima.setGraphic(new ImageView(icone2));
        embaralharBtn.setGraphic(new ImageView(icone3));

        rowColumnToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                Image icone1, icone2;
                if (newValue == radioBtn1 || newValue == radioBtn2 || newValue == radioBtn5) {
                    icone1 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setaesquerda.png"));
                    icone2 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setadireita.png"));
                    if (newValue == radioBtn1) {
                        lado = 0;
                    } else if ((newValue == radioBtn2)) {
                        lado = 1;
                    } else {
                        lado = 2;
                    }
                } else {
                    icone1 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setacima.png"));
                    icone2 = new Image(getClass().getResourceAsStream("/br/ufms/view/image/setabaixo.png"));

                    if (newValue == radioBtn3) {
                        lado = 3;
                    } else if ((newValue == radioBtn4)) {
                        lado = 4;
                    } else {
                        lado = 5;
                    }
                }

                btnEsquerdaBaixo.setGraphic(new ImageView(icone1));
                btnDireitaCima.setGraphic(new ImageView(icone2));

                btnEsquerdaBaixo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (lado <= 2) {
                            cuboPane.btnEsquerdaDireita(lado, 0);
                        } else {
                            cuboPane.btnCimaBaixo(lado, 0);
                        }
                        cuboPaneOrigem = cuboPane.atualizarAmostra();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                            }
                        }
                    }
                });

                btnDireitaCima.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (lado <= 2) {
                            cuboPane.btnEsquerdaDireita(lado, 1);
                        } else {
                            cuboPane.btnCimaBaixo(lado, 1);
                        }
                        
                        cuboPaneOrigem = cuboPane.atualizarAmostra();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                            }
                        }
                    }
                });
            }
        });

        btnAntiHorario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cuboPane.rotacionar(0);
                cuboPaneOrigem = cuboPane.atualizarAmostra();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                    }
                }
            }
        });

        btnHorario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cuboPane.rotacionar(1);
                cuboPaneOrigem = cuboPane.atualizarAmostra();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                    }
                }
            }
        });
        
        embaralharBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                cuboPane.embaralhar();
                cuboPaneOrigem = cuboPane.atualizarAmostra();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                faceAmostra.setCor((Color) cuboPaneOrigem.getMatriz()[i][j].getFill(), i, j);
                            }
                        }
            }
        });

    }

}
