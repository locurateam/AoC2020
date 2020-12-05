package life.locura.aoc;
// import life.locura.aoc.dayone.DayOne;
import life.locura.aoc.daytwo.DayTwo;

public class App {
    public static void main(String[] args) {

        try {
            // DayOne dayOne = new DayOne(
            //     args[0]
            // );
            // int resultOne = dayOne.executePartOne();
            // System.out.println("result one: " + resultOne);
            // int resultTwo = dayOne.executePartTwo();
            // System.out.println("result two: " + resultTwo);
            DayTwo dayTwo = new DayTwo(
                args[0]
            );
            long resultOne = dayTwo.executePartOne();
            System.out.println("result one: " + resultOne);
        } catch(Exception e) {
            System.out.println(e);
        }
   
    }
}
