package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import com.example.footballmanager.service.TransferService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService {
    private final TeamService teamService;
    private final PlayerService playerService;

    @Override
    public void moveToOtherTeam(Long fromTeamId, Long toTeamId, Long playerId) {
        Team fromTeam = teamService.getById(fromTeamId);
        Player player = playerService.getById(playerId);
        Team toTeam = teamService.getById(toTeamId);
        boolean isRemoved = fromTeam.getPlayers().remove(player);
        if (!isRemoved) {
            throw new RuntimeException("Player with id " + playerId
                    + " doesn't exist in team with id " + fromTeamId);
        }

        BigDecimal cost = calculatePlayerCost(player.getExperience(),
                player.getAge(), fromTeam.getCommission());
        if (toTeam.getMoney().compareTo(cost) == -1) {
            throw new RuntimeException("Team " + fromTeam
                    + " doesn't have " + cost + ". They have " + fromTeam.getMoney());
        }
        toTeam.setMoney(fromTeam.getMoney().subtract(cost));
        fromTeam.setMoney(fromTeam.getMoney().add(cost));

        teamService.update(fromTeam);
        toTeam.getPlayers().add(player);
        teamService.update(toTeam);
    }

    private BigDecimal calculatePlayerCost(BigDecimal experience, int age,
                                           BigDecimal commissionPercent) {
        BigDecimal cost = experience.multiply(BigDecimal.valueOf(1000))
                .divide(BigDecimal.valueOf(age), 2);
        BigDecimal commission = cost.multiply(commissionPercent)
                .divide(BigDecimal.valueOf(100), 2);
        return cost.add(commission);
    }
}
