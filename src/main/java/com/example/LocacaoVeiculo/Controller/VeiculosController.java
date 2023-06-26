package com.example.LocacaoVeiculo.Controller;

import com.example.LocacaoVeiculo.domain.veiculo.DadosCadastroVeiculos;
import com.example.LocacaoVeiculo.domain.veiculo.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller //Anotacoes para declarar a classe como controlador
@RequestMapping("/veiculos") // Mapeando a requisição, quando chamar o endereco /veiculos, ira chamar este controlador.
public class VeiculosController {

    private List<Veiculo> veiculos = new ArrayList<>();

    @GetMapping("/cadastro") //QUando haver uma requisição /veiculos/formulario ira executar este metodo
    public String apresentaPaginaCadastro(){
        return "veiculos/cadastro";
    }

    @GetMapping("listaveiculos") //QUando haver uma requisição /veiculos/listaveiculos ira executar este medoto
    public String apresentaPaginaListagem(Model model){
        model.addAttribute("lista",veiculos);//Enviando a informação para pagina HTML
        return "veiculos/listaveiculos";
    }

    @PostMapping
    public String cadastraVeiculo(DadosCadastroVeiculos dados){
        var veiculo = new Veiculo(dados);
        veiculos.add(veiculo);
        System.out.println(veiculos);
        return "redirect:/veiculos/listaveiculos"; //ao cadastrar um veiculo, ira redirecionar para pagina /listaveiculos
    }

}
