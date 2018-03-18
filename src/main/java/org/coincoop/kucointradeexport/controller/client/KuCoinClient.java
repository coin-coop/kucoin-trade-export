package org.coincoop.kucointradeexport.controller.client;

import java.io.IOException;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;

import org.coincoop.kucoinapi.KuCoinAPI;

public class KuCoinClient implements CustomClient {

    private String apiKey;
    private String secretKey;
    private String baseUrl = "https://api.kucoin.com/";
    private String additionalUrl;
    private String responseBody;
    private MultivaluedHashMap<String, Object> headers;
    private Form form = new Form();

    public KuCoinClient() {

    }

    public KuCoinClient(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public KuCoinClient(String apiKey, String secretKey, String baseUrl) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public JsonObject getUserInfo() throws IOException {
        return new org.coincoop.kucoinapi.client.KuCoinClient(this.apiKey, this.secretKey).getUserInfo();
    }

    public List<String> getTradingSymbols() throws IOException {
        return new KuCoinAPI(this.apiKey, this.secretKey).getTradingSymbols();
    }

    @Override
    public List<JsonObject> getTradingHistory() throws IOException {
        return new org.coincoop.kucoinapi.client.KuCoinClient(this.apiKey, this.secretKey).getTradingHistory();
    }

    @Override
    public List<JsonObject> getTradingHistory(Long before, Long after) throws IOException {
        return new org.coincoop.kucoinapi.client.KuCoinClient(this.apiKey, this.secretKey).getTradingHistory(before, after);
    }

    @Override
    public List<JsonObject> getTradingHistory(String symbol) throws IOException {
        return new org.coincoop.kucoinapi.client.KuCoinClient(this.apiKey, this.secretKey).getTradingHistory(symbol, null, null);
    }

    @Override
    public List<JsonObject> getTradingHistory(String symbol, Long before, Long after) throws IOException {
        System.out.println("I called it!");
        System.out.println(symbol);
        System.out.println(before);
        System.out.println(after);
        return new org.coincoop.kucoinapi.client.KuCoinClient(this.apiKey, this.secretKey).getTradingHistory(symbol, before, after);
    }
}
