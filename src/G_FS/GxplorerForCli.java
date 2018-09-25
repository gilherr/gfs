package G_FS;

public class GxplorerForCli extends Gxplorer {

    private Directory currentDir = null;

    public GxplorerForCli() {
        super();
        this.currentDir = (Directory) Directory.find(super.ground, "/", false);
    }

    public void setCurrentDir(String name){
        BaseFsItem foundDir = this.currentDir.find(name);
        if(foundDir instanceof Directory)
            this.currentDir = (Directory) foundDir;
    }

    public String getCurrentDirPath(){
        return this.currentDir.getFullPath();
    }

    public void listCurrentFolder(){
        this.currentDir.printContent(false);
    }
}
