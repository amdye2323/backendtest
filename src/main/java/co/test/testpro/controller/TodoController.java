package co.test.testpro.controller;

import co.test.testpro.domain.Todo;
import co.test.testpro.dto.DefaultResponseDto;
import co.test.testpro.dto.LoginDto;
import co.test.testpro.dto.TodoDto;
import co.test.testpro.service.TodosService;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodosService todosService;

    public TodoController(TodosService todosService){
        this.todosService = todosService;
    }

    /**
     * @param todoIds
     * @return VO.Todo
     * 할일 단일 조회 API
     */
    @GetMapping(value = "/todos/{todoId}")
    public ResponseEntity<?> getTodoItem(@PathVariable("todoId") int todoIds) {
        try {
            if(todoIds<=0){
                return new ResponseEntity<>(new DefaultResponseDto(400,"Bad Request"), HttpStatus.BAD_REQUEST);
            }
            Optional<Todo> todo = todosService.findByTodoId(todoIds);
            if(todo==null){
                return new ResponseEntity<>(new DefaultResponseDto(404 , "404 Forbbiden"),HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(todo,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new DefaultResponseDto(500,"Server Error"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param limit
     * @param skip
     * @return List<VO.Todo>
     * 할일 리스트 전체 조회 API
     */
    @GetMapping(value = "/todos")
    public ResponseEntity<?> getTodoItemList(@RequestParam("limit") int limit,@RequestParam("skip") int skip) {
        try {
            if(limit>skip){
                return new ResponseEntity<>(new DefaultResponseDto(400,"Bad Request"), HttpStatus.BAD_REQUEST);
            }
            Optional<List<Todo>> todos = todosService.findTodoList(limit,skip);
            if(todos==null){
                return new ResponseEntity<>(new DefaultResponseDto(404 , "404 Forbbiden"),HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(todos,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new DefaultResponseDto(500,"Server Error"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param todoIds
     * @return VO.Todo
     * 할일 상태 업데이트 API
     */
    @PutMapping(value = "/todos/{todoId}")
    public ResponseEntity<?> updateTodoItem(@PathVariable("todoId") int todoIds){
        try {
            if(todoIds<=0){
                return new ResponseEntity<>(new DefaultResponseDto(400,"Bad Request"), HttpStatus.BAD_REQUEST);
            }
            Optional<Todo> todo = todosService.updateTodo(todoIds);
            if(todo==null){
                return new ResponseEntity<>(new DefaultResponseDto(404 , "404 Forbbiden"),HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(todo,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new DefaultResponseDto(500,"Server Error"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param todoIds
     * @return String
     * 할일 삭제 API
     */
    @DeleteMapping(value = "/todos/{todoId}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable("todoId") int todoIds){
        try {
            if(todoIds<=0){
                return new ResponseEntity<>(new DefaultResponseDto(400,"Bad Request"), HttpStatus.BAD_REQUEST);
            }
            Optional<String> result = todosService.deleteTodo(todoIds);
            if(result==null||result.equals("")){
                return new ResponseEntity<>(new DefaultResponseDto(404 , "404 Forbbiden"),HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new DefaultResponseDto(500,"Server Error"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param todoDto
     * @return VO.Todo
     * 할일 생성 API
     */
    @PostMapping(value = "/todos")
    public ResponseEntity<?> createTodoItem(@Valid @RequestBody TodoDto todoDto){
        try {
            if(todoDto.getName()==null||todoDto.getName().equals("")){
                return new ResponseEntity<>(new DefaultResponseDto(400,"Bad Request"), HttpStatus.BAD_REQUEST);
            }

            Optional<Todo> todo = todosService.addTodo(todoDto);

            if(todo==null){
                return new ResponseEntity<>(new DefaultResponseDto(404 , "404 Forbbiden"),HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(todo,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new DefaultResponseDto(500,"Server Error"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
