package co.test.testpro.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    @NotNull
    private String name;

    @NotNull
    private Boolean completed;

    private Date completedAt;

    private Date createAt;

    private Date updateAt;
}
