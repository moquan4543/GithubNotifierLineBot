package dev.github.notifier;

import dev.github.notifier.data.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static dev.github.notifier.ParseRequestBody.parsePush;
import static dev.github.notifier.ParseRequestBody.parsePullRequest;
@SpringBootTest
public class ParseRequestBodyTests {

    final private PushPayload pushPayload = new PushPayload(
            new ArrayList<>(List.of(new Commits("test push message", "2024-11-23T15:37:15+00:00"))),
            "fake://compareURL",
            new GithubUser("Test User","testuser@mail.com"),
            new Repository("test repo name","fake://repoURL")
    );
    final private PullRequestPayload pullRequestPayload = new PullRequestPayload(
        "Pull request action",
            new PullRequest("fake://pullRequestURL","test PR title", "test PR body"),
            new Repository("test repo name","fake://repoURL")
    );

    @Test
    @DisplayName("should return detail info of push when push webhook has been trigger")
    void shouldReturnPushInfoMessage(){
        assertThat(parsePush(pushPayload))
                .contains("[Github Notifier]")
                .contains("Test User")
                .contains("pushed a new version at")
                .contains("test repo name")
                .contains("test push message");
    }
    @Test
    @DisplayName("should return detail info of pull request when PR webhook has been trigger")
    void shouldReturnPullRequestInfoMessage(){
        assertThat(parsePullRequest(pullRequestPayload))
                .contains("[Github Notifier]")
                .contains("test repo name")
                .contains("test PR title")
                .contains("test PR body")
                .contains("fake://repoURL")
                .contains("fake://pullRequestURL");
    }
}
