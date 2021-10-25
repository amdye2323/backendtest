package co.test.testpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Column(name = "name")
    private String name;

    @Column(name = "completed",nullable = true)
    private boolean completed;

    @Id
    @JsonIgnore
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "completed_at",nullable = true)
    private String completed_at;

    @Column(name = "create_at",columnDefinition = "DEFAULT date_format(curDate(),'%Y-%m-%d')")
    private String create_at;

    @Column(name = "update_at",columnDefinition = "DEFAULT '0000-00-00'")
    private String update_at;

}
