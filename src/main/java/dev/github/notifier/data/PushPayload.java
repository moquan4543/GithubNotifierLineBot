package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class PushPayload {
    ArrayList<Commits> commits;
    String compare;
    GithubUser pusher;
    Repository repository;
}
