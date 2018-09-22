package G_CLI;

import G_FS.Directory;
import G_FS.File;

import java.util.HashMap;
import java.util.Map;

interface Command {
    void run(String[] args);
}

public class Gcli {

    private Map<String, Command> commands;
    private Directory root = new Directory("","/");
    private Directory currentDir = root;

    public void activate(){

        printWelcomeMessage();
        buildCommandsMap();

        UserInput userInput = new UserInput();
        boolean userDidntQuit = true;

        while(userDidntQuit){
            printPrompt();
            userInput.read();
            executeCommand(userInput);
            userDidntQuit = !userInput.command.equals("exit");
        }

    }

    private void executeCommand(UserInput ui) {
        if(commandAvailable(ui.command))
            this.commands.get(ui.command).run(ui.args);
        else
            System.out.println("gfs: command not found: " + ui.command);
    }

    private void printPrompt() {
        System.out.print(this.currentDir.getFullPath() + " $ ");
    }

    private void printWelcomeMessage() {
        System.out.print("\nWelcome to Giler's File System!\n\n");
        printHelp(null);
    }

    private Boolean commandAvailable(String command){
        return this.commands.containsKey(command);
    }

    private void buildCommandsMap(){
        this.commands = new HashMap<>();

        // cli commands
        this.commands.put(""        , (String[] args) -> {});
        this.commands.put("help"    , this::printHelp);
        this.commands.put("cd"      , this::changeDir);
        this.commands.put("exit"    , (String[] args) -> {});

        // fs commands
        this.commands.put("addFile" , (String[] args) -> System.out.println("addFile"));
        this.commands.put("touch"   , (String[] args) -> System.out.println("addFile"));

        this.commands.put("addDir"  , (String[] args) -> System.out.println("addDir"));
        this.commands.put("mkdir"   , (String[] args) -> System.out.println("addDir"));

        this.commands.put("delete"  , (String[] args) -> System.out.println("delete"));
        this.commands.put("rm"      , (String[] args) -> System.out.println("delete"));

        this.commands.put("ls"      , (String[] args) -> System.out.println("showFileSystem"));
        this.commands.put("showFileSystem", (String[] args) -> System.out.println("showFileSystem"));
    }

    private void changeDir(String[] args) {
        if(args[0].equals("..")){
            if(this.currentDir.getName().equals("/"))
                return;
            if(this.currentDir.getPath().equals("/")){
                this.currentDir = this.root;
                return;
            }
            this.root.findOnPath(this.currentDir.getPath());
            this.currentDir = this.currentDir.getParent();
            return;
        }

        Directory targetDir = this.currentDir.find(args[0]);
        if(targetDir != null)
            this.currentDir = targetDir;
        else
            System.out.println("Directory not found");
    }

    private void printHelp(String[] args){

        System.out.print("\nCommands:\n" +
                " help                 This help message\n" +
                " addFile, touch       Add a new file under the Directory branch\n" +
                " addDir, mkdir        Add a new Directory under the parent Directory\n" +
                " delete, rm           Delete the Directory or the file with this name\n" +
                " showFileSystem, ls   Display all files & directories with their hierarchical structure\n\n" +
                "Arguments should not contain spaces\n\n");
    }
}