package nest.angel.smd.angelnest.data.classes;

import android.graphics.Bitmap;

public class Members {

    private Bitmap profileImage;
    private String name;
    private int adminSwitch;

    public Members() {
    }

    public Members(Bitmap profileImage, String name, int adminSwitch) {
        this.profileImage = profileImage;
        this.name = name;
        this.adminSwitch = adminSwitch;
    }

    public Members(Bitmap profileImage, String name) {
        this.profileImage = profileImage;
        this.name = name;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminSwitch(int adminSwitch) {
        this.adminSwitch = adminSwitch;
    }

    public Bitmap getProfileImage() {

        return profileImage;
    }

    public String getName() {
        return name;
    }

    public int getAdminSwitch() {
        return adminSwitch;
    }


}
