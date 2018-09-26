public class Main {

    public static void main(String[] args) {

        int CLI = 1, BASIC = 2;
        int selection = Demonstrator.getUserInput();

        if(selection == BASIC)
            Demonstrator.runBasicExplorer();

        else if(selection == CLI)
            Demonstrator.runCliExplorer();

    }

}
