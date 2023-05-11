package task;

import tag.Tag;

public class Task {
    private final Tag tag;
    private static int executeFailCnt;

    public Task(Tag tag) {
        this.tag = tag;
    }
}
