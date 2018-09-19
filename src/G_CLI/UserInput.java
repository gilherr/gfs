package G_CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public String command = "";
    public String[] args = {};

    public void read() {
        String raw;
        raw = this.scanner.nextLine().trim();
        ArrayList<String> split = new ArrayList<>(Arrays.asList(raw.split(" +")));

        this.command = split.get(0);
        split.remove(0);

        if(split.size() > 1)
            this.args = split.toArray(this.args);
    }
}
