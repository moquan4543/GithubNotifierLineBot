package dev.github.notifier;

import dev.github.notifier.data.Commits;
import dev.github.notifier.data.PullRequestPayload;
import dev.github.notifier.data.PushPayload;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ParseRequestBody {
    public static String parsePush(PushPayload payload){
        String commitsMsg = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        for(Commits commit : payload.getCommits()){
            OffsetDateTime time = OffsetDateTime.parse(commit.getTimestamp());
            commitsMsg = commitsMsg.concat("\n"+commit.getMessage() + "\n" + time.format(formatter));
        }

        return "\uD83D\uDD14[Github Notifier]\uD83D\uDD14\n\uD83C\uDD95"
                + payload.getPusher().getName()
                + " (" + payload.getPusher().getEmail() + ") "
                + "pushed a new version at "
                + payload.getRepository().getFull_name()
                + " ("+payload.getRepository().getUrl()+")"
                + "\n\n\uD83D\uDCCCCommits:" + commitsMsg
                + "\n\n\uD83D\uDCCCSee diff at:\n"+payload.getCompare();
    }
    public static String parsePullRequest(PullRequestPayload payload){
        return "\uD83D\uDD14[Github Notifier]\uD83D\uDD14\n\uD83C\uDD95"
                + "Pull Request update detected at "
                + payload.getRepository().getFull_name()
                + " (" + payload.getRepository().getUrl() +")\n"
                + "\uD83D\uDCCCAction: " + payload.getAction()
                +"\n\n\uD83D\uDCCCPR Title: "
                + payload.getPull_request().getTitle()
                + "\n\n\uD83D\uDCAC"
                + payload.getPull_request().getBody()
                +"\n\n\uD83D\uDCCCSee at: " + payload.getPull_request().getUrl();
    }
}
