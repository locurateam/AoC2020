package life.locura.aoc.dayone;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Collections;


public class DayOne {

    private String filePath;
    private List<Integer> inputPayload;

    public DayOne(String filePath) throws IOException {
        this.filePath = filePath;
        this.readInputContent();
        Collections.sort(this.inputPayload);
    }

    public int executePartOne()  {
        int result = -1;
        for(int i : this.inputPayload){
            int index = Collections.binarySearch(this.inputPayload, 2020 - i);
            if (index >= 0) {
                result = i * (2020 - i);
                break;
            }
        }
        return result;
    }

    public int executePartTwo()  {
        int result = -1;
        for(int i : this.inputPayload){
        for(int j : this.inputPayload){
            int index = Collections.binarySearch(this.inputPayload, 2020 - i - j);
                if (index >= 0) {
                    result = i * j * (2020 - i - j);
                    break;
                }
            }
        }
        return result;
    }

    private void readInputContent() throws IOException {
        Path filePath = Path.of(this.filePath);
        List<String> rawPayload = Files.readAllLines(filePath);
        this.inputPayload = rawPayload.stream().map(l -> Integer.parseInt(l)).collect(Collectors.toCollection(ArrayList::new));
    }
}
