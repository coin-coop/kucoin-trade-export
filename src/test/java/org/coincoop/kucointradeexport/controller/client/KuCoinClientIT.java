package org.coincoop.kucointradeexport.controller.client;

import java.time.LocalDate;
import java.util.List;
import javax.json.JsonObject;

import org.junit.Test;

public class KuCoinClientIT {

    @Test
    public void shouldGetUserInfo() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("", "");

        System.out.println("First:");
        JsonObject jsonObject = kuCoinClient.getUserInfo();
    }

    @Test
    public void shouldGetTradingHistory() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("", "");

        System.out.println("Second:");
        List<JsonObject> jsonObject = kuCoinClient.getTradingHistory();
    }

    @Test
    public void shouldGetTradingHistoryWithSymbol() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("", "");

        System.out.println("Third:");
        List<JsonObject> jsonObject = kuCoinClient.getTradingHistory("ETH-BTC");
    }

    @Test
    public void shouldGetTradingHistoryWithDates() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("", "");

        System.out.println("Fourth:");
        List<JsonObject> jsonObject = kuCoinClient.getTradingHistory(null, LocalDate.of(2018, 3, 14).toEpochDay());
    }
}
