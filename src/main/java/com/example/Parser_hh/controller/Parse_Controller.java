package com.example.Parser_hh.controller;

import com.example.Parser_hh.entity.Resume_Entity;
import com.example.Parser_hh.repository.Resume_Repo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.Parser_hh.constants.Constants.*;
import static com.example.Parser_hh.constants.Constants.SITE_URL_ID;
import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/")
public class Parse_Controller {

    @Autowired
    private Resume_Repo resume_repo;

    @GetMapping("all")
    public ResponseEntity getParsers() {
        ArrayList<Resume_Entity> resume_entities = (ArrayList<Resume_Entity>) resume_repo.findAll();
        return ResponseEntity.ok(resume_entities);
    }

    @PostMapping("add")
    public String startParse(@ModelAttribute ArrayList<Resume_Entity> resume_entity, @ModelAttribute Resume_Entity resume_entity_set) {

        try {

            // j - номер страницы, на каждой странице отображено 100 резюме
            for (int j = 0; j < Jtoe; j++) {

                // открываем соединение с сайтом (в константе SITE_URL зашит поисковый запрос, который можно изменить)
                URL url = new URL(SITE_URL1 + j + SITE_URL2);

                // находим ссылку на резюме и достаем необходимую ее часть
                Document page = Jsoup.parse(url, 7000);

                // i - можно поставить 100
                for (int i = 0; i < Itoe; i++) {

                    Element listTagAForFindHref = page.select("a[class=serp-item__title]").get(i);//get(i)
                    String attrTagA = listTagAForFindHref.attr("href");
                    // System.out.println("listTagA = \n" + listTagA + "\n attrTagA = \n" + attrTagA);
                    String[] splitAttrTagA = attrTagA.split("/");
                    String[] splitResult0 = splitAttrTagA[2].split("\\?");
                    // System.out.println(" split attrTagA = \n" + Arrays.toString(splitResult0));

                    // открываем резюме get(i); urlID - страница резюме
                    URL urlID = new URL(SITE_URL_ID + splitResult0[0]);
                    String siteWebPages = SITE_URL_ID + splitResult0[0];
                    System.out.println("\n KeyWebPagesResume = " + siteWebPages);
                    // URL urlID = new URL(URL_R);
                    // URLConnection connectionID = urlID.openConnection();
                    Document pageID = Jsoup.parse(urlID, 7000);

                    // was
                    String[] wasTime = new String[0];
                    String listTagDivForFindWas = pageID.select("div[class=resume-online-status]").text();
                    if (!listTagDivForFindWas.isEmpty()) {
                        wasTime = listTagDivForFindWas.split("&nbsp;");
                        // System.out.println("\n WasTime = " + Arrays.toString(wasTime));
                    }

                    // age
                    int ageOnPageResume = 0;
                    Elements listTagSpanForFindAge = pageID.select("span[data-qa=resume-personal-age]");
                    if (!listTagSpanForFindAge.isEmpty()) {
                        String ageTagSpan = listTagSpanForFindAge.select("span").get(1).text();
                        String[] splitAgeTagSpan = ageTagSpan.split(" ");
                        ageOnPageResume = parseInt(splitAgeTagSpan[0]);
                        // System.out.println("\n age = \n" + ageOnPageResume);
                    }

                    // position
                    String listTagSpanForFindPosition = pageID.select("span[data-qa=resume-block-title-position]").text();
                    if (!listTagSpanForFindPosition.isEmpty()) {
                        // System.out.println("\n Position = \n" + listTagSpanForFindPosition);
                    }

/////////////////////////////////////////////
                    // name
//        Elements listTagSpanForFindName = pageID.select("h2[data-qa=resume-personal-name]");
//        String nameTagSpan = listTagSpanForFindName.select("span").text();
//        String[] splitNameTagSpan = nameTagSpan.split(" ");
//        String splitNameTagSpan0 = splitNameTagSpan[0];
//        System.out.println("\n splitNameTagSpan0 = \n" + splitNameTagSpan0);
//        System.out.println(listTagSpanForFindName);
                    // surname
//        String splitNameTagSpan1 = splitNameTagSpan[1];
//        System.out.println("\n splitNameTagSpan1 = \n" + splitNameTagSpan1);
                    // email
//        Elements listTagDivForFindEmail = pageID.select("div[data-qa=resume-contact-email]");
//        String emailTagSpan = listTagDivForFindEmail.select("span").text();
                    // phone
//        String listTagSpanForFindPhone = pageID.select("span[data-qa=resume-contact-preferred]").text();
/////////////////////////////////////////////

                    // dateNow
                    LocalDateTime dateNow = LocalDateTime.now();
                    // System.out.println(" \n DateNow = \n" + dateNow);

                    // Вывод значений в консоль.
                    System.out.println("\n ageOnPageResume = " + ageOnPageResume +
                            "\n listTagSpanForFindPosition = " + listTagSpanForFindPosition +
                            "\n siteWebPages = " + siteWebPages +
                            "\n dateNow = " + dateNow +
                            "\n Arrays.toString(wasTime) = " + Arrays.toString(wasTime));


                    // Results save
                    resume_entity_set = new Resume_Entity();
                    resume_entity_set.setAge(ageOnPageResume);
                    resume_entity_set.setPosition(listTagSpanForFindPosition);
                    resume_entity_set.setUrl_site(siteWebPages);
                    resume_entity_set.setLocal_time(dateNow);
                    resume_entity_set.setWas_time(Arrays.toString(wasTime));

                    // Без ключа, блок с этими данными закрыт
                    // resume_entity_set.setName(splitNameTagSpan[0]);
                    // resume_entity_set.setSurname(splitNameTagSpan[1]);
                    // resume_entity_set.setEmail(emailTagSpan);
                    // resume_entity_set.setPhone(listTagSpanForFindPhone);

                    // Записываем результат
                    resume_entity.add(resume_entity_set);

                }
            }// Закрываются циклы for
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Сохраняем результат
        startSave(resume_entity);
        return "БД обновлена";
    }

    private void startSave(ArrayList<Resume_Entity> resume_entity) {
        for (int i = 0; i < resume_entity.size(); i++) {
            resume_repo.save(resume_entity.get(i));
            // System.out.println( "\n get i \n" + resume_entity.get(i).toString());
        }
        System.out.println("\n Сохранен \n");
    }
}