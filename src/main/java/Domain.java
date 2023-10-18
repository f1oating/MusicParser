import bl.ParseMusic;

import java.io.IOException;
import java.util.List;

public class Domain {

    public static void main(String[] args) {
        ParseMusic parseMusic = new ParseMusic();

        try{
            List links = parseMusic.parseMusicURLs("https://audiohunter.ru/?song=%D0%A1%D0%95%D0%A0%D0%95%D0%93%D0%90+%D0%9F%D0%98%D0%A0%D0%90%D0%A2");
            List titles = parseMusic.parseMusicTitles("https://audiohunter.ru/?song=%D0%A1%D0%95%D0%A0%D0%95%D0%93%D0%90+%D0%9F%D0%98%D0%A0%D0%90%D0%A2");
            parseMusic.writeFilesToFolder(links, titles);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
