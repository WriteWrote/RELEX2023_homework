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

### Описание

В этом проекте существует **разделение пользователей по ролям:** admin и user.

Пользователям со статусом **user** доступна регистрация, вход, отправка сообщение и запрос на добавление роли администратора.

Пользователям со статусом **admin** доступна также выгрузка всех сообщений в csv / получение всех сообщений через json.

### Запуск
##### Конфигурация Spring Boot Application

##### Перед запуском поднять докер-контейнер с бд помощью docker-compose
##### Тестирование через постман, см. видео выше