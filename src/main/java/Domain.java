import bl.ParseMusic;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Domain {
    public static void main(String[] args) {
        ParseMusic parseMusic = new ParseMusic();
        Scanner sc = new Scanner(System.in);

        System.out.print("Пожалуйста вставьте ссылку на страницу: ");
        String url = sc.nextLine();
        System.out.print("\n" + "Пожалуйста укажите название папки: ");
        String folderName = sc.nextLine();

        sc.close();

        try{
            List links = parseMusic.parseMusicURLs(url);
            List titles = parseMusic.parseMusicTitles(url);
            parseMusic.writeFilesToFolder(links, titles, folderName);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
