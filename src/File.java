public class File extends BaseFsItem {
    private long size;

    public File(String name, long size) {
        super(name);
        System.out.println("File constructor");
        this.size = size;
    }

    @Override
    public String toString() {
        return this.name + this.size;
    }
}
