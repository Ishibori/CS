package SurveyModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ishibori on 28/01/2017.
 */

public class Survey {
    public String id;
    public Date created;
    public Date expiration;
    public Date published;
    public ArrayList<SurveyCategory> categories = new ArrayList<>();
    public SurveyQuestion question;
    public ArrayList<SurveyOption> options = new ArrayList<>();
    public ArrayList<String> respondents = new ArrayList<>(); // containts user ids
    public int numberOfNeededResponses;

    public Survey(){
        id = UUID.randomUUID().toString();
        created = new Date();
    }
}
