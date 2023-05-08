package task;

import command.Command;
import tag.Tag;

public class Task {
    private final Tag tag;
    private final Command command;

    public Task(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public Task fromInputString(String inputString) {
        String[] inputArray = inputString.split(" ");
        String commandStr = inputArray[0];
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
