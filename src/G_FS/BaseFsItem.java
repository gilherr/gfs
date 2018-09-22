package G_FS;

import java.util.Date;

public class BaseFsItem {

     String name;
     Date creationDate;
     Directory parent = null;

    public BaseFsItem(String name) {
        this.name = name.length() <= 32 ? name : name.substring(0,32);
        this.creationDate = new Date();
    }

    public void setParent(Directory parent) {
        this.parent = parent;
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
