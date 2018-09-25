package G_FS;

public interface ExplorerBasic {

    public void addFile (String parentDirName, String fileName, int fileSize);

    public void addDir (String parentDirName, String dirName);

    public void delete (String name);

    public void showFileSystem ();

}
