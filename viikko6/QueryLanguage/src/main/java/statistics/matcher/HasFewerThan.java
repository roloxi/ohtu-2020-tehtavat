package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {

    private int value;
    private String fieldName;

    public HasFewerThan(int value, String fieldName) {
        this.value = value;
        this.fieldName = fieldName;
    }
    
    @Override
    public boolean matches(Player p) {
        return new Not(new HasAtLeast(value, fieldName)).matches(p);
    }
    
}
