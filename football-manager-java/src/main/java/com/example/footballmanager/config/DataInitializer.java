package com.example.footballmanager.config;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataInitializer {
    private final Random random = new Random();
    private final PlayerService playerService;
    private final TeamService teamService;
    private final List<Player> players = new ArrayList<>();

    @PostConstruct
    public void inject() {
        for (int i = 1; i < 50; i++) {
            Player player = new Player();
            player.setFirstName("firstname_" + i);
            player.setLastName("lastname_" + i);
            player.setExperience(BigDecimal.valueOf(random.nextInt(10) + 5));
            player.setCountryOfBirth("country_" + i);
            LocalDate birth = LocalDate.of(random.nextInt(25) + 1990,
                    random.nextInt(12) + 1, random.nextInt(27) + 1);
            player.setDateOfBirth(birth);
            player.setAge(LocalDate.now().getYear() - birth.getYear());
            players.add(player);
            playerService.save(player);
        }

        Team barcelona = new Team();
        barcelona.setMoney(BigDecimal.valueOf(10000));
        barcelona.setTeamName("Barcelona");
        barcelona.setCommission(BigDecimal.valueOf(10));
        barcelona.setNickname("Barca");
        barcelona.setCountry("Spain");
        barcelona.setPlayers(getPlayersList(0, 12));
        teamService.createTeam(barcelona);

        Team dinamo = new Team();
        dinamo.setMoney(BigDecimal.valueOf(1000));
        dinamo.setTeamName("Dinamo");
        dinamo.setCommission(BigDecimal.valueOf(1));
        dinamo.setNickname("dinamo");
        dinamo.setCountry("Ukraine");
        dinamo.setPlayers(getPlayersList(12, 23));
        teamService.createTeam(dinamo);

        Team realMadrid = new Team();
        realMadrid.setMoney(BigDecimal.valueOf(1000));
        realMadrid.setTeamName("Real Madrid");
        realMadrid.setCommission(BigDecimal.valueOf(7));
        realMadrid.setNickname("real");
        realMadrid.setCountry("Spain");
        realMadrid.setPlayers(getPlayersList(23, 45));
        teamService.createTeam(realMadrid);
    }

    private List<Player> getPlayersList(int from, int to) {
        List<Player> result = new ArrayList<>();
        for (int i = from; i < to; i++) {
            result.add(players.get(i));
        }
        return result;
    }
}
