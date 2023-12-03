package br.com.escuderodev.vollmed_api.controller;

import br.com.escuderodev.vollmed_api.dto.DadosCadastroMedico;
import br.com.escuderodev.vollmed_api.models.Medico;
import br.com.escuderodev.vollmed_api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public List<Medico> consultarMedico() {
        List<Medico> medicos = repository.findAll();
        return medicos;
    }

    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

}
