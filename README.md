# 실전! 스프링 5와 Vue.js 2로 시작하는 모던 웹 애플리케이션 개발
> 스프링 부트와 Vuex를 활용한 실습 중심의 풀스택 웹 애플리케이션 개발

<img src="book-contents/assets/book-cover.jpeg" witdh=300 height=400>

# contents
* [chapter02 - Vue.js 2 - 기대한 방식으로 동작한다](book-contents/chapter02)
* [chapter03 - 스프링 5 - 작업에 적합한 기술 스택](book-contents/chapter03)
* 실습 프로젝트 - Task Agile
  * Open source task management tool
  * 스프링5과 Vue.js 2로 시작하는 모던 웹 애플리케이션 개발
  * 실행
    * front-end
      * `npm run serve`
    * back-end
      * `./mvnw clean install`

# TaskAgile

Open source task management tool built with Vue.js 2, Spring Boot 2, and MySQL 5.7+

> This is the repository for the book [_Building applications with Spring 5 and Vue.js 2: A real-world practical guide to building a modern full-stack web application_](https://www.amazon.com/Building-applications-Spring-5-0-Vue-js-ebook/dp/B079X1VTST).

## Local development setup

### Prerequisites

- JDK8 - OpenJDK  Preferred
- MySQL 5.7+
- RabbitMQ 3.6+
- GraphicMagick 1.3+

### Database setup

- Create database `task_agile`
- Initialize database with scripts in `setup` folder

### Add dev properties file

- Create `src/main/resources/application-dev.properties` with the following settings to override the settings in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_agile?useSSL=false
spring.datasource.username=<your username>
spring.datasource.password=<your password>
```

## Commands

- Use `mvn test` to run the tests of the back-end and the front-end
- Use `mvn spring-boot:run` to start the back-end
- Use `npm run serve` inside the `front-end` directory to start the front-end
- Use `mvn install` to build both the front-end and the back-end
- Use `java -jar target/app-0.0.1-SNAPSHOT.jar` to start the bundled application

## How to run application inside docker

```bash
$ mvn clean package
$ cp target/app-0.0.1-SNAPSHOT.jar docker/app.jar
$ docker build -t taskagile:dev docker/
```

### Start with dev profile locally

```bash
$ docker run --rm --name taskagile -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -p 9000:9000 taskagile
```

### Start on server

With active profiles `staging` and `docker`. Make sure `docker` is the last one in the list so that the settings in `evn.list` will be applied.

```bash
$ docker run --rm --name taskagile --env-file ./docker/env.list -e "SPRING_PROFILES_ACTIVE=staging,docker" -p 8080:8080 -p 9000:9000 taskagile
```
to : …까지, …에 이르도록, …을 위하여, …을 하려고, …으로
