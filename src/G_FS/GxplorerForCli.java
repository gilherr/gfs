package G_FS;

public class GxplorerForCli extends Gxplorer implements ExplorerCli {

    private Directory currentDir;

    public GxplorerForCli() {
        super();
        this.currentDir = (Directory) Directory.find(super.ground, "/", false);
    }

    public void setCurrentDirGlobal(String name){
        BaseFsItem foundDir = Directory.find(super.ground, name, true);
        setFoundDir(foundDir);
    }

    public void changeDir(String name){
        BaseFsItem foundDir = this.currentDir.findInCurrentDir(name);
        setFoundDir(foundDir);
    }

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
