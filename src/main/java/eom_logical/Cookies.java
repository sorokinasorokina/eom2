package eom_logical;

import java.util.HashMap;

public class Cookies {
    public static HashMap basicTeacherCookies(String auth_token) {

        return new HashMap(){
            {
                put("auth_token", auth_token);
                put("profile_type", "teacher");
                put("profile_id", "4296770");
            }
        };
    }
}
