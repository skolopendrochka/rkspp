# Экзаменационная работа - Чечулина Екатерина
## Билет №11

## Описание проекта
Проект состоит из двух микросервисов:
- **ingest-service** - принимает POST-запросы и отправляет их в RabbitMQ
- **processor-service** - слушает очередь RabbitMQ, сохраняет данные в PostgreSQL и записывает статистику в ClickHouse

## Технологии
- Java 17
- Spring Boot 3.5.11
- Maven
- RabbitMQ
- PostgreSQL
- ClickHouse
- Swagger (OpenAPI 3.0)
- Docker

## Запуск проекта

### 1. Запуск инфраструктуры (Docker)
```bash
cd chechulina-processor
docker-compose up -d


## Запуск проекта

### 1. Запуск инфраструктуры (Docker)
```bash
cd chechulina-processor
docker-compose up -d

2. Запуск сервисов
Ingest-service: запустить ChechulinaIngestApplication

Processor-service: запустить ChechulinaProcessorApplication

3. Доступ к сервисам
Ingest-service Swagger: http://localhost:8081/swagger-ui.html

Processor-service Swagger: http://localhost:8082/swagger-ui.html

RabbitMQ веб-интерфейс: http://localhost:15672 (guest/guest)

PostgreSQL: localhost:5432 (postgres/skolopendrochka)

ClickHouse Cloud: через консоль https://console.clickhouse.cloud

API endpoints
Ingest-service
POST /api/v1/events - отправка события студента

Processor-service
POST /api/v1/events/count - получение количества записей и запись в ClickHouse

Пример запроса
json
POST http://localhost:8081/api/v1/events
Content-Type: application/json

{
  "фамилия": "Иванов",
  "имя": "Иван",
  "группа": "ИС-21",
  "дата_события": "2026-02-24T18:40:00",
  "время_получения": "2026-02-24T18:40:00"
}
Структура БД
PostgreSQL (сырые_события_студентов)
Поле	Тип	Описание
идентификатор	SERIAL	Первичный ключ
фамилия	VARCHAR(255)	Фамилия студента
имя	VARCHAR(255)	Имя студента
группа	VARCHAR(50)	Группа
дата_события	TIMESTAMP	Дата события
время_получения	TIMESTAMP	Время получения
ClickHouse (агрегаты_событий_студентов)
Поле	Тип	Описание
дата_и_время_записи	DateTime	Дата и время записи
количество_записей	UInt64	Количество записей
Контакты
Студент: Чечулина Екатерина

Группа:

Дата: 24.02.2026

text

---

## **Как сохранить файл:**

1. Открой **Блокнот** (Notepad)
2. Скопируй весь текст выше
3. Вставь в Блокнот
4. Нажми `Ctrl+S`
5. Выбери папку `C:\exam`
6. В поле "Имя файла" введи: `README.md`
7. В поле "Тип файла" выбери **"Все файлы (*.*)"**
8. Нажми **"Сохранить"**

---

## **Загрузи README.md на GitHub:**

```cmd
cd C:\exam
git add README.md
git commit -m "Добавлен README.md"
git push
