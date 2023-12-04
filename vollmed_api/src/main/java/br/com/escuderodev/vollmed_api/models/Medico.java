package br.com.escuderodev.vollmed_api.models;

import br.com.escuderodev.vollmed_api.dto.DadosAtualizaMedico;
import br.com.escuderodev.vollmed_api.dto.DadosCadastroMedico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private Boolean status;
    @Embedded
    private Endereco endereco;

    public Medico(@Valid DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.status = true;
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizaDados(DadosAtualizaMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.endereco.atualizaDados(dados.endereco());
    }

    public void exclusaoLogica() {
        this.status = false;
    }
}
