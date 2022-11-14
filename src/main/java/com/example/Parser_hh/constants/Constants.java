package com.example.Parser_hh.constants;

public interface Constants {
   // String SITE_URL = "https://hh.ru/resumes/razrabotchik";//можно редактировать поисковый запрос razrabotchik

    //поисковый запрос разработчик = razrabotchik; фильтр чтобы выводить по 100 резюме
    String SITE_URL1 = "https://hh.ru/resumes/razrabotchik?area=1&clusters=true&exp_period=all_time&logic=normal&no_magic=true&order_by=relevance&ored_clusters=true&pos=full_text&text=разработчик&items_on_page=100&page=";
    String SITE_URL2 = "&hhtmFrom=resumes_catalog";

    //переход на новую страницу для фильтра по 20 резюме
    String nextPage1 = "?page=";
    String nextPage2 = "&hhtmFrom=resumes_catalog";

    //для открытия определенного резюме SITE_URL_ID + значение из атрибута href
    String SITE_URL_ID = "https://hh.ru/resume/";

    //Тесты
    //String URL_R = "https://hh.ru/resume/05fe4e23ff0b0f3b960039ed1f43654d384572";
}