package G_FS;

public class Gxplorer{

    private Directory ground = new Directory("");

    public Gxplorer() {
        this.ground.addItem(new Directory("/"));
    }

    public void addFile (String parentDirName, String fileName, int fileSize){
        File file = new File(fileName, fileSize);
        Directory parent = this.ground.findDir(parentDirName);
        file.setParent(parent);
        parent.addItem(file);
    }

    public void addDir (String parentDirName, String dirName){
        Directory dir = new Directory(dirName);
        Directory parent = this.ground.findDir(parentDirName);
        dir.setParent(parent);
        parent.addItem(dir);
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
