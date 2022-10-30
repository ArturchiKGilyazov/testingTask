import java.util.HashMap;

public class Starter {
    private HashMap<String, String> yesterdayPage = new HashMap<>();
    private HashMap<String, String> todayPage = new HashMap<>();

    public void initStartingInfo(){
        yesterdayPage.put("static.com", "NoChangePage");
        yesterdayPage.put("vk.com", "qwerty");

        yesterdayPage.put("yandex.ru", "DZEN)");
        yesterdayPage.put("habr.com", "someInformation");

        yesterdayPage.put("github.com", "myProject");
        yesterdayPage.put("react.rm", "deletedPage");



        todayPage.put("static.com", "NoChangePage");
        todayPage.put("vk.com", "qwerty");

        todayPage.put("yandex.ru", "DZENStatic");
        todayPage.put("habr.com", "changeSomeInformation");

        todayPage.put("stackoverflow.com", "blog");
        todayPage.put("react.add", "addedPage");
    }

    public HashMap<String, String> getYesterdayPage() {
        return yesterdayPage;
    }

    public void setYesterdayPage(HashMap<String, String> yesterdayPage) {
        this.yesterdayPage = yesterdayPage;
    }

    public HashMap<String, String> getTodayPage() {
        return todayPage;
    }

    public void setTodayPage(HashMap<String, String> todayPage) {
        this.todayPage = todayPage;
    }
}
