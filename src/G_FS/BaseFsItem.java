package G_FS;

import java.util.Date;

public class BaseFsItem {

    protected String name; // Should i trim over 32 chars?
    private Date creationDate;

    public BaseFsItem(String name) {
        this.name = name;
        this.creationDate = new Date();
    }
}
