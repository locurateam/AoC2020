package life.locura.aoc.daytwo;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Collections;

import life.locura.aoc.daytwo.Password;


public class DayTwo {

    private String filePath;
    private List<Password> inputPayload;

    public DayTwo(String filePath) throws IOException, Exception {
        this.filePath = filePath;
        this.readInputContent();
    }

    public long executePartOne()  {
      return this.inputPayload.stream().filter(psw -> psw.isValid()).count();
    }

    // public int executePartTwo()  {
    //     int result = -1;
    //     for(int i : this.inputPayload){
    //     for(int j : this.inputPayload){
    //         int index = Collections.binarySearch(this.inputPayload, 2020 - i - j);
    //             if (index >= 0) {
    //                 result = i * j * (2020 - i - j);
    //                 break;
    //             }
    //         }
    //     }
    //     return result;
    // }

    private void readInputContent() throws IOException, Exception {
        Path filePath = Path.of(this.filePath);
        List<String> rawPayload = Files.readAllLines(filePath);
        this.inputPayload = rawPayload.stream().map(l -> {
            try {
                return Password.fromDbEntry(l);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}


