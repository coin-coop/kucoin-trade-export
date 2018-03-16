/*

 */

package org.coincoop.tradeimporter.controller.format.exchange;

public enum CoinTracking {

    TYPE("Type", ""),
    BUY_AMOUNT("Buy", ""),
    BUY_CURRENCY("BuyCurrency", ""),
    SELL_AMOUNT("Sell", ""),
    SELL_CURRENCY("SellCurrency", ""),
    FEE("Fee", ""),
    FEE_CURRENCY("FeeCurrency", ""),
    EXCHANGE("Exchange", ""),
    GROUP("Group", ""),
    COMMENT("Comment", ""),
    DATE("Date", "");

    private String csvHeader;
    private String jsonKey;

    CoinTracking(String csvHeader, String jsonKey) {
        this.csvHeader = csvHeader;
        this.jsonKey = jsonKey;
    }

    public String getCsvHeader() {
        return this.csvHeader;
    }

    public String getJsonKey() {
        return jsonKey;
    }
}
