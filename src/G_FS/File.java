package G_FS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class File extends BaseFsItem {

    private double size;

    public File(String name, double size) {
        super(name);
        this.size = size;
    }

    public void print(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d HH:mm");
        System.out.println(super.name + " " + this.size + "K " + dateFormat.format(super.creationDate));
    }

    @Override
    public String toString() {
        return super.name;
    }
}
