#language:ru

Функциональность: Авторизация и перевод

  Сценарий: : Авторизация в личном кабинете, перевод между картами клиента, проверка баланса (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    И пользователь залогинился с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код "12345" и переходит на страницу личного кабинента
    Когда когда пользователь выбирает первую карту с номером "5559 0000 0000 0001" и id "92df3f1c-a033-48e6-8390-206f6b1f56c0" и переходит на страницу транзакции
    И переводит "5000" рублей со второй карты с номером "5559 0000 0000 0002" и id "0f3f5c2a-249e-4c3d-8287-09f7a039391d"
    Тогда баланс на карте с номером "5559 0000 0000 0001" и id "92df3f1c-a033-48e6-8390-206f6b1f56c0" должен быть "15000" рублей








