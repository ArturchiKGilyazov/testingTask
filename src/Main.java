import exseptions.TemplateNotFoundException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Starter starter = new Starter();
        starter.initStartingInfo();

        FinderChanges finderChanges = new FinderChanges(starter.getYesterdayPage(), starter.getTodayPage());


        try{
            MessageGenerator messageGenerator = new MessageGenerator();
            messageGenerator.generatingMessage(finderChanges.findChanges());
        } catch (IOException | TemplateNotFoundException e) {
            e.printStackTrace();
        }
    }

}
