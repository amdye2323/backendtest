package co.test.testpro.repository;


import co.test.testpro.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaTodoRepository implements TodosRepository {

    private final EntityManager em;

    public JpaTodoRepository(EntityManager em){
        this.em = em;
    }

    private static final Logger logger = LoggerFactory.getLogger(JpaTodoRepository.class);

    @Override
    public Optional<Todo> findByTodoId(int id) {
        try {
            Todo todo = em.createQuery("SELECT t FROM todo as t WHERE t.id = :id",Todo.class)
                    .setParameter("id",id)
                    .getSingleResult();
            return Optional.ofNullable(todo);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("조회에 실패했습니다.");
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> updateTodo(int id) {
        try {
            em.getTransaction().begin();
            int result = em.createQuery("UPDATE todo as t SET t.completed = true WHERE t.id = :id")
                    .setParameter("id",id)
                    .executeUpdate();
            em.getTransaction().commit();
            em.close();
            if (result>=1){
                return Optional.of("success");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(id+"번의 업데이트를 실패하였습니다.");
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> createTodo(Todo todo) {
        try {
            em.persist(todo);
            em.flush();
            return Optional.of("success");
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(todo.toString()+"생성에 실패하였습니다.");
        }
        return null;
    }

    @Override
    public Optional<String> deleteTodo(int id) {
        try {
            Todo todo = em.find(Todo.class,id);
            em.remove(todo);
            em.flush();
            return Optional.of("success");
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(id + "번 삭제에 실패했습니다.");
        }
        return null;
    }

    @Override
    public Optional<List<Todo>> getTodoList(int limit,int skip) {
        try {
            List<Todo> todos = em.createQuery("SELECT t FROM todo as t LIMIT :skip , :limit",Todo.class)
                    .setParameter("skip",skip)
                    .setParameter("limit",limit)
                    .getResultList();

            return Optional.ofNullable(todos);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("리스트 호출에 실패했습니다.");
        }
        return null;
    }
}
