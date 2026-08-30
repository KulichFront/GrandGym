# GrandGym

Фитнес-приложение с маскотом-медведем Грэндом, тёмной темой и геймификацией.

## Статус
v0.9-beta — полный цикл тренировки, геймификация, ачивки, Room, DataStore, Firebase

## Стек
- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Room (локальная БД)
- DataStore (настройки, XP)
- Firebase (Auth, Firestore)
- Kotlinx Serialization (JSON-парсер)
- MVVM + ViewModel
- Coroutines + Flow

## Реализовано
- ✅ 5 экранов: онбординг, дашборд, тренировка, друзья, профиль
- ✅ Тёмная тема (Асфальт #1A1A1A, Бетон #E0E0E0, Синяк #6C5CE7)
- ✅ План тренировок из JSON
- ✅ Экран тренировки: таймер отдыха, пауза/резюм, смена веса
- ✅ Переключение упражнений
- ✅ Сохранение тренировок в Room
- ✅ Геймификация: XP, уровни
- ✅ 5 ачивок с условиями
- ✅ DataStore для хранения прогресса
- ✅ Firebase подключён (Auth в разработке)
- ✅ Health Connect заглушка

## Экраны
| Экран | Описание |
|---|---|
| Онбординг | Ввод имени, кнопка ПОГНАЛИ |
| Дашборд | Приветствие, карточка готовности, кнопка НАЧАТЬ, план на сегодня |
| Тренировка | Таймер, карточка упражнения, ПАУЗА/ЗАВЕРШИТЬ |
| Свои | Список друзей, кнопка Добавить |
| Профиль | Аватар, шкала опыта, достижения, статистика, настройки |

## Скриншоты
![Онбординг](Screenshots/OnboardScreen.png)
![Дашборд](Screenshots/HomeScreen.png)
![Тренировка](Screenshots/TrainingScreen.png)
![Друзья](Screenshots/FriendListScreen.png)
![Профиль](Screenshots/ProfileScreen.png)

## Автор
Куликов Кирилл — Android-разработчик, ищу стажировку.
- GitHub: [https://github.com/KulichFront]

## Планы
- v1.0 — Firebase Auth + Firestore (друзья)
- v1.1 — Видеоанализ техники
- v1.2 — Интеграция Health Connect