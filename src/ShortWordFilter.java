public class ShortWordFilter implements Main.Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            return ((String) x).length() < 5;
        }
        return false;
    }
}
