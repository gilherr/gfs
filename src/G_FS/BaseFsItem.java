package G_FS;

import java.util.Date;

/**
 * Describes the basics of any item on the file system.
 */
public class BaseFsItem {

     String name;
     Date creationDate;
     Directory parent = null;

    BaseFsItem(String name) {
        this.name = name.length() <= 32 ? name : name.substring(0,32);
        this.creationDate = new Date();
    }

    void setParent(Directory parent) {
        this.parent = parent;
    }

    String getFullPath(){
        if(this.name.equals("/")) return "/";
        return getFullPathRecursive(this, "");
    }

    private String getFullPathRecursive(BaseFsItem item, String path){
        if(item.name.equals("/"))
            return "";
        String ret = getFullPathRecursive(item.parent, path);
        return ret + "/" + item.name;
    }

    public Directory getParent(){
        return this.parent;
    }

    public String getName(){
        return this.name;
    }

     void print() {
        System.out.println(this.name);
    }

}
