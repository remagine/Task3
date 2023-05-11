package task;

import command.Command;
import commandandtag.CommandAndTag;
import tag.Tag;

import java.util.*;

public class TaskService {
    private static final TaskService taskService = new TaskService();
    private static final HashSet<Task> tasks = new HashSet<>();
    private static final TreeSet<Tag> emptyTags = new TreeSet<>();
    private static int createFailCnt = 0;

    static {
        for (int i = 1; i <= 9; i++) {
            emptyTags.add(new Tag(i));
        }


    }

    private TaskService() {
    }

    public static TaskService getInstance() {
        return taskService;
    }

    public void doTask(CommandAndTag commandAndTag) {
        Command command = commandAndTag.getCommand();
        if (command.equals(Command.CREATE)) {
            create();
        }

        if (command.equals(Command.EXECUTE)) {
            Optional<Tag> tag = commandAndTag.getTag();
            tag.ifPresent(this::execute);
        }
    }

    private void create() {
        try {
            Tag tag = emptyTags.pollFirst();
            if (tag == null) {
                throw new NoSuchElementException("No more tags available.");
            }
            tasks.add(new Task(tag));
        } catch (Exception e) {


            createFailCnt++;
        }
    }

    private void execute(Tag tag) {
        try {

        } catch (Exception e) {
            tag.addExecuteFailCnt();
        }


    }
}
