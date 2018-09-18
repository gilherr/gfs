package G_CLI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Command {
    void run(String[] args);
}

public class Gcli {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, Command> commands;

    public int activate(){

        String command = "";
        buildCommandsMap();

        System.out.print("\nWelcome to Giler's File System!\n\n");
        printHelp(null);

        while(!command.equals("exit")){
            System.out.print("$ ");
            command = readUserInput();
            if(commandAvailable(command))
                this.commands.get(command).run(new String[]{"arg1"});
            else
                System.out.println("gfs: command not found: " + command);
        }

        return 0;
    }

    private String readUserInput() {
        String raw;
        raw = this.scanner.nextLine().trim();
        String[] command = raw.split(" ");
        return command[0];
    }

    private Boolean commandAvailable(String command){
        return this.commands.containsKey(command);
    }

    private void buildCommandsMap(){
        this.commands = new HashMap<>();
        this.commands.put("help", this::printHelp);
        this.commands.put("addFile" , (String[] args) -> System.out.println("addFile"));
        this.commands.put("touch"   , (String[] args) -> System.out.println("addFile"));
        this.commands.put("addDir"  , (String[] args) -> System.out.println("addDir"));
        this.commands.put("mkdir"   , (String[] args) -> System.out.println("addDir"));
        this.commands.put("delete"  , (String[] args) -> System.out.println("delete"));
        this.commands.put("rm"      , (String[] args) -> System.out.println("delete"));
        this.commands.put("showFileSystem", (String[] args) -> System.out.println("showFileSystem"));
        this.commands.put("ls"      , (String[] args) -> System.out.println("showFileSystem"));
        this.commands.put("exit"    , (String[] args) -> {});
    }

    private void printHelp(String[] args){

        if(args != null && args.length > 0){
            System.out.println("DEBUG: Printing args:");
            for (String s: args) {
                System.out.println("DEBUG: " + s);
            }
        }

        System.out.print("\nCommands:\n" +
                " help                 This help message\n" +
                " addFile, touch       Add a new file under the Directory branch\n" +
                " addDir, mkdir        Add a new Directory under the parent Directory\n" +
                " delete, rm           Delete the Directory or the file with this name\n" +
                " showFileSystem, ls   Display all files & directories with their hierarchical structure\n\n");
    }
}