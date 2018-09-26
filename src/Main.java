public class Main {

    public static void main(String[] args) {

        int BASIC = 1, CLI = 2;
        int selection = Demonstrator.getUserInput();

        if(selection == BASIC)
            Demonstrator.runBasicExplorer();

        else if(selection == CLI)
            Demonstrator.runCliExplorer();

    }

}
