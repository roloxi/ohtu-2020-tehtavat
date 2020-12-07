package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public Matcher build() {
        Matcher m = matcher;
        this.matcher = new All();
        return m;
    }
    
    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String fieldName) {
        matcher = new And(matcher, new HasAtLeast(value, fieldName));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String fieldName) {
        matcher = new And(matcher, new HasFewerThan(value, fieldName));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matcher = new Or(m1, m2);
        return this;
    }
    
}
