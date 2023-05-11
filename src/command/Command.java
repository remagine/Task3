package command;

import tag.Tag;

public enum Command {
    CREATE("create"), EXECUTE("execute");

    private final String commandName;

    Command(String commandName) {
        this.commandName = commandName;
    }

    private String getCommandName() {
        return commandName;
    }

    public static Command from(String value) {
        for (Command command : Command.values()) {
            if (command.getCommandName().equalsIgnoreCase(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid commandName : " + value);
    }
}