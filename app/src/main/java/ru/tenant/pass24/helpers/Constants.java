package ru.tenant.pass24.helpers;

import ru.tenant.pass24.authorizationFragments.Registration.apiModels.RegistryCheckRequestBody;

public class Constants {
    public static String authToken = "";
    public static String confirmPhoneToken = "";
    public static RegistryCheckRequestBody registryBody;
    public static int objectJoinType = 1;
    public static int passJoinType = 2;
    public static int confidanceType = 3;

    public static String getAuthToken(){
        return "Bearer " + authToken;
    }
}