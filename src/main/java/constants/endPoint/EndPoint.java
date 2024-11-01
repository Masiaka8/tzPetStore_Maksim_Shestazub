package constants.endPoint;

public final class EndPoint {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/%s";
    public static final String CREATE_PET = String.format(BASE_URL, "pet/");
    public static final String UPDATE_PET = String.format(BASE_URL, "pet/");
    public static final String FIND_PET_BY_ID = String.format(BASE_URL, "pet/");
}
