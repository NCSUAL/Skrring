package SpringProblem.dto.response;

import SpringProblem.entity.Manage;
import lombok.Builder;

import java.time.LocalDate;

public class RegisterMemberResponseDto {
    private long id;
    private String memberName;
    private Manage manager;
    private LocalDate birthday;
    private LocalDate workStartDate;

    @Builder
    private RegisterMemberResponseDto(long id,String memberName,Manage manager,LocalDate birthday,LocalDate workStartDate){
        this.id = id;
        this.memberName = memberName;
        this.manager = manager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    //factory
    public static RegisterMemberResponseDto of(long id,String memberName,Manage manager,LocalDate birthday,LocalDate workStartDate){
        return RegisterMemberResponseDto.builder()
                .id(id)
                .memberName(memberName)
                .manager(manager)
                .birthday(birthday)
                .workStartDate(workStartDate)
                .build();
    }

}
