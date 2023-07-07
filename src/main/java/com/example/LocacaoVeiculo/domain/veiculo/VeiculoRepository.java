package com.example.LocacaoVeiculo.domain.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

//Esta é uma classe do Spring que representa um repositorio de acesso a dados
//Entre <entidade, tipo do ID>
public interface VeiculoRepository extends JpaRepository <Veiculo,Long>{
}
