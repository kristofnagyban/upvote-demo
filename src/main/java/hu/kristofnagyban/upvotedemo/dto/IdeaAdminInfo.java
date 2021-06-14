package hu.kristofnagyban.upvotedemo.dto;

import lombok.Data;

@Data
public class IdeaAdminInfo {

    private Long id;
    private String description;
    private boolean approved;
    private int votes;
}
