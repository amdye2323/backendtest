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

    private Boolean completed;

}
