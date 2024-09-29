package SpringProblem.service;

import SpringProblem.dto.request.RegisterMemberRequestDto;
import SpringProblem.dto.response.RegisterMemberResponseDto;
import SpringProblem.entity.Member;
import SpringProblem.entity.Team;
import SpringProblem.exception.NotFoundTeamException;
import SpringProblem.repository.MemberRepository;
import SpringProblem.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    private TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository,TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public Optional<Member> registerMember(RegisterMemberRequestDto registerMemberRequestDto){
        //팀을 팀 이름으로 찾음
        Team team = teamRepository.findByTeamName(registerMemberRequestDto.teamName())
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundTeamException("해당 팀은 존재하지 않음"));

        //맴버 저장
        memberRepository.save(Member
                .builder()
                .memberName(registerMemberRequestDto.name())
                .team(team)
                .birthday(LocalDate.parse(registerMemberRequestDto.birthday()))
                .manager(registerMemberRequestDto.manage())
                .workStartDate(LocalDate.parse(registerMemberRequestDto.workStartDate()))
                .build());


        return Optional.empty();
    }

}
