package nest.angel.smd.angelnest.data.network;

import java.util.HashMap;
import java.util.Map;


public class ObjectMapper {

    private static final String EMAIL               =           "email";
    private static final String PASSWORD            =           "password";


    public static Map<String, String> getLoginMapping(String email, String password) {

        Map<String, String> paramsRequest = new HashMap<>();
        paramsRequest.put(EMAIL, email);
        paramsRequest.put(PASSWORD, password);

        return paramsRequest;
    }
}
