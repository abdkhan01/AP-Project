package nest.angel.smd.angelnest.domain.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("msg")
    public String msg;

    @SerializedName("status")
    public int status;
}
