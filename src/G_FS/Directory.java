package G_FS;

import java.util.LinkedList;

public class Directory extends BaseFsItem{

    private LinkedList<BaseFsItem> content = new LinkedList<>();
    private double size = 0;
    private int itemsCount = 0;

    public Directory(String name) {
        super(name);
    }

    public void printContent(Boolean isRecursive){
        Directory.printContentRecursively(this, 0, isRecursive);
    }

    public void addItem(BaseFsItem newItem){
        this.content.add(newItem);
    }

    @Override
    public String toString() {
        return super.name;
    }

    /**
     * Find an item in a directory
     * @param dir The directory to start the search from
     * @param name The name of the item that is being searched
     * @param isRecursive Recursively search sub-directories
     * @return BaseFsItem if item was found, else null
     */
    public static BaseFsItem find(Directory dir,String name, Boolean isRecursive){

        for(BaseFsItem item: dir.content){
            if(item.name.equals(name)){
                return item;
            }
            else if(isRecursive && item instanceof Directory){
                BaseFsItem searchResult = Directory.find((Directory) item, name, true);
                if (searchResult != null)
                    return searchResult;
            }
        }
        return null;
    }

    public BaseFsItem findInCurrentDir(String name){
        return Directory.find(this,name,false);
    }

    private static void printContentRecursively(Directory dir, int indent, Boolean isRecursive){
        for(BaseFsItem item: dir.content){
            for(int i=0; i<indent*2; i++)
                System.out.print("-");
            item.print();
            if(isRecursive && item instanceof Directory){
                printContentRecursively((Directory) item, ++indent, isRecursive);
                indent--;
            }

        }
    }

    public void delete(BaseFsItem item){

        if(item.name.equals("/")){
            System.out.println(Error.DELETE_ROOT);
            return;
        }

        this.content.remove(item);
    }

}
