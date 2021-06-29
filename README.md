### Описание:
Этот репозиторий создан в качестве тестовой среды для создания тестов по модели Page Object Model.

Тесты имплементированы на связке Java + Selenium + Cucumber + Gherkin.

### Тестовый сайт:
https://www.seleniumeasy.com/


###Тестовые сценарии:
1. Сценарий, метка @smoke - открыть вебсайт и заполнить несколько форм.
2. Сценарий, метка @regression - открыть вебсайт, затем открыть раздел Selenium -> Selenium With Java и открыть 1 и 3 статьи на странице.
3. Сценарий, метка @smoke, @regression - TBD

### Структура проекта:
#### main
- src/main/java/enums - перечисление различных типов конфигураций для драйвера/окружения
- src/main/java/manager - обработчики для создания вебдрайвера, работы со страницами
- src/main/java/pages - код для взаимодействия со страницами
- src/main/java/DBC_Oracle.java, DBC_Postgre - файлы для тестов с БД

#### test
- src/test/java/features - feature файл с тестами на языке Gherkin
- src/test/java/runner - раннер для запуска тестов
- src/test/java/steps - java файлы, с имплементацией запуска тестов на каждой из страниц




