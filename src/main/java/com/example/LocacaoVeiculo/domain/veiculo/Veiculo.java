package com.example.LocacaoVeiculo.domain.veiculo;

import jakarta.persistence.*;

@Entity // Anotação que informa que essa classe representa uma tabela
@Table (name = "veiculos") //Anotação para informar o nome da tabela
public class Veiculo {

    @Id //Informando que o id representa chave primaria.
    // Como o ID sera gerado pelo banco, passamos a anotação GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Parametro para passaremos a estrategia de geração de ID

    private Long id;
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

    public Long getId() {
        return id;
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
