package co.test.testpro.service;

import co.test.testpro.domain.Todo;
import co.test.testpro.dto.TodoDto;
import co.test.testpro.repository.JpaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodosService {

    private final JpaTodoRepository jpaTodoRepository;

    @Autowired
    public TodosService(JpaTodoRepository jpaTodoRepository){
        this.jpaTodoRepository = jpaTodoRepository;
    }

    @Transactional
    public Optional<Todo> addTodo(TodoDto todoDto){
        Date date = new Date();
        if(todoDto.getName()==""){
            return null;
        }
        Todo todo = Todo.builder()
                .completed(false)
                .name(todoDto.getName())
                .build();

        Optional<String> result = jpaTodoRepository.createTodo(todo);
        if(result.get().equals("success")){
            return jpaTodoRepository.findByTodoName(todo.getName());
        }else{
            return null;
        }
    }

    public Optional<Todo> findByTodoId(int id) {
        return jpaTodoRepository.findByTodoId(id);
    }

    public Optional<Todo> updateTodo(int id){
        Optional<String> result =jpaTodoRepository.updateTodo(id);
        if(result.equals("success")){
            return findByTodoId(id);
        }
        return null;
    }

    public Optional<String> deleteTodo(int id){
        return jpaTodoRepository.deleteTodo(id);
    }

    public Optional<List<Todo>> findTodoList(int limit,int skip){
        return jpaTodoRepository.getTodoList(limit,skip);
    }
}
