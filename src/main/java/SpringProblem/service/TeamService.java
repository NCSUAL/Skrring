package SpringProblem.service;

import SpringProblem.dto.request.RegisterTeamRequestDto;
import SpringProblem.entity.Team;
import SpringProblem.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Team> registerTeam(RegisterTeamRequestDto registerTeamRequestDto) {
        try {
            Team team =
                    Team.builder()
                    .teamName(registerTeamRequestDto.teamName())
                    .build();

            teamRepository.save(team);
            return Optional.of(team);
        }
        catch (Exception e){
            log.info("TeamService -> registerTeam error: {}", e.getMessage());
            return Optional.empty();
        }
    }

}
