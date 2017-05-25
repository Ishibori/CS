package UserModels;

import java.util.Date;

/**
 * Created by Ishibori on 28/01/2017.
 */

public class User {
    String userId;
    Date created;

    int age; // years
    int incomeLevel; // approx money to spend pr. month
    int educationalLevel; //years after elementery school
    int weight; // kg
    int height; // meters
    int gender; // 0 male, 1 female
    String occupation; // maybe specify types
    String zipcode;

    // security
    String username;
    String password;
}
