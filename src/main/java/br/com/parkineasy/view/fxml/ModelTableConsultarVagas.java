package br.com.parkineasy.view.fxml;

public class ModelTableConsultarVagas {

    String id_vaga, tip_vaga;
    Integer sit_vaga;

    public ModelTableConsultarVagas(String id_vaga, String tip_vaga, Integer sit_vaga) {
        this.id_vaga = id_vaga;
        this.tip_vaga = tip_vaga;
        this.sit_vaga = sit_vaga;
    }

    public String getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(String id_vaga) {
        this.id_vaga = id_vaga;
    }

    public String getTip_vaga() {
        return tip_vaga;
    }

    public void setTip_vaga(String tip_vaga) {
        this.tip_vaga = tip_vaga;
    }

    public Integer getSit_vaga() {
        return sit_vaga;
    }

    public void setSit_vaga(Integer sit_vaga) {
        this.sit_vaga = sit_vaga;
    }
}
