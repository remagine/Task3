package tag;

public class Tag implements Comparable{
    private final int id;

    public Tag(int id) {
        this.id = id;
    }

    public static Tag fromString(String s) {
        try{
            return new Tag(Integer.parseInt(s));
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
