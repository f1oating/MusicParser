package bl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ParseMusic{

    public List<String> parseMusicURLs(String siteURL) throws IOException{
        Document doc;
        List<String> links = new ArrayList<String>();

        doc = Jsoup.connect(siteURL).get();
        Elements tracklinks = doc.select("a.link");

        for(Element element: tracklinks){
            String url = element.attr("href");
            links.add(url);
        }
        return links;
    }

    public List<String> parseMusicTitles(String siteURL) throws IOException{
        Document doc;
        List<String> titles = new ArrayList<String>();

        doc = Jsoup.connect(siteURL).get();
        Elements tracktitles = doc.select("a.trackLink");

        for(Element element: tracktitles){
            String title = element.text();
            titles.add(title);
        }
        return titles;
    }

    public void writeFilesToFolder(List<String> links, List<String> titles) {
        int numTitle = 0;

        for(String link: links){
            try{
                URLConnection conn = new URL("https:" + link).openConnection();
                InputStream is = conn.getInputStream();

                OutputStream outputStream = new FileOutputStream(new File("seregapirat/" + titles.get(numTitle) + ".mp3"));
                byte[] buffer = new byte[4096];

                int len;
                while ((len = is.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.close();
                System.out.println("Файл " + titles.get(numTitle) + ".mp3 " + "успешно записан!");
                numTitle++;
            }catch(IOException e){
                continue;
            }
        }

        System.out.println("Программа завершила свою работу !");
    }

}
