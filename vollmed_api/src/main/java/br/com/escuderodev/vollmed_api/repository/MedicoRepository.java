package br.com.escuderodev.vollmed_api.repository;

import br.com.escuderodev.vollmed_api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
