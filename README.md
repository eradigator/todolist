Чтобы развернуть проект, нужно:

БД:
открыть MySQL Workbench, открыть и запустить скрипт database.sql

Проект:
открыть Git Bash
перейти в желаемую директорию, куда будет клонирован проект
выполнить команду:
git clone https://github.com/eradigator/school
открыть проект в IDE (Intellij Idea)
в окне "Maven projects need to be imported" нажать Import Changes

в файле:
/todolist/scr/main/resources/application.properties
задать нужные url, username, password для подключения к БД

Запустить проект:
/todolist/src/main/java/Application -> Run (Ctrl + Shift + F10)
После окончания запуска, в браузере перейти на localhost:8080

логин: user
пароль: user