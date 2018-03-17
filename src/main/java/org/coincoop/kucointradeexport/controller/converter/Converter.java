/*

 */

package org.coincoop.kucointradeexport.controller.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.coincoop.kucointradeexport.controller.format.Format;
import org.coincoop.kucointradeexport.controller.format.Record;
import org.coincoop.kucointradeexport.controller.format.exchange.CoinTracking;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Converter {

    public List<Record> convert(Format importFormat, Format exportFormat, List<Record> records) {
        if (importFormat == Format.KU_COIN && exportFormat == Format.COIN_TRACKING) {
            return convertKuCoinToCoinTracking(records);
        }

        throw new NotImplementedException();
    }

    private List<Record> convertKuCoinToCoinTracking(List<Record> records) {
        List<Record> convertedRecords = new ArrayList<>();

        for (Record entry : records) {
            Record record = new Record();

            record.put(CoinTracking.TYPE.getCsvHeader(), "Trade");

            String amount = entry.getValueByKey("amount");
            String dealValue = entry.getValueByKey("dealValue");
            String coinType = entry.getValueByKey("coinType");
            String coinTypePair = entry.getValueByKey("coinTypePair");
            String fee = entry.getValueByKey("fee");
            String createdAt = entry.getValueByKey("createdAt");

            if (entry.getValueByKey("direction").equals("BUY")) {
                record.put(CoinTracking.BUY_AMOUNT.getCsvHeader(), amount);
                record.put(CoinTracking.BUY_CURRENCY.getCsvHeader(), coinType);
                record.put(CoinTracking.SELL_AMOUNT.getCsvHeader(), dealValue);
                record.put(CoinTracking.SELL_CURRENCY.getCsvHeader(), coinTypePair);
                record.put(CoinTracking.FEE.getCsvHeader(), fee);
                record.put(CoinTracking.FEE_CURRENCY.getCsvHeader(), coinType);
            } else {
                record.put(CoinTracking.BUY_AMOUNT.getCsvHeader(), dealValue);
                record.put(CoinTracking.BUY_CURRENCY.getCsvHeader(), coinTypePair);
                record.put(CoinTracking.SELL_AMOUNT.getCsvHeader(), amount);
                record.put(CoinTracking.SELL_CURRENCY.getCsvHeader(), coinType);
                record.put(CoinTracking.FEE.getCsvHeader(), fee);
                record.put(CoinTracking.FEE_CURRENCY.getCsvHeader(), coinTypePair);
            }

            record.put(CoinTracking.EXCHANGE.getCsvHeader(), "KuCoin");
            record.put(CoinTracking.GROUP.getCsvHeader(), "");
            record.put(CoinTracking.COMMENT.getCsvHeader(), "");
            record.put(CoinTracking.DATE.getCsvHeader(), convertDate(createdAt));

            convertedRecords.add(record);
        }

        return convertedRecords;
    }

    private String convertDate(String stringTimeStamp) {
        Timestamp timeStamp = new Timestamp(Long.valueOf(stringTimeStamp));
        LocalDateTime localDateTime = timeStamp.toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
