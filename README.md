# # RELEX 2023 summer hometask for JAVA BACKEND
## Obukhova Ellina / Обухова Элина
## Ru
### Видео тестирования:
![Video of the testing](src/main/resources/video/video.mp4)

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

Пользователям со статусом **user** доступна регистрация, вход, отправка сообщения и запрос на добавление роли администратора.

Пользователям со статусом **admin** доступна выгрузка всех сообщений в csv / получение всех сообщений через json.

### Запуск
##### Конфигурация Spring Boot Application
> <img src="Pasted image 20230713125437.png">
##### Перед запуском поднять докер-контейнер с бд помощью docker-compose

**Troubleshooting:** при ошибках "нет подключения к базе данных" / "база данных test не существует" выполните в директории с проектом команду в консоли:

> docker-compose down --volumes

##### Postman workspace: [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16916558-e7081c88-5d5b-4791-b109-a737318d7cc3?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D16916558-e7081c88-5d5b-4791-b109-a737318d7cc3%26entityType%3Dcollection%26workspaceId%3D5fb6f1e9-c29c-4089-85b4-3422c977a967)
![View collection in your workspace:](https://github.com/WriteWrote/RELEX2023_homework/assets/45429218/5811ae46-0bb6-4a40-b62f-9994aabf02a7)

Для тестирования необходим десктоп-клиент Postman.

<details>
    <summary>Eng version: click to expand</summary>
    ## Basic API:
    - POST
    - GET
</details>