package G_FS;

public class Gxplorer implements ExplorerBasic {

    Directory ground = new Directory("");

    public Gxplorer() {
        this.ground.addItem(new Directory("/"));
    }

    public void addFile (String parentDirName, String fileName, int fileSize){
        File newFile = new File(fileName, fileSize);
        addItem(newFile, parentDirName);
    }

    public void addDir (String parentDirName, String dirName){
        Directory newDir = new Directory(dirName);
        addItem(newDir, parentDirName);
    }

    public void delete (String name){

        BaseFsItem rmCandidate = Directory.find(this.ground, name, true);

        if(rmCandidate == null)
            System.out.println("Cant find " + name);
        else
            rmCandidate.parent.delete(rmCandidate);

    }

    public void showFileSystem (){
        this.ground.printContent(true);
    }

    /*************************************************/

    private void addItem(BaseFsItem item, String parentDirName){
        Directory parent;

        if(isItemExists(item.name)) {
            System.out.println(Error.ITEM_EXISTS);
            return;
        }

        BaseFsItem foundItem = Directory.find(this.ground, parentDirName, true);
        Directory foundDir = validateFoundDirectory(foundItem, parentDirName);

        if(foundDir != null){
            parent = foundDir;
            item.setParent(parent);
            parent.addItem(item);
        }
    }

    private Directory validateFoundDirectory(BaseFsItem foundItem, String searchWord){
        if(foundItem instanceof Directory)
            return (Directory) foundItem;
        else if(foundItem instanceof File)
            System.out.println("error: " + searchWord + " is a file");
        else
            System.out.println("error: Cant find " + searchWord);
        return null;
    }

    private Boolean isItemExists(String itemName) {
        return Directory.find(this.ground,itemName,true) != null ? true : false;
    }

}
