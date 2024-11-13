package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PullRequestPayload {
    String action;
    PullRequest pull_request;
    Repository repository;
}
