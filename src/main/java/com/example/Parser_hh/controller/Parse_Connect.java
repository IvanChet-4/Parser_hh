package com.example.Parser_hh.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLConnection;

import static com.example.Parser_hh.constants.Constants.SITE_URL;
import static com.example.Parser_hh.constants.Constants.SITE_URL_ID;
import static java.lang.Integer.parseInt;

public class Parse_Connect {

    public static void startConnectForParse() throws Exception {

        //открываем соединение с сайтом (в константе SITE_URL зашит поисковый запрос, который можно изменить)
        URL url = new URL(SITE_URL);
        URLConnection connection = url.openConnection();

        //находим ссылку на резюме и достаем необходимую ее часть
        Document page = Jsoup.parse(url, 7000);
        Element listTagAForFindHref = page.select("a[class=serp-item__title]").get(0);//get(i)
        String attrTagA = listTagAForFindHref.attr("href");
        //System.out.println("listTagA = \n" + listTagA + "\n attrTagA = \n" + attrTagA);
        String[] splitAttrTagA = attrTagA.split("/");
        String[] splitResult0 = splitAttrTagA[2].split("\\?");
        //System.out.println(" split attrTagA = \n" + Arrays.toString(splitResult0));

        //открываем резюме get(i)
        URL urlID = new URL(SITE_URL_ID + splitResult0[0]);
        URLConnection connectionID = urlID.openConnection();

        Document pageID = Jsoup.parse(urlID, 7000);

        //age
        Elements listTagSpanForFindAge = pageID.select("span[data-qa=resume-personal-age]");
        String ageTagSpan = listTagSpanForFindAge.select("span").get(1).text();
        String[] splitAgeTagSpan = ageTagSpan.split(" ");
        int ageOnPageResume = parseInt(splitAgeTagSpan[0]);
        //System.out.println("listTagSpan = \n" + listTagSpan + "\n age = \n" + ageTagSpan + "\n ageOnPageResume = " + ageOnPageResume);

        //position
        String listTagSpanForFindPosition = pageID.select("span[data-qa=resume-block-title-position]").text();
        //System.out.println("\n listTagSpanForFindPosition = \n" + listTagSpanForFindPosition);

        

    }

}
