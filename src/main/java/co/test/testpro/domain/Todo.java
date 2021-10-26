package co.test.testpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "completed",nullable = true)
    private boolean completed;

    @Id
    @JsonIgnore
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "oriname")
    private String oriname;

    @Column(name = "path")
    private String path;

    @Column(name = "size")
    private long size;

    @Column(name = "completedat",nullable = true)
    private String completed_at;

    @Column(name = "createat",columnDefinition = "timestamp DEFAULT current_timestamp")
    private String create_at;

    @Column(name = "updateat",columnDefinition = "DATETIME DEFAULT '0000-00-00 00:00:00'")
    private String update_at;

}
