package G_FS;

public interface ExplorerCli extends ExplorerBasic {

    void setCurrentDirGlobal(String name);

    void changeDir(String name);

    String getCurrentDirPath();

    void listCurrentFolder();

    void deleteFromCurrentDirectory(String name);

    void changeDirOneStepUp();
}
