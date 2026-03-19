package br.mackenzie.lab_7.model;

public class Veiculo {

    private int id;
    private int proprietarioId;
    private String placa;

    public Veiculo() {}

    public Veiculo(int id, int proprietarioId, String placa){
        this.id = id;
        this.proprietarioId = proprietarioId;
        this.placa = placa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProprietarioId() { return proprietarioId; }
    public void setProprietarioId(int proprietarioId) { this.proprietarioId = proprietarioId; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
}