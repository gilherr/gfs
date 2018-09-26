package G_CLI;

public enum Error {
    MISSING_OPS_ADD_DIR("addDir: missing operands: addDir <parentName> <name>"),
    MISSING_OPS_ADD_FILE("addFile: missing operands: addFile <parentName> <name> <size>"),
    MISSING_OPS_DELETE("delete: missing operands: delete <name>");

    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
