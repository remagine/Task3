import command.Command;
import tag.Tag;
import task.Task;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        // 입력을 받는다. io처리 3요소를 고려하여 처리한다.
        // 인코딩, 버퍼처리, 자원의해제
        // 인코딩 : 어떤 보조스트림으로 인코딩처리를 강제할 것인가
        // 버퍼처리 : 어떤 크기로 스트림을 분할처리할 것인가
        // 자원의해제 : with , finally close 어떤 방식으로 자원을 반납할것인가
        byte[] bytes = inputString.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedInputStream bis = new BufferedInputStream(inputStream, 8192);
        InputStreamReader isr = new InputStreamReader(bis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr, 8192);
        try(inputStream;
            bis;
            isr;
            br;){
            // 입력이 유효한지 검증한다. 입력 요구사항(맥락)에 맞는지 체크한다.
            // 1. 첫번째 라인은 명령라인의 갯수 (int)
            int executeCnt = Integer.parseInt(br.readLine()); // 정수가 아니면 예외발생
            // 2. 나머지 라인은 명령라인배열 (배열)
            List<String> lines = new ArrayList<>();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                lines.add(line);
            }

            // 처리횟수만큼 반복한다
            // 무엇을? 처리 컨텍스트의 입력으로 변환하는 작업을 의미한다.
            // 처리 컨텍스트의 입력은 Enum : Command와 Class : Tag
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < executeCnt; i++) {
                String line = lines.get(i);
                String[] argArray = line.split(" ");
                Command command = Command.fromString(argArray[0]);
                Tag tag = null;
                if (argArray.length == 2) {
                    tag = Tag.fromString(argArray[1]);
                }

                tasks.add(new Task(command, tag));
            }








        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}