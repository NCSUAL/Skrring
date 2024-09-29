package SpringProblem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private long id;

    private String teamName;

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL,orphanRemoval = true)
    private final List<Member> member = new ArrayList<Member>();

    @Builder
    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    protected Team() {}
}
