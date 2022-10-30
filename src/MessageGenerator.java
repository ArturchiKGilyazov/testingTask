import exseptions.TemplateNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
    import java.util.HashSet;

public class MessageGenerator {

    private final String NO_CHANGE = "No change in file";
    private final String PATH_TEXT_TEMPLATE = "src/resourse/TextTemplate.txt";
    private final String DELETED_SUBSTRING = "{deleted}";
    private final String ADD_SUBSTRING = "{add}";
    private final String CHANGE_SUBSTRING = "{change}";
    private final String PATH_FOR_SAVE_MESSAGE = "output/";


    public void generatingMessage(Changes changes) throws TemplateNotFoundException, IOException {
        File tmp = new File(PATH_TEXT_TEMPLATE);

        if(!tmp.exists()){
            throw new TemplateNotFoundException("Template file not found");
        }

        File output = new File(PATH_FOR_SAVE_MESSAGE);

        if (!output.exists()) {
            output.mkdir();
        }

        String fileName = "out" + (new Date()).getTime() + ".txt";
        File out = new File(PATH_FOR_SAVE_MESSAGE + fileName);

        Files.copy(tmp.toPath(), out.toPath());

        replaceText(out.toPath(), DELETED_SUBSTRING, set2str(changes.getDeletedPages()));
        replaceText(out.toPath(), ADD_SUBSTRING, set2str(changes.getAddedPages()));
        replaceText(out.toPath(), CHANGE_SUBSTRING, set2str(changes.getEditPages()));
    }

    private String set2str(HashSet<String> hashSet){
        if(hashSet.isEmpty()) return NO_CHANGE;
        StringBuilder str = new StringBuilder();
        for (String s : hashSet){
            str.append(s).append("; ");
        }
        return str.toString();
    }

    private void replaceText(Path path, String search, String replace) throws IOException {
        Files.writeString(path,
                Files.readString(path).replace(search, replace));
    }
}
