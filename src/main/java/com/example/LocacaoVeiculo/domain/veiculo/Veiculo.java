package com.example.LocacaoVeiculo.domain.veiculo;

public class Veiculo {

    private String nome;
    private String fabricante;
    private Integer anoFab;
    private String placa;

    //Recebendo por parametro os dados recebidos do record, que recebe do formulario.
    public Veiculo(DadosCadastroVeiculos dados){
        this.nome = dados.nome();
        this.fabricante = dados.fabricante();
        this.anoFab = dados.anoFab();
        this.placa = dados.placa();
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Integer getAnoFab() {
        return anoFab;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", anoFab=" + anoFab +
                ", placa='" + placa + '\'' +
                '}';
    }
}
