package com.example.Parser_hh.controller;

import com.example.Parser_hh.entity.Resume_Entity;
import com.example.Parser_hh.repository.Resume_Repo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.Parser_hh.constants.Constants.*;
import static java.lang.Integer.parseInt;

@RestController
public class Parse_Connect {


    public static void startProg(){
        ArrayList<Resume_Entity> ff =  Parse_Connect.startConnectForParse();
        System.out.println(Arrays.asList(ff));
    }


    public static ArrayList<Resume_Entity> startConnectForParse() {

        Resume_Entity resume_entity = new Resume_Entity();
        ArrayList<Resume_Entity> resume_entities_ar = new ArrayList<>();

        try {

            //j - номер страницы, на каждой странице отображено 100 резюме
            for (int j = 0; j < 2; j++){
                //открываем соединение с сайтом (в константе SITE_URL зашит поисковый запрос, который можно изменить)
                URL url = new URL(SITE_URL1 + j + SITE_URL2);

            // System.out.println("url" + url);
            //URLConnection connection = url.openConnection();
            //находим ссылку на резюме и достаем необходимую ее часть
            Document page = Jsoup.parse(url, 7000);

            //i - можно поставить 100
            for (int i = 0; i < 5; i++) {

                   Element listTagAForFindHref = page.select("a[class=serp-item__title]").get(i);//get(i)
                   String attrTagA = listTagAForFindHref.attr("href");
                   //System.out.println("listTagA = \n" + listTagA + "\n attrTagA = \n" + attrTagA);
                   String[] splitAttrTagA = attrTagA.split("/");
                   String[] splitResult0 = splitAttrTagA[2].split("\\?");
                   //System.out.println(" split attrTagA = \n" + Arrays.toString(splitResult0));


                //открываем резюме get(i); urlID - страница резюме
                URL urlID = new URL(SITE_URL_ID + splitResult0[0]);
                String siteWebPages = SITE_URL_ID + splitResult0[0];
                System.out.println("\n KeyWebPagesResume = " + siteWebPages);
                //URL urlID = new URL(URL_R);
                //URLConnection connectionID = urlID.openConnection();
                Document pageID = Jsoup.parse(urlID, 7000);

                //was
                String[] wasTime = new String[0];
                String listTagDivForFindWas = pageID.select("div[class=resume-online-status]").text();
                if (!listTagDivForFindWas.isEmpty()) {
                    wasTime = listTagDivForFindWas.split("&nbsp;");
                   // System.out.println("\n WasTime = " + Arrays.toString(wasTime));
                }

                //age
                int ageOnPageResume = 0;
                Elements listTagSpanForFindAge = pageID.select("span[data-qa=resume-personal-age]");
                if (!listTagSpanForFindAge.isEmpty()) {
                    String ageTagSpan = listTagSpanForFindAge.select("span").get(1).text();
                    String[] splitAgeTagSpan = ageTagSpan.split(" ");
                    ageOnPageResume = parseInt(splitAgeTagSpan[0]);
                   // System.out.println("\n age = \n" + ageOnPageResume);
                }
                
                //position
                String listTagSpanForFindPosition = pageID.select("span[data-qa=resume-block-title-position]").text();
                if (!listTagSpanForFindPosition.isEmpty()) {
                    //System.out.println("\n Position = \n" + listTagSpanForFindPosition);
                }

/////////////////////////////////////////////
                //name
//        Elements listTagSpanForFindName = pageID.select("h2[data-qa=resume-personal-name]");
//        String nameTagSpan = listTagSpanForFindName.select("span").text();
//        String[] splitNameTagSpan = nameTagSpan.split(" ");
//        String splitNameTagSpan0 = splitNameTagSpan[0];
//        System.out.println("\n splitNameTagSpan0 = \n" + splitNameTagSpan0);
//        System.out.println(listTagSpanForFindName);
                //surname
//        String splitNameTagSpan1 = splitNameTagSpan[1];
//        System.out.println("\n splitNameTagSpan1 = \n" + splitNameTagSpan1);
                //email
//        Elements listTagDivForFindEmail = pageID.select("div[data-qa=resume-contact-email]");
//        String emailTagSpan = listTagDivForFindEmail.select("span").text();
                //phone
//        String listTagSpanForFindPhone = pageID.select("span[data-qa=resume-contact-preferred]").text();
/////////////////////////////////////////////

                //dateNow
                LocalDateTime dateNow = LocalDateTime.now();
              //  System.out.println(" \n DateNow = \n" + dateNow);



            //Results save
                resume_entity .setAge(ageOnPageResume);
                resume_entity .setPosition(listTagSpanForFindPosition);
                resume_entity .setUrl_site(SITE_URL_ID + splitResult0[0]);
                resume_entity .setLocal_time(dateNow);
                resume_entity .setWas_time(Arrays.toString(wasTime));

                resume_entities_ar.add(resume_entity);
               // resume_repo.save(resume_entity);

//       // resumInformation.setName(splitNameTagSpan[0]);
//       // resumInformation.setSurname(splitNameTagSpan[1]);
//       // resumInformation.setEmail(emailTagSpan);
//       // resumInformation.setPhone(listTagSpanForFindPhone);

            }}//циклы for
        }catch (IOException e){}

        return resume_entities_ar;
    }


}
