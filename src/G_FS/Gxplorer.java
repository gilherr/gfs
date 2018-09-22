package G_FS;

public class Gxplorer implements Explorer{

    private Directory ground = new Directory("");
    private Directory currentDir = null;

    public Gxplorer() {
        this.ground.addItem(new Directory("/"));
    }

    public void setCurrentDir(String name){
        Directory foundDir = this.ground.findDir(name);
        if(foundDir != null)
            this.currentDir = foundDir;
        else
            System.out.println("Cant find " + name);
    }

    public String getCurrentDirPath(){
        return this.currentDir.getFullPath();
    }

    // Basic requested functions

    public void addFile (String parentDirName, String fileName, int fileSize){
        File file = new File(fileName, fileSize);
        Directory parent = this.ground.findDir(parentDirName);
        file.setParent(parent);
        parent.addItem(file);
    }

    public void addDir (String parentDirName, String dirName){
        Directory dir = new Directory(dirName);
        Directory parent = this.ground.findDir(parentDirName);
        if(parent != null){
            dir.setParent(parent);
            parent.addItem(dir);
        }
        else
            System.out.println("Cant find " + parentDirName);
    }

    public void delete (String name){

        Directory parent;
        BaseFsItem rmCandidate = Directory.find(this.ground, name, true);

        if(rmCandidate == null)
            System.out.println("Cant find " + name);
        else
            rmCandidate.parent.delete(rmCandidate);

    }

    public void showFileSystem (){
        this.ground.printContent(true);
    }

}
