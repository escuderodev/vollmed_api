package br.com.escuderodev.vollmed_api.dto;

import br.com.escuderodev.vollmed_api.models.Especialidade;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String crm,
        Especialidade especialidade,
        DadosCadastroEndereco endereco) {

}
