package hu.kristofnagyban.upvotedemo.dto.idea;

import lombok.Data;

@Data
public class IdeaBasicInfo {

    private Long id;
    private String description;

    public IdeaBasicInfo() {
    }

    public IdeaBasicInfo(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
