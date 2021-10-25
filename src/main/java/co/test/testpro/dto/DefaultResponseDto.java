package co.test.testpro.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultResponseDto {
    private int status;
    private String responseMessage;
}
