import G_CLI.Gcli;
import G_FS.*;

public class Main {
    public static void main(String[] args) {

        Gxplorer explorer = new Gxplorer();

        explorer.addFile("/","file_1",10);
        explorer.addFile("/","file_2",20);

        explorer.addDir("/","dir_a");
        explorer.addFile("dir_a","file_a1",30);
        explorer.addFile("dir_a","file_a2",40);

        explorer.addDir("/","dir_b");
        explorer.addFile("dir_b","file_b1",30);
        explorer.addFile("dir_b","file_b2",40);

        explorer.addDir("dir_b","dir_ba");
        explorer.addFile("dir_ba","file_ba1",30);
        explorer.addFile("dir_ba","file_ba2",40);
        explorer.addFile("dir_ba","file_ba3",40);
        explorer.addFile("dir_ba","file_ba4",40);

        explorer.addDir("/","dir_c");
        explorer.addDir("dir_c","dir_ca");
        explorer.addDir("dir_c","dir_cb");
        explorer.addFile("dir_ca","file_ca1",30);
        explorer.addFile("dir_cb","file_cb1",40);

        System.out.println("Printing entire file system starting from the root");
        explorer.showFileSystem();

        System.out.println();

        System.out.println("Deleting '/file_2'");
        explorer.delete("file_2");

        System.out.println("Deleting '/dir_c'");
        explorer.delete("dir_c");

        System.out.println();

        System.out.println("Printing entire file system starting from the root");
        explorer.showFileSystem();

    }
}
