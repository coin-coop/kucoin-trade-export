/*

 */

package org.coincoop.kucointradeexport.controller.format.exchange;

public enum KuCoin {

    TYPE("", "", "", "Trade", "Trade"),
    BUY_AMOUNT("", "amount", "dealValue", "", ""),
    BUY_CURRENCY("", "coinType", "coinTypePair", "", ""),
    SELL_AMOUNT("", "dealValue", "amount", "", ""),
    SELL_CURRENCY("", "coinTypePair", "coinType", "", ""),
    FEE("", "fee", "fee", "", ""),
    FEE_CURRENCY("", "coinType", "coinTypePair", "", ""),
    EXCHANGE("", "", "", "KuCoin", "KuCoin"),
    GROUP("", "", "", "", ""),
    COMMENT("", "", "", "", ""),
    DATE("", "createdAt", "createdAt", "", "");

    private String csvHeader;
    private String jsonKeyBuy;
    private String jsonKeySell;
    private String jsonValueBuy;
    private String jsonValueSell;

    KuCoin(String csvHeader, String jsonKeyBuy, String jsonKeySell, String jsonValueBuy, String jsonValueSell) {
        this.csvHeader = csvHeader;
        this.jsonKeyBuy = jsonKeyBuy;
        this.jsonKeySell = jsonKeySell;
        this.jsonValueBuy = jsonValueBuy;
        this.jsonValueSell = jsonValueSell;
    }

    public String getCsvHeader() {
        return this.csvHeader;
    }

    public String getJsonKeyBuy() {
        return jsonKeyBuy;
    }

    public String getJsonKeySell() {
        return jsonKeySell;
    }

    public String getJsonValueBuy() {
        return jsonValueBuy;
    }

    public String getJsonValueSell() {
        return jsonValueSell;
    }
}
