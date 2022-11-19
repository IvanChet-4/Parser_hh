package com.example.Parser_hh.constants;

public interface Constants {

    // Ссылка на страницу для парсинга,
    // ссылка состоит из двух переменных и значения/номера страницы "SITE_URL1 + №-страницы + SITE_URL2"
    // в переменной SITE_URL1 содержиться поисковый запрос "razrabotchik"
    // готовая ссылка бедет выглядеть так SITE_URL1 + j + SITE_URL2, где j будет номер страницы (в цикл подается переменная Jtoe)
    // данная страница имеет включенный фильтр, чтобы выводить на странице по 20 резюме;
    String SITE_URL1 = "https://hh.ru/resumes/razrabotchik?page=";
    String SITE_URL2 = "&hhtmFrom=resumes_catalog";

    int Jtoe = 10; // Количество страниц, на которых будут парсится данные из резюме.


    // Дополнительные переменные для парсинга Itoe, SITE_URL_ID.
    int Itoe = 20; // Количество резюме для парсинга на каждой странице.

    // SITE_URL_ID - ссылка на резюме; Для открытия определенного резюме необходимо SITE_URL_ID + уникальное значение из атрибута href
    String SITE_URL_ID = "https://hh.ru/resume/";


    // Для тестов
    // String URL_R = "https://hh.ru/resume/05fe4e23ff0b0f3b960039ed1f43654d384572";
    // String SITE_URL = "https://hh.ru/resumes/razrabotchik";//можно редактировать поисковый запрос "razrabotchik"
    // данная страница имеет включенный фильтр, чтобы выводить на странице по 100 резюме;
    // String SITE_URL1 = "https://hh.ru/resumes/razrabotchik?area=1&clusters=true&exp_period=all_time&logic=normal&no_magic=true&order_by=relevance&ored_clusters=true&pos=full_text&text=разработчик&items_on_page=100&page=";
    // String SITE_URL2 = "&hhtmFrom=resumes_catalog";
}