package br.com.escuderodev.vollmed_api.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String crm,
        DadosCadastroEndereco endereco
) {
}
