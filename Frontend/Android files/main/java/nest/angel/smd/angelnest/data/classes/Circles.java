package nest.angel.smd.angelnest.data.classes;

public class Circles {

    private String circleName;
    private int memberCount;

    public Circles() {
    }

    public Circles(String circleName, int memberCount) {
        this.circleName = circleName;
        this.memberCount = memberCount;
    }

    public String getCircleName() {
        return circleName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }


}
