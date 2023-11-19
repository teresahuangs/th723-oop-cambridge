interface CharOperation {
    void apply(char[] chars, int i, int j);
}

class Swapper extends Reader {
    private final PushbackReader pushBack;
    private final CharOperation charOperation;

    Swapper(Reader reader, CharOperation charOperation) {
        pushBack = new PushbackReader(reader);
        this.charOperation = charOperation;
    }

    private void swap(char[] cbuf, int i, int j) {
        charOperation.apply(cbuf, i, j);
    }
}
