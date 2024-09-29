package SpringProblem.controller;

import SpringProblem.dto.request.RegisterMemberRequestDto;
import SpringProblem.dto.request.RegisterTeamRequestDto;
import SpringProblem.dto.response.RegisterMemberResponseDto;
import SpringProblem.dto.response.RegisterTeamResponseDto;
import SpringProblem.entity.Team;
import SpringProblem.service.MemberService;
import SpringProblem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;

    //팀 가입
    @PostMapping("/team")
    public ResponseEntity<RegisterTeamResponseDto> registerTeam(@RequestBody RegisterTeamRequestDto registerTeamRequestDto){
        return teamService.registerTeam(registerTeamRequestDto)
                .stream()
                .map(team -> ResponseEntity.ok(RegisterTeamResponseDto.of(team)))
                .findAny()
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //직원 가입
    @PostMapping("/member")
    public ResponseEntity<RegisterMemberResponseDto> registerMember(@RequestBody RegisterMemberRequestDto registerMemberRequestDto){
        memberService.registerMember(registerMemberRequestDto);
        return ResponseEntity.badRequest().build();
    }





}
