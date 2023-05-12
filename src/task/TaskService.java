package task;

import command.Command;
import commandandtag.CommandAndTag;
import tag.Tag;
import tag.TagHistory;

import java.util.*;

public class TaskService {
    private static final TaskService taskService = new TaskService();
    private static final HashSet<Task> tasks = new HashSet<>(); // 검색에 유리
    private static final TreeSet<Tag> emptyTags = new TreeSet<>();  // 최소값을 빠르게 가져오기 위해 TreeSet
    private static final Map<Tag, TagHistory> tagHistoryMap = new TreeMap<>(); // 조회는 쉬운데 정렬은 안되네
    private static final TreeSet<TagHistory> tagHistories = new TreeSet<>(); // 조회는 어려운데 정렬은 원하는대로 되네
    /*private static final List<TagHistory> tagHistoryList = new ArrayList<>();
    private static final Set<TagHistory> tagHistorySet = new HashSet<>();
    private static final TreeSet<TagHistory> tagHistories = new TreeSet<>();*/
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
            Task task = new Task(tag);
            if (!tasks.contains(task)) {
                throw new NoSuchElementException("Task is none , Tag : " + tag);
            }
            tasks.remove(task);
            emptyTags.add(tag);
        } catch (Exception e) {
            TagHistory tagHistory = new TagHistory(tag);
            if (!tagHistories.contains(tagHistory)) {
                tagHistories.remove(tagHistory);
                tagHistory = new TagHistory(tag, 1);
            } else {
                tagHistory = tagHistories.ceiling(tagHistory);
                tagHistory.addFailCnt();
                tagHistories.add(tagHistory);
            }
            tagHistories.add(tagHistory);
        }
    }

    public void printTaskHistory() {
        System.out.println("사용가능한 Tag: " + emptyTags);
        System.out.println("TASK 생성 실패: " + createFailCnt);
        System.out.println("TASK 수행 실패한 태그: " + tagHistories);



    }
}