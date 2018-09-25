package G_FS;

public interface Explorer {

    public void addFile (String parentDirName, String fileName, int fileSize);

    public void addDir (String parentDirName, String dirName);

    public void delete (String name);

    public void showFileSystem ();

    public void setCurrentDir(String name);

    public String getCurrentDirPath();

    public void listCurrentFolder();

}
