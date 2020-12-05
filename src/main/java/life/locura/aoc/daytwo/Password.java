package life.locura.aoc.daytwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private int lowerBound;
    private int upperBound;
    private int policyLetter;
    private String rawPassword;

    public static Password fromDbEntry(String row) throws Exception {
        Pattern r = Pattern.compile("(?<lowerBound>\\d+)-(?<upperBound>\\d+) (?<policyLetter>\\w): (?<password>\\w+)");

        Matcher m = r.matcher(row);
        if (!m.find()){
            throw new Exception("aaaaaaaaa");
        }
        int lowerBound = Integer.parseInt(m.group("lowerBound"));
        int upperBound = Integer.parseInt(m.group("upperBound"));
        int policyLetter = m.group("policyLetter").charAt(0);
        String password = m.group("password");

        return new Password(
            lowerBound,
            upperBound,
            policyLetter,
            password
        );
    }

    public Password(
        int lowerBound,
        int upperBound,
        int policyLetter,
        String rawPassword
    ){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.policyLetter = policyLetter;
        this.rawPassword = rawPassword;
    }

    public boolean isValid(){
        long count = this.rawPassword.chars().filter(ch -> ch == this.policyLetter).count();
        return count >= this.lowerBound && count <= this.upperBound;
    }
}
