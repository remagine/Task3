package command;

public enum Command {
    CREATE("create"), EXECUTE("execute");

    private final String commandName;

    Command(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Command fromString(String value) {
        for (Command command : Command.values()) {
            if (command.getCommandName().equalsIgnoreCase(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid commandName : " + value);
    }
}