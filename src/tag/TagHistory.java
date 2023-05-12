package tag;

public class TagHistory implements Comparable<TagHistory> {
    private final Tag tag;
    private int failCnt;

    public TagHistory(Tag tag) {
        this.tag = tag;
    }

    public TagHistory(Tag tag, int failCnt) {
        this.tag = tag;
        this.failCnt = failCnt;
    }

    @Override
    public int compareTo(TagHistory tagHistory) {
        return tag.compareTo(tagHistory.tag);
    }

    /*@Override
    public int compareTo(TagHistory tagHistory) {
        int result = Integer.compare(tagHistory.failCnt, failCnt);
        if(result == 0){
            result = tag.compareTo(tagHistory.tag);
        }
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        TagHistory that = (TagHistory) o;
        return tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        return tag != null ? tag.hashCode() : 0;
    }

    public void addFailCnt() {
        failCnt++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tag);
        if(failCnt > 0){
            sb.append("(").append(failCnt).append(")");
        }
        return sb.toString();
    }
}
