public class OffByN implements CharacterComparator{

    private int offset;

    public OffByN(int n) {
        offset = n;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff = Math.abs(x - y);
        if (diff == offset)
            return true;
        else
            return false;
    }
}
