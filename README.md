
# send-money

## Pre-requisite software/tool/ide


```bash
  Java 11 
  Maven
  SQLite
  git bash
  Intellij idea
```

## Building and running

As we disused above pre-requisite, Once clone this repo and run the below maven command
for locally using intellij idea terminal or any other command prompt.
Use CNTR+C for terminate this service
 ```
 mvn clean install
 mvn spring-boot:run
 ```

This artifact produces by this project s self-executable war file.
This approach makes java 11 only pre-requisite to deployment which
moves us a step in the right direction toward containers

## Endpoints


1. *http://localhost:8080/v1/country*  - Get available all country list
2. *http://localhost:8080/v1/country/NZ* - Sender available country list

## github repo
  https://github.com/radhakrishnaits/send-money

