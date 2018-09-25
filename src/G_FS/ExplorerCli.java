package G_FS;

public interface ExplorerCli extends ExplorerBasic {

    public void setCurrentDirGlobal(String name);

    public void changeDir(String name);

    public String getCurrentDirPath();

    public void listCurrentFolder();

    public void deleteFromCurrentDirectory(String name);

    public void changeDirOneStepUp();
}
