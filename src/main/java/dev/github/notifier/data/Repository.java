package dev.github.notifier.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Repository {
    String full_name;
    String url;
}
