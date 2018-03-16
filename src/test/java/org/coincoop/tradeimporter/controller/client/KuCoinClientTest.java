package org.coincoop.tradeimporter.controller.client;

import java.util.List;
import javax.json.JsonObject;

import org.junit.Ignore;
import org.junit.Test;

public class KuCoinClientTest {

    @Ignore
    @Test
    public void shouldGetUserInfo() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("","");

        System.out.println("First:");
        JsonObject jsonObject = kuCoinClient.getUserInfo();
    }

    @Ignore
    @Test
    public void shouldGetTradingHistory() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("","");

        System.out.println("Second:");
        List<JsonObject> jsonObject = kuCoinClient.getTradingHistory();
    }

    @Ignore
    @Test
    public void shouldGetTradingHistoryWithSymbol() throws Exception {
        KuCoinClient kuCoinClient = new KuCoinClient("","");

        System.out.println("Third:");
        List<JsonObject> jsonObject = kuCoinClient.getTradingHistory("ETH-BTC");
    }
}
