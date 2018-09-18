import java.util.Date;

public class BaseFsItem {

    protected String name; // Should i trim over 32 chars?
    private Date creationDate;

    public BaseFsItem(String name) {
        System.out.println("BasesFsItem constructor");
        this.name = name;
        this.creationDate = new Date();
    }
}
