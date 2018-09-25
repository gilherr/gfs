package G_FS;

public enum Error {
    DELETE_ROOT("Cant delete root folder"),
    ITEM_NOT_DIRECTORY("Item is not a directory"),
    ITEM_NOT_FOUND("Item not found"),
    ;

    private final String msg;

    private Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
