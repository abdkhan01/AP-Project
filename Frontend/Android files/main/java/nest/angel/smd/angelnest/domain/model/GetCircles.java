package nest.angel.smd.angelnest.domain.model;

import java.util.Date;

public class GetCircles {

    private int id;
    private String created;
    private String circle_name;
    private int createdBy;
    private int members[];
    private int successcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCircle_name() {
        return circle_name;
    }

    public void setCircle_name(String circle_name) {
        this.circle_name = circle_name;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int[] getMembers() {
        return members;
    }

    public void setMembers(int[] members) {
        this.members = members;
    }

    public int getSuccesscode() {
        return successcode;
    }

    public void setSuccesscode(int successcode) {
        this.successcode = successcode;
    }
}
