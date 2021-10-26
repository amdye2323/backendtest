package co.test.testpro.service;

import co.test.testpro.domain.Todo;
import co.test.testpro.dto.TodoDto;
import co.test.testpro.repository.TodosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TodosServiceTest {

    @Autowired TodosService todosService;
    @Autowired TodosRepository todosRepository;

    @Test
    void addTodo() throws Exception {
        //테스트 객체 생성
        TodoDto todoDto = new TodoDto();
        Date date = new Date();
        todoDto.setName("테스트 내용"+date.toString());

        String result = String.valueOf(todosService.addTodo(todoDto));

    }

    @Test
    void findByTodoId() throws Exception {
        TodoDto todoDto = new TodoDto();
        Date date = new Date();
        String name = "내용 찾기 테스트"+date.toString();
        todoDto.setName(name);

        String.valueOf(todosService.addTodo(todoDto));

        Todo todo1 = todosRepository.findByTodoName(name).orElseThrow(
                () -> new Exception("cannot add Todo One")
        );
        Optional<Todo> todo2 =  todosService.findByTodoId(todo1.getId());
        Optional.of(todo2).orElseThrow( () -> new Exception("cannot find by id"));
        if(!todo2.get().getName().equals(name)){
            new Exception("not matched todo names");
        };
    }

    @Test
    void updateTodo() throws Exception {
        TodoDto todoDto = new TodoDto();
        Date date = new Date();
        String name = "상태 업데이트 테스트"+date.toString();
        todoDto.setName(name);

        String.valueOf(todosService.addTodo(todoDto));

        Todo todo1 = todosRepository.findByTodoName(name).orElseThrow(
                () -> new Exception("cannot add Todo One")
        );

        todosService.updateTodo(todo1.getId());

        Todo todo2 = todosRepository.findByTodoName(name).orElseThrow(
                () -> new Exception("cannot searched find by name")
        );

        if(todo1.isCompleted()!=todo2.isCompleted()){
           new Exception("update function not working!");
        }
    }

    @Test
    void deleteTodo() throws Exception {
        TodoDto todoDto = new TodoDto();
        Date date = new Date();
        String name = "할일 삭제 테스트"+date.toString();
        todoDto.setName(name);

        String.valueOf(todosService.addTodo(todoDto));

        Todo todo1 = todosRepository.findByTodoName(name).orElseThrow(
                () -> new Exception("cannot add Todo One")
        );

        todosService.deleteTodo(todo1.getId());

        NoResultException e = assertThrows(NoResultException.class,
                () -> todosService.findByTodoId(todo1.getId())
        );

        if(!e.getMessage().equals("")){
            new Exception("delete function not working!");
        }
    }
}