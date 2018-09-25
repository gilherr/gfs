package G_FS;

public interface ExplorerCli extends ExplorerBasic {

    public void setCurrentDir(String name);

    public String getCurrentDirPath();

    public void listCurrentFolder();
}
