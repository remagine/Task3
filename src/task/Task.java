package task;

import tag.Tag;

import java.util.Objects;

public class Task {
    private final Tag tag;
    private boolean isUsable;

    public Task(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return Objects.equals(tag, task.tag);
    }

    @Override
    public int hashCode() {
        return tag != null ? tag.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tag=" + tag +
                '}';
    }
}
