package br.com.escuderodev.vollmed_api.controller;

import br.com.escuderodev.vollmed_api.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.vollmed_api.dto.DadosAtualizaMedico;
import br.com.escuderodev.vollmed_api.dto.DadosCadastroMedico;
import br.com.escuderodev.vollmed_api.dto.DadosListagemMedico;
import br.com.escuderodev.vollmed_api.models.Medico;
import br.com.escuderodev.vollmed_api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@CrossOrigin
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Page<DadosListagemMedico> consultarMedicos(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/ativo")
    public Page<DadosListagemMedico> consultarMedicosAtivos(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByStatusTrue(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/{id}")
    public Medico consultarMedicoPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Médico não encontrado!"));
    }

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {

        repository.save(new Medico(dados));
    }

    @PutMapping
    @Transactional
    public void  atualizarMedico(@RequestBody @Valid DadosAtualizaMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("logica/{id}")
    @Transactional
    public void exclusaoLogicaMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.exclusaoLogica();
    }
}
