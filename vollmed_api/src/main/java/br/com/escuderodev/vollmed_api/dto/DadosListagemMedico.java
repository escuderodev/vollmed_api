package br.com.escuderodev.vollmed_api.dto;

import br.com.escuderodev.vollmed_api.models.Endereco;
import br.com.escuderodev.vollmed_api.models.Especialidade;
import br.com.escuderodev.vollmed_api.models.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Boolean status,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getStatus(), medico.getEspecialidade(), medico.getEndereco());
    }
}
