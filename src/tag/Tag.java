package tag;

import java.util.Objects;

public class Tag implements Comparable<Tag>{
    private final int id;

    public Tag(int id) {
        this.id = id;
    }

    public static Tag from(String s) {
        try{
            return new Tag(Integer.parseInt(s));
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Tag otherTag) {
        return Integer.compare(id, otherTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Tag otherTag = (Tag) obj;
        return id == otherTag.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
