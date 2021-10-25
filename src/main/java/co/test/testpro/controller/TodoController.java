package co.test.testpro.controller;

import co.test.testpro.domain.Todo;
import co.test.testpro.dto.TodoDto;
import co.test.testpro.service.TodosService;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodosService todosService;

    public TodoController(TodosService todosService){
        this.todosService = todosService;
    }
//
//    @GetMapping(value = "/get/{todoIds}")
//    public ResponseEntity<Todo> getTodoList(@PathVariable("todoIds") String todoIds){
//
//        Todo todo =
//        return todo;
//    }
//
//    @PutMapping(value = "/update")
}
