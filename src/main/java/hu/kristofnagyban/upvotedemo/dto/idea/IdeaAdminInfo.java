package hu.kristofnagyban.upvotedemo.dto.idea;

import lombok.Data;

@Data
public class IdeaAdminInfo {

    private Long id;
    private String description;
    private boolean approved;
    private int votes;
}
