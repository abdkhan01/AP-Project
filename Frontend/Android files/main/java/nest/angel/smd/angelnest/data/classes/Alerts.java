package nest.angel.smd.angelnest.data.classes;

public class Alerts {

public String alertName;
public boolean alertSwitch;

    public Alerts(String alertName) {
        this.alertName = alertName;

    }

    public Alerts(String alertName, boolean alertSwitch) {
        this.alertName = alertName;
        this.alertSwitch = alertSwitch;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    public void setAlertSwitch(boolean alertSwitch) {
        this.alertSwitch = alertSwitch;
    }

    public String getAlertName() {
        return alertName;

    }

    public boolean getAlertSwitch() {
        return alertSwitch;
    }


}
