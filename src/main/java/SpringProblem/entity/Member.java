package SpringProblem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Enumerated(EnumType.STRING)
    private Manage manager;

    private LocalDate birthday;

    private LocalDate workStartDate;

    @Builder
    public Member(int id, String memberName, Team team, Manage manager, LocalDate birthday, LocalDate workStartDate) {
        this.id = id;
        this.memberName = memberName;
        this.team = team;
        this.manager = manager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    protected Member(){}

}
