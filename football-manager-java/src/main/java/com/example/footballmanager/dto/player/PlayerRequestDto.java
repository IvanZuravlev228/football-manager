package com.example.footballmanager.dto.player;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerRequestDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal experience;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
}
