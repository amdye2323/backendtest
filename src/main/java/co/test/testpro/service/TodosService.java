package co.test.testpro.service;

import co.test.testpro.domain.Todo;
import co.test.testpro.dto.TodoDto;
import co.test.testpro.repository.JpaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class TodosService {

    private final JpaTodoRepository jpaTodoRepository;

    @Autowired
    public TodosService(JpaTodoRepository jpaTodoRepository){
        this.jpaTodoRepository = jpaTodoRepository;
    }

    public Optional<String> addTodo(TodoDto todoDto){
        Date date = new Date();
        if(todoDto.getName()==""){
            return null;
        }
        Todo todo = Todo.builder()
                .completed(false)
                .name(todoDto.getName())
                .build();

        return jpaTodoRepository.createTodo(todo);
    }

    public Optional<Todo> findByTodoId(int id) {
        return jpaTodoRepository.findByTodoId(id);
    }

    public Optional<String> updateTodo(int id){
        return jpaTodoRepository.updateTodo(id);
    }

    public Optional<String> deleteTodo(int id){
        return jpaTodoRepository.deleteTodo(id);
    }
}
