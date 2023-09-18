# Шаг 1: Сборка проекта без тестов и checkstyle
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /MainApp

# Копируем pom.xml отдельно, чтобы сначала собрать зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код приложения
COPY src src

# Собираем проект без выполнения тестов и проверки стиля кода
RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

# Шаг 2: Создание конечного Docker-образа
FROM amazoncorretto:17
WORKDIR /MainApp

# Копируем JAR-файл из предыдущего этапа
COPY --from=build /MainApp/target/*.jar MainApp.jar

# Определяем порт, который приложение будет слушать (по умолчанию 8080)
EXPOSE 8080

# Команда для запуска Spring Boot приложения
CMD ["java", "-jar", "MainApp.jar"]
