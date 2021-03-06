package co.test.testpro.repository;

import co.test.testpro.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodosRepository {
    Optional<Todo> findByTodoId(int id);
    Optional<Todo> findByTodoName(String name);
    Optional<String> updateTodo(int id);
    Optional<String> createTodo(Todo todo);
    Optional<String> deleteTodo(int id);
    Optional<List<Todo>> getTodoList(int limit,int skip);
    Optional<String> imageUpload(Todo todo);
}
