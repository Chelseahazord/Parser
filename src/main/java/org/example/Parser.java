import java.io.IOException;
import java.net.URL;

import  org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
    public static String[] city = new String[200];// Города
    public static int[] temperature = new int[200];// Их температура
    public static int[] Humidity = new int[200];//Влажность
    public static int[] Pressure = new int[200];//Давление
    public static int[] Wind = new int[200];//Ветер(м/с)
    //параметры города располдожены в i ячейке каждого массива(индексы всех массивов совпадаеют с индексом ячейки,где содержится название города
    private static Document getPage() throws IOException{
        String url = "https://pogoda.mail.ru/country/russia/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }
    public static void main(String[] args) throws IOException{
        Document page = getPage();
        Elements tableWth = page.select("li[data-logger]");
        Element table;


        for(Element i : tableWth)
        {
            int j = 0;
            String name = i.select("a").text();
            String Temperature = i.select(".city-list__val-temperature").text();
            Temperature = Temperature.substring(0,Temperature.length()-1);
            String humidity = i.select(".city-list__val-humidity").text();
            humidity = humidity.substring(0,humidity.length()-1);
            String pressure = i.select(".city-list__val-pressure").text();
            pressure = pressure.substring(0,pressure.length()-3);
            String wind = i.select(".city-list__val-wind").text();
            int Temp =Integer.parseInt(Temperature);
            int Humidit =Integer.parseInt(humidity);
            int Pressur =Integer.parseInt(pressure);
            int win =Integer.parseInt(wind);
            city[j] = name;
            temperature[j] = Temp;
            Humidity[j] = Humidit;
            Pressure[j] = Pressur;
            Wind[j] = win;
            System.out.println(city[j]);
            System.out.println( temperature[j]);
            System.out.println( Humidity[j]);
            System.out.println( Pressure[j]);
            System.out.println( Wind[j]);
            System.out.println();
            j += 1;
        }

    }

}
