package commandandtag;

import command.Command;
import tag.Tag;

import java.util.Optional;

public class CommandAndTag {
    private final Tag tag;
    private final Command command;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public Optional<Tag> getTag() {
        return Optional.ofNullable(tag);
    }

    public Command getCommand() {
        return command;
    }
}
