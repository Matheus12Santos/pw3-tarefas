package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.enums.StatusEnum;
import br.com.etechas.tarefas.mapper.TarefaMapper;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaResponseDTO> findAll(){
        return tarefaMapper.toResponseDTOList(repository.findAll());
    }

    /*public boolean excluirPorId(Long id){
        if(repository.existsById(id)){
            if(id.equals(StatusEnum.PENDING)) {
                repository.deleteById(id);
            }
            else throw new RuntimeException("Não foi possivel excluir o Repositorio");
        }
        return true;
    }*/

    public boolean deleteById(Long id){
        var tarefa = repository.findById(id);
        if(tarefa.isEmpty()){
            return false;
        }
        if(tarefa.get().isPending()){
            repository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Tarefa em progresso ou bla bla bla");
    }
}
