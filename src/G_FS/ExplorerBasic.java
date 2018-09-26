package G_FS;

public interface ExplorerBasic {

    void addFile(String parentDirName, String fileName, int fileSize);

    void addDir(String parentDirName, String dirName);

    void delete(String name);

    void showFileSystem();

}
