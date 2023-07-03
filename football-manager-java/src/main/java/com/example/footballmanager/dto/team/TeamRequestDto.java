package com.example.footballmanager.dto.team;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamRequestDto {
    private String teamName;
    private BigDecimal money;
    private String country;
    private String nickname;
    private BigDecimal commission;
    private List<Long> playersId;
}
