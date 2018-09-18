package G_FS;

public class File extends BaseFsItem {

    private float size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%4.2f %s", this.size, this.name);
    }
}
