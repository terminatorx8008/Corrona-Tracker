package org.Project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static String getData(String country)throws Exception {
        StringBuffer strbr = new StringBuffer();

        String url = "https://www.worldometers.info/coronavirus/country/"+country+"/";
        Document doc;
        doc = Jsoup.connect(url).get();

        Elements element = doc.select("#maincounter-wrap");
            element.stream().limit(3).forEach((e) -> {
                String text = e.select("h1").text();
                String number = e.select(".maincounter-number>span").text();
                strbr.append(text).append(" : ").append(number).append("\n");
            });
        return strbr.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the country whose data who want :");
        String country = sc.nextLine();

        try {
            System.out.println(getData(country));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
