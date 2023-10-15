# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

# Application related docs

Some documentations:

https://spring.io/guides/gs/accessing-data-mysql/

https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data.sql

https://www.baeldung.com/spring-boot-angular-web

### Starting the database

```shell
docker run \
    --name mysql-in-docker \
    -e MYSQL_ROOT_PASSWORD=secret456 \
    -p 23306:3306 \
    mysql:8.1.0
    
docker exec -it mysql-in-docker /bin/bash
```
Login as `root`:
```
mysql --password
```

```
create database sample_db;
create user 'springuser'@'%' identified by 'secret123';
grant all on sample_db.* to 'springuser'@'%';
```

Login as `springuser`:

```shell
mysql -uspringuser -p
```
```
use sample_db
select * from user;
```

### Starting the application

```shell
./gradlew -i :bootRun
```

### Using the REST API

For `GET /users` endpoint:
```shell
curl http://localhost:28080/sample/users
```

For `POST /users` endpoint:
```shell
curl http://localhost:28080/sample/users \
    -H "Content-Type: application/json" \
    -d '{
            "name": "Second",
            "email": "someotheremail@someemailprovider.com"
        }'
```
