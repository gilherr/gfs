import G_CLI.Gcli;
import G_FS.ExplorerBasic;
import G_FS.Gxplorer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A user view that demonstrate the different operations of the file-system
 */
public class Demonstrator {

    static int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        boolean waitingForInput = true;
        String selection = "-1";

        System.out.println("Choose demonstration type:");
        System.out.println("    1: CLI - Run an interactive cli and control the file-system");
        System.out.println("    2: Basic Example - Run a demo that calls the required functions");
        System.out.println("                       addFile, addDir, delete, showFileSystem");

        while (waitingForInput) {

            selection = scanner.next().substring(0,1);
            if (selection.matches("[1|2]"))
                waitingForInput = false;
            else
                System.out.println("Select '1' or '2'");
        }

        return Integer.parseInt(selection);
    }

    static void runCliExplorer() {
        Gcli cli = new Gcli();
        cli.activate();
    }

    static void runBasicExplorer() {

        Scanner scanner = new Scanner(System.in);

        ExplorerBasic explorer = new Gxplorer();

        System.out.println("Starting basic demonstration, hit enter each step to continue");
        scanner.nextLine();

        System.out.println("Building a mock file system using the addFile and addDir methods");

        buildMockFileSystem(explorer);

        scanner.nextLine();

        System.out.println("Printing file system using showFileSystem method");
        System.out.println("starting from the root");
        scanner.nextLine();

        explorer.showFileSystem();

        System.out.println("Hit enter to continue");
        scanner.nextLine();

        System.out.println("Deleting '/file_2' using the delete method");
        System.out.println("Deleting '/dir_c' using the delete method");
        explorer.delete("file_2");
        explorer.delete("dir_c");

        System.out.println("\nPrinting file system after deletion");
        scanner.nextLine();

        explorer.showFileSystem();

        System.out.println("\nEnd of basic demonstration");
        scanner.nextLine();
    }

    static void buildMockFileSystem(ExplorerBasic explorer) {
        explorer.addFile("/", "file_1", 10);
        explorer.addFile("/", "file_2", 20);

        explorer.addDir("/", "dir_a");
        explorer.addFile("dir_a", "file_a1", 30);
        explorer.addFile("dir_a", "file_a2", 40);

        explorer.addDir("/", "dir_b");
        explorer.addFile("dir_b", "file_b1", 30);
        explorer.addFile("dir_b", "file_b2", 40);

        explorer.addDir("dir_b", "dir_ba");
        explorer.addFile("dir_ba", "file_ba1", 30);
        explorer.addFile("dir_ba", "file_ba2", 40);
        explorer.addFile("dir_ba", "file_ba3", 40);
        explorer.addFile("dir_ba", "file_ba4", 40);

        explorer.addDir("/", "dir_c");
        explorer.addDir("dir_c", "dir_ca");
        explorer.addDir("dir_c", "dir_cb");
        explorer.addFile("dir_ca", "file_ca1", 30);
        explorer.addFile("dir_cb", "file_cb1", 40);
    }

}
