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

    private static void printContentRecursively(Directory dir, int depth, Boolean isRecursive){
        for(BaseFsItem item: dir.content){
            for(int i=0; i<depth*2; i++)
                System.out.print("-");
            item.print();
            if(isRecursive && item instanceof Directory){
                printContentRecursively((Directory) item, ++depth, isRecursive);
                depth--;
            }

        }
    }

    public Directory findDir(String name){
        BaseFsItem foundItem = find(this,name,true);
        if(foundItem instanceof Directory)
            return (Directory) foundItem;
        else
            return null;
    }

    public void delete(BaseFsItem item){

        if(item.name.equals("/")){
            System.out.println("Cant delete root folder.");
            return;
        }

        // should be implemented in the cli
        /*
        if(item instanceof Directory && ((Directory) item).content.size() > 0){
            System.out.println("Folder is not empty, delete aborted");
            return;
        }
        */
        this.content.remove(item);
    }

}
