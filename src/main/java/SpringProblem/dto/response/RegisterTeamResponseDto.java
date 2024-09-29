package SpringProblem.dto.response;

import SpringProblem.entity.Team;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterTeamResponseDto {
    private final long id;
    private final String teamName;

    @Builder
    private RegisterTeamResponseDto(long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    //factory
    public static RegisterTeamResponseDto of(Team team){
        return RegisterTeamResponseDto
                .builder()
                .id(team.getId())
                .teamName(team.getTeamName())
                .build();
    }

}
