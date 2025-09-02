package br.com.etechas.tarefas.repository;

import br.com.etechas.tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("select t from Tarefa t where t.id = :id and " +
            "t.status = br.com.etechas.tarefas.enums.StatusEnum.PENDING")
    Optional<Tarefa> findByIdAndPending(Long id);
}
