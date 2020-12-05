package life.locura.aoc;
import life.locura.aoc.dayone.DayOne;

public class App {
    public static void main(String[] args) {

        try {
            DayOne dayOne = new DayOne(
                args[0]
            );
            int resultOne = dayOne.executePartOne();
            System.out.println("result one: " + resultOne);
            int resultTwo = dayOne.executePartTwo();
            System.out.println("result two: " + resultTwo);
        } catch(Exception e) {
            System.out.println(e);
        }
   
    }
}
