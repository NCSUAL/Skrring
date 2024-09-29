package SpringProblem.dto.request;

import SpringProblem.entity.Manage;

public record RegisterMemberRequestDto (String name, String teamName, Manage manage, String birthday, String workStartDate) {}
