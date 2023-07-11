package com.example.LocacaoVeiculo.Controller;

import com.example.LocacaoVeiculo.domain.veiculo.DadosAlteraVeiculos;
import com.example.LocacaoVeiculo.domain.veiculo.DadosCadastroVeiculos;
import com.example.LocacaoVeiculo.domain.veiculo.Veiculo;
import com.example.LocacaoVeiculo.domain.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //Anotacoes para declarar a classe como controlador
@RequestMapping("/veiculos") // Mapeando a requisição, quando chamar o endereco /veiculos, ira chamar este controlador.
public class VeiculosController {

    @Autowired //O Spring ira instanciar o objeto automaticamente
    private VeiculoRepository repository;

    @GetMapping("/cadastro") //QUando haver uma requisição /veiculos/formulario ira executar este metodo
    public String apresentaPaginaCadastro(Long id,Model model){
        if(id!=null){
            var veiculo = repository.getReferenceById(id); //metodo para carregar os dados do objeto
            model.addAttribute("veiculo",veiculo); //Quando entrar no if ira passar esses valores
        }

        return "veiculos/cadastro";
    }

    @GetMapping("listaveiculos") //QUando haver uma requisição /veiculos/listaveiculos ira executar este medoto
    public String apresentaPaginaListagem(Model model){
        model.addAttribute("lista",repository.findAll());//Enviando a informação para pagina HTML
        return "veiculos/listaveiculos";
    }

    @PostMapping
    @Transactional
    public String cadastraVeiculo(DadosCadastroVeiculos dados){
        var veiculo = new Veiculo(dados);

        repository.save(veiculo);//save é utilizado para fazer insert no banco

        return "redirect:/veiculos/listaveiculos"; //ao cadastrar um veiculo, ira redirecionar para pagina /listaveiculos
    }

    @PutMapping
    @Transactional //Anotacao do pacote spring para iniciar uma transação no banco de dados
    public String alteraVeiculo(DadosAlteraVeiculos dados){
        var veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizaDados(dados);

        return "redirect:/veiculos/listaveiculos"; //ao cadastrar um veiculo, ira redirecionar para pagina /listaveiculos
    }

    @DeleteMapping
    @Transactional
    public String removeVeiculo(Long id){
        repository.deleteById(id);

        return "redirect:/veiculos/listaveiculos";
    }

}
