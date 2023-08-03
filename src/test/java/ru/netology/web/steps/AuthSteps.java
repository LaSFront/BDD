package ru.netology.web.steps;


import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.PersonalAccount;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.VerificationPage;

import static org.junit.Assert.assertEquals;


public class AuthSteps {

    private static LoginPage loginPage;
    private static VerificationPage verificationPage;
    private static PersonalAccount personalAccount;
    private static TransferPage transferPage;

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @И("пользователь залогинился с именем {string} и паролем {string}")
    public void enterLoginPassword(String login, String password) {
        verificationPage = loginPage.validLogin(new DataHelper.AuthInfo(login, password));
    }

    @И("пользователь вводит проверочный код {string} и переходит на страницу личного кабинента")
    public void enterCode(String code) {
        personalAccount = verificationPage.validVerify(new DataHelper.VerificationCode(code));
    }


    @Когда("когда пользователь выбирает первую карту с номером {string} и id {string} и переходит на страницу транзакции")
    public void chooseCard1(String cardNumber, String cardId) {
        transferPage = personalAccount.selectCardForTransfer(new DataHelper.CardsInfo(cardNumber, cardId));
    }


    @И("переводит {string} рублей со второй карты с номером {string} и id {string}")
    public void transferOperation(String amount, String cardNumber, String cardId) {
        personalAccount = transferPage.transferOperationValid(amount, new DataHelper.CardsInfo(cardNumber, cardId));
    }


    @Тогда("баланс на карте с номером {string} и id {string} должен быть {string} рублей")
    public void getCardBalance(String cardNumber, String cardId, String amount) {
        assertEquals(Integer.parseInt(amount), personalAccount.getCardBalance(new DataHelper.CardsInfo(cardNumber, cardId)));


    }
}

