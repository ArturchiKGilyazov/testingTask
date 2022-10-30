import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@AllArgsConstructor
public class FinderChanges {

    private HashMap<String, String> yesterdayPages;
    private HashMap<String, String> todayPages;

    private  HashSet<String> deletedList(){
        HashSet<String> result = new HashSet<>();

        for(Map.Entry <String, String> entry : yesterdayPages.entrySet())
            if(!todayPages.containsKey(entry.getKey())) result.add(entry.getKey());

        return result;
    }

    private HashSet<String> addedList(){
        HashSet<String> result = new HashSet<>();

        for(Map.Entry <String, String> entry : todayPages.entrySet())
            if(!yesterdayPages.containsKey(entry.getKey())) result.add(entry.getKey());

        return result;
    }

    private HashSet<String> editList(){
        HashSet<String> result = new HashSet<>();

        for(Map.Entry <String, String> entry : todayPages.entrySet())
            if(yesterdayPages.containsKey(entry.getKey()))
                if(!yesterdayPages.get(entry.getKey()).equals(entry.getValue()))
                    result.add(entry.getKey());

        return result;
    }

    public Changes findChanges(){
        return todayPages.equals(yesterdayPages) ? (new Changes()) : new Changes(deletedList(), addedList(), editList());
    }

    public HashMap<String, String> getYesterdayPages() {
        return yesterdayPages;
    }

    public void setYesterdayPages(HashMap<String, String> yesterdayPages) {
        this.yesterdayPages = yesterdayPages;
    }

    public HashMap<String, String> getTodayPages() {
        return todayPages;
    }

    public void setTodayPages(HashMap<String, String> todayPages) {
        this.todayPages = todayPages;
    }
}
