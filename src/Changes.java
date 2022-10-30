import lombok.AllArgsConstructor;

import java.util.HashSet;

public class Changes {


    private HashSet<String> deletedPages = new HashSet<>();
    private HashSet<String> addedPages = new HashSet<>();
    private HashSet<String> editPages = new HashSet<>();

    public Changes(){
        deletedPages = new HashSet<>();
        addedPages = new HashSet<>();
        editPages = new HashSet<>();
    }

    public Changes(HashSet<String> deletedPages, HashSet<String> addedPages, HashSet<String> editPages) {
        this.deletedPages = deletedPages;
        this.addedPages = addedPages;
        this.editPages = editPages;
    }

    public HashSet<String> getDeletedPages() {
        return deletedPages;
    }

    public HashSet<String> getAddedPages() {
        return addedPages;
    }

    public HashSet<String> getEditPages() {
        return editPages;
    }
}
