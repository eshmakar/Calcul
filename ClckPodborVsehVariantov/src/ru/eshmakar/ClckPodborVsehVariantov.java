package ru.eshmakar;

//почему-то после продолжител. времени выдает: java heap out of memory

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ClckPodborVsehVariantov {
    public static void main(String[] args) {
        int count = 0;
        String url;
        System.out.print("Работу начал...\n");
        for (char nol = 'T'; nol <= 'z'; nol++) {
            if (propustit(nol)) continue;
            for (char nol2 = 'Y'; nol2 <= 'z'; nol2++) {
                if (propustit(nol2)) continue;
                for (char nol3 = 'E'; nol3 <= 'z'; nol3++) {
                    if (propustit(nol3)) continue;
                    for (char nol4 = '0'; nol4 <= 'z'; nol4++) {
                        if (propustit(nol4)) continue;
                        for (char nol5 = '0'; nol5 <= 'z'; nol5++) {
                            if (propustit(nol5)) continue;
                            url = String.format("https://clck.ru/%c%c%c%c%c", nol, nol2, nol3, nol4, nol5);
                            InputStream response = null;
                            try {
                                response = new URL(url).openStream();
                                Scanner scanner = new Scanner(response);
                                String responseBody = scanner.useDelimiter("\\A").next();
                                String titleFromSite = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));

                                if (skryvat(titleFromSite))
                                    System.out.printf("%d. %s - %s\n", ++count, url, titleFromSite);

                            } catch (Exception ignored) {
                            } finally {
                                try {
                                    assert response != null;
                                    response.close();
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean propustit(char a) {
        return a == ':' || a == ';' || a == '<'
                || a == '=' || a == '>'
                || a == '?' || a == '@' || a == '[' || a == '\\'
                || a == ']' || a == '^' || a == '_' || a == '`';
    }

    private static boolean skryvat(String s) {
        return !s.equals("Google Документы ‒ бесплатно создавайте и редактируйте документы в Интернете.")
                && !s.equals("Google Таблицы ‒ бесплатно создавайте и редактируйте таблицы в Интернете.")
                && !s.contains("Яндекс.Карты") && !s.equals("Пройди тест на денежное мышление")
                && !s.equals("Обратная связь - Группа медицинских компаний студия")
                && !s.equals("МТС-Банк") && !s.equals("Index - MerchantNew")
                && !s.contains("РУСХИТ") && !s.equals(" Google Карты ") && !s.equals("Яндекс.Картинки")
                && !s.equals("Срочноденьги Заявка") && !s.equals("Best dating worldwide")
                && !s.equals("Яндекс") && !s.equals("МВД РОССИИ: УВЕДОМЛЕНИЕ О ШТРАФЕ")
                && !s.equals("Страница оплаты") && !s.contains("html") && !s.equals("New phoenix")
                && !s.equals("Корзина") && !s.equals("Ru_kitchent at Taplink") && !s.equals("Самолет")
                && !s.contains("Авито") && !s.equals("Оценка курьера") && !s.equals("Добро пожаловать!")
                && !s.contains("PeoplePass") && !s.equals("axilog.ru - служба доставки")
                && !s.equals("QIWI") && !s.equals("Расчёт стоимости полиса ОСАГО онлайн")
                && !s.contains("секс") && !s.equals("Ваш заказ | Вилгуд")
                && !s.contains("mistery") && !s.equals("Как самозанятым получать бесплатные смены  — Яндекс.Про")
                && !s.contains("xvideo") && !s.contains("ЮMoney") && !s.equals("Оплата")
                && !s.contains("porno") && !s.equals("") && !s.contains("Линзмастер")
                && !s.contains("Telegraph") && !s.equals("Короткий URL для всех!")
                && !s.contains("Ташкент") && !s.equals(" ") && !s.contains("Redirecting...")
                && !s.equals("Get Laid Tonight") && !s.equals("Ой!")
                && !s.equals("PravSistem.Club") && !s.equals("Warning! | There might be a problem with the requested link")
                && !s.contains("Квартиры свободные") && !s.equals("Статус заказа");
    }
}
