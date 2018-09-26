package G_FS;

/**
 * A controller that exposes the basic and cli-related operations to external packages.
 */
public class GxplorerForCli extends Gxplorer implements ExplorerCli {

    private Directory currentDir;

    public GxplorerForCli() {
        super();
        this.currentDir = (Directory) Directory.find(super.ground, "/", false);
    }

    /**
     * Find the requested directory in the entire file system and set it as currentDir.
     * @param name The requested directory to become currentDir
     */
    public void setCurrentDirGlobal(String name){
        BaseFsItem foundDir = Directory.find(super.ground, name, true);
        setFoundDir(foundDir);
    }

    public void changeDir(String name){
        BaseFsItem foundDir = this.currentDir.findInCurrentDir(name);
        setFoundDir(foundDir);
    }

    /**
     * Turns the parent of currentDir into the currentDir itself.
     */
    public void changeDirOneStepUp(){
        if(this.currentDir.parent != null)
            this.currentDir = this.currentDir.parent;
    }

    private void setFoundDir(BaseFsItem foundDir){

        if(foundDir instanceof Directory)
            this.currentDir = (Directory) foundDir;

        else if(foundDir instanceof File)
            System.out.println(Error.ITEM_NOT_DIRECTORY);
        else if(foundDir == null)
            System.out.println(Error.ITEM_NOT_FOUND);
    }

    public String getCurrentDirPath(){
        return this.currentDir.getFullPath();
    }

    public void listCurrentFolder(){
        this.currentDir.printContent(false);
    }

    public void deleteFromCurrentDirectory(String name) {

        BaseFsItem rmCandidate = this.currentDir.findInCurrentDir(name);

        if(rmCandidate == null)
            System.out.println("Cant find " + name);
        else
            rmCandidate.parent.delete(rmCandidate);


    }
}
