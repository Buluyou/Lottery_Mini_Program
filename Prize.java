public class Prize implements Comparable{

    private String name;
    private int prizeId;

    public Prize(int prizeId, String name) {
        this.name = name;
        this.prizeId = prizeId;
    }

    public String getName() {
        return name;
    }

    public int getPrizeId() {
        return prizeId;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + prizeId + 34;
    }

    @Override
    public boolean equals(Object obj) {
        return prizeId == ((Prize)obj).getPrizeId();
    }

    @Override
    public int compareTo(Object obj) {
        return Integer.compare(prizeId, ((Prize)obj).getPrizeId());
    }

}
