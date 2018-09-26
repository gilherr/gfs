package G_FS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

class File extends BaseFsItem {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public void print(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d HH:mm");
        System.out.println(this.size + "K " + dateFormat.format(super.creationDate) + " " + super.name);
    }

    @Override
    public String toString() {
        return super.name;
    }
}
