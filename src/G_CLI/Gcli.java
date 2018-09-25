package G_CLI;

import G_FS.ExplorerCli;
import G_FS.GxplorerForCli;

import java.util.HashMap;
import java.util.Map;

public class Gcli {

    private Map<String, Command> commands;
    private ExplorerCli explorer = new GxplorerForCli();

    public void activate(){

        printWelcomeMessage();
        buildCommandsMap();
        buildMockFolderTree();

        UserInput userInput = new UserInput();
        boolean userDidntQuit = true;

        while(userDidntQuit){
            printPrompt();
            userInput.read();
            executeCommand(userInput);
            userDidntQuit = !userInput.command.equals("exit");
        }

    }

    private void buildMockFolderTree() {
        this.explorer.addFile("/","file_1",10);
        this.explorer.addFile("/","file_2",20);

        this.explorer.addDir("/","dir_b");
        this.explorer.addFile("dir_b","file_b1",30);
        this.explorer.addFile("dir_b","file_b2",40);

        this.explorer.addDir("/","dir_a");
        this.explorer.addDir("dir_a","dir_b");
        this.explorer.addDir("dir_b","dir_c");
        this.explorer.addDir("dir_c","dir_d");
        this.explorer.addFile("dir_c","file_c1",40);
        this.explorer.addFile("dir_c","file_c2",40);

        this.explorer.setCurrentDirGlobal("/");
    }

    private void executeCommand(UserInput ui) {
        if(commandAvailable(ui.command))
            this.commands.get(ui.command).run(ui.args);
        else
            System.out.println("gfs: command not found: " + ui.command);
    }

    private void printPrompt() {
        String curPath = this.explorer.getCurrentDirPath();
        System.out.print(curPath + " $ ");
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
        this.commands.put("exit"    , (String[] args) -> {});
        this.commands.put("help"    , this::printHelp);
        this.commands.put("pwd"     , this::printPath);
        this.commands.put("cd"      , this::changeDir);
        this.commands.put("rm"      , this::deleteFromCurrentDirectory);
        this.commands.put("ls"      , this::listCurrentFolder);
        this.commands.put("ll"      , this::showFileSystem);

        // fs commands
        this.commands.put("addFile" , this::addFile);
        this.commands.put("addDir"  , this::addDir);
        this.commands.put("delete"  , this::delete);
        this.commands.put("showFileSystem", this::showFileSystem);
    }

    private void listCurrentFolder(String[] args) {
        this.explorer.listCurrentFolder();
    }

    private void changeDir(String[] args) {
        if(args.length == 0)
            this.explorer.setCurrentDirGlobal("/");
        else if(args[0].equals(".."))
            this.explorer.changeDirOneStepUp();
        else
            this.explorer.setCurrentDirGlobal(args[0]);

    }

    private void printPath(String[] args) {
        //TODO write this function
        System.out.println("path...");
    }

    private void showFileSystem(String[] args){
        this.explorer.showFileSystem();
    }

    private void addFile(String[] args){
        if(args.length < 3){
            System.out.println(Error.MISSING_OPS_ADD_FILE);
            return;
        }
        String parentName = args[0];
        String name = args[1];
        int size = Integer.parseInt(args[2]);
        this.explorer.addFile(parentName, name, size);
    }

    private void addDir(String[] args){
        if(args.length < 2){
            System.out.println(Error.MISSING_OPS_ADD_DIR);
            return;
        }
        String parentName = args[0];
        String name = args[1];
        this.explorer.addDir(parentName, name);
    }

    private void delete(String[] args){
        if(args.length < 1){
            System.out.println(Error.MISSING_OPS_DELETE);
            return;
        }
        String name = args[0];
        this.explorer.delete(name);
    }

    private void deleteFromCurrentDirectory(String[] args){
        if(args.length < 1){
            System.out.println(Error.MISSING_OPS_DELETE);
            return;
        }
        String name = args[0];
        this.explorer.deleteFromCurrentDirectory(name);
    }

    private void printHelp(String[] args){

        System.out.print("\nCommands:\n" +
            " help                                  This help message\n" +
            " addFile <parentName> <name> <size>    Add a new file under the Directory branch\n" +
            " addDir  <parentName> <name>           Add a new Directory under the parent Directory\n" +
            " delete  <name>                        Delete an item found somewhere in the file system\n" +
            " showFileSystem                        List all files & directories with their hierarchical structure\n" +
            " rm                                    Delete an item found in current folder with this name\n" +
            " ls                                    List current directory\n" +
            "\n" +
            "Arguments should not contain spaces\n\n");

    }
}