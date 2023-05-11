
import command.Command;
import tag.Tag;
import commandandtag.CommandAndTag;
import task.Task;
import task.TaskService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = TaskService.getInstance();
        String inputString =
                """
                21
                create
                create
                create
                create
                execute 11
                create
                create
                create
                create
                create
                create
                execute 2
                create
                execute 2
                execute 11
                execute 2
                execute 5
                execute 5
                execute 2
                execute 5
                execute 5""";
        byte[] bytes = inputString.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedInputStream bis = new BufferedInputStream(inputStream, 8192);
        InputStreamReader isr = new InputStreamReader(bis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr, 8192);
        try(inputStream;
            bis;
            isr;
            br;){

            int executeCnt = Integer.parseInt(br.readLine());
            List<String> lines = new ArrayList<>();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                lines.add(line);
            }

            for (int i = 0; i < executeCnt; i++) {
                String line = lines.get(i);
                String[] argArray = line.split(" ");
                Command command = Command.from(argArray[0]);
                Tag tag = null;

                if (argArray.length == 2) {
                    tag = Tag.from(argArray[1]);
                }

                CommandAndTag commandAndTag = new CommandAndTag(command, tag);
                taskService.doTask(commandAndTag);
            }

            //출력
            taskService.printTaskHistory();













        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}