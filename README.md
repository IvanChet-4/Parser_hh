# Parsing сайта HH

Данный проект создан для парсинга, при помощи библиотеки jsoup, открытых данных из 200-т резюме соискателей с сайта hh.ru.
(открытые данные не содержат ФИО, телефон и email)

В константах (src/main/java/com/example/Parser_hh/constants/Constants.java) прописаны: 

-сайт для парсинга, со встренным поисковым запросом, разбитый на две переменные SITE_URL1 и SITE_URL2 (поисковый запрос можно изменить в переменной SITE_URL1 = "https://hh.ru/resumes/razrabotchik?page=" поменять "razrabotchik" например на "kot" или другое значение );

-две переменные: количество просматриваемых страниц и количество просматриваемых резюме на странице. (10 страниц по 20 резюме = 200 резюме)



Для удобства работы с данным проектом вывод информации предусмотрен в браузере на странице all.html, но возможен и через консоль.
Вся информация с парсинга сохраняется в БД.
Для создания БД, необходимо будет создать файл - src/main/resources/application.properties (данный файл добавлен в .gitignore):

Содержимое файла application.properties:

"/////////////////////////////////////////////////////////////////////////

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/ //имя бд

spring.datasource.username= //имя пользователя

spring.datasource.password= //пароль

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

"/////////////////////////////////////////////////////////////////////////


На странице all.html есть две кнопки: 

-одна запускает парсинг и сохранение полученных данных в БД.

-вторая обновляет страницу и выводит все данные из БД.




Версия v1.2 Данная версия отличается от версии v1.1 отображением результатов, теперь результаты выводятся в таблицу.

/all.html результат парсинга (1)
![1](https://user-images.githubusercontent.com/104260618/206422229-3e15a5cb-d490-4c7b-90d5-4c7d2da6ff96.jpg)


/all.html результат парсинга (2)
![2](https://user-images.githubusercontent.com/104260618/206422276-c34b164b-11ef-4c3c-b490-f0ed096f2d9f.jpg)





//Версия v1.1 Первая версия.

/all.html
![1](https://user-images.githubusercontent.com/104260618/202474898-01ddaccf-f596-44f8-8569-ac1eff31cce9.jpg)

/all.html результат парсинга (1)
![2](https://user-images.githubusercontent.com/104260618/202474940-92594f07-13ae-4faf-98fe-f7b890cce1de.jpg)

/all.html результат парсинга (2)
![3](https://user-images.githubusercontent.com/104260618/202475116-4c587c43-8f6e-4db9-8843-6b34934cbf89.jpg)
