# # RELEX 2023 summer hometask for JAVA BACKEND
## Obukhova Ellina / Обухова Элина

### Видео тестирования:


### Основной функционал:

- POST создание сообщения (все пользователи)
- GET получить все сообщения как json (админ)
- GET получить все сообщения как csv (админ)
- POST регистрация (все пользователи)
- POST вход (все пользователи)
- POST стать админом (все пользователи)

### Технологии
- Spring Boot
- Gradle
- Spring Security Starter
- JWT token
- PostgreSQL
- Liquibase for migration control
- JPA
- Jakarta Validators for validation, Mapstruct for Mappers
- Docker for storing DB (created docker-compose)
- SLF4J for logging

### Описание

В этом проекте существует **разделение пользователей по ролям:** admin и user.

Пользователям со статусом **user** доступна регистрация, вход, отправка сообщение и запрос на добавление роли администратора.

Пользователям со статусом **admin** доступна также выгрузка всех сообщений в csv / получение всех сообщений через json.

### Запуск
##### Конфигурация Spring Boot Application
> <img src="Pasted image 20230713125437.png">
##### Перед запуском поднять докер-контейнер с бд помощью docker-compose
##### Тестирование через постман, см. видео выше
##### Postman workspace: [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16916558-e7081c88-5d5b-4791-b109-a737318d7cc3?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D16916558-e7081c88-5d5b-4791-b109-a737318d7cc3%26entityType%3Dcollection%26workspaceId%3D5fb6f1e9-c29c-4089-85b4-3422c977a967)
