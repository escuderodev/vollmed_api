package br.com.escuderodev.vollmed_api.dto;

import br.com.escuderodev.vollmed_api.models.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosCadastroEndereco endereco) {
}
