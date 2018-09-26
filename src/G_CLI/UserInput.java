package G_CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple user input that handles user commands from the cli
 */
class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public String command = "";
    public String[] args;

    public void read() {
        this.args = new String[]{};
        String raw;
        raw = this.scanner.nextLine().trim();
        ArrayList<String> split = new ArrayList<>(Arrays.asList(raw.split(" +")));

        this.command = split.get(0);
        split.remove(0);

        if(split.size() > 0)
            this.args = split.toArray(this.args);
    }
}
