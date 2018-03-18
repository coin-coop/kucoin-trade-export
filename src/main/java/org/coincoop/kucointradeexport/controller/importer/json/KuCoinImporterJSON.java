/*

 */

package org.coincoop.kucointradeexport.controller.importer.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.coincoop.kucointradeexport.controller.client.KuCoinClient;
import org.coincoop.kucointradeexport.controller.format.Record;

public class KuCoinImporterJSON extends ImporterJSON {

    @Override
    public List<Record> imports(String apiKey, String secretKey) throws IOException {
        KuCoinClient kuCoinClient = new KuCoinClient(apiKey, secretKey);
        List<JsonObject> jsonObjects = kuCoinClient.getTradingHistory();
        return getResults(jsonObjects, null);
    }

    @Override
    public List<Record> importChunks(String apiKey, String secretKey, String symbol) throws IOException {
        KuCoinClient kuCoinClient = new KuCoinClient(apiKey, secretKey);

        List<JsonObject> jsonObjects = kuCoinClient.getTradingHistory(symbol);
        return getResults(jsonObjects, null);
    }

    @Override
    public List<Record> importChunks(String apiKey, String secretKey, String symbol, Long before, Long since) throws IOException {
        KuCoinClient kuCoinClient = new KuCoinClient(apiKey, secretKey);

        List<JsonObject> jsonObjects = kuCoinClient.getTradingHistory(symbol, before, since);
        return getResults(jsonObjects, null);
    }

    protected List<Record> getResults(List<JsonObject> jsonObjects, List<String> keys) {
        List<Record> recordsList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            recordsList.addAll(getResults(jsonObject, keys));
        }
        return recordsList;
    }

    protected List<Record> getResults(JsonObject jsonObject, List<String> keys) {
        JsonObject dataJsonObject = jsonObject.getJsonObject("data");
        JsonArray jsonValues = dataJsonObject.getJsonArray("datas");

        return getRecords(jsonValues, keys);
    }

    private List<Record> getRecords(JsonArray jsonValues, List<String> keys) {
        List<Record> records = new ArrayList<>();

        for (JsonValue jsonValue : jsonValues) {
            JsonObject jsonObject = jsonValue.asJsonObject();

            Record record = new Record();

            record.put("createdAt", String.valueOf(jsonObject.getJsonNumber("createdAt")));
            record.put("amount", String.valueOf(jsonObject.getJsonNumber("amount")));
            record.put("dealValue", String.valueOf(jsonObject.getJsonNumber("dealValue")));
            record.put("dealPrice", String.valueOf(jsonObject.getJsonNumber("dealPrice")));
            record.put("fee", String.valueOf(jsonObject.getJsonNumber("fee")));
            record.put("feeRate", String.valueOf(jsonObject.getJsonNumber("feeRate")));
            record.put("oid", jsonObject.getString("oid"));
            record.put("orderOid", jsonObject.getString("orderOid"));
            record.put("coinType", jsonObject.getString("coinType"));
            record.put("coinTypePair", jsonObject.getString("coinTypePair"));
            record.put("direction", jsonObject.getString("direction"));
            record.put("dealDirection", jsonObject.getString("dealDirection"));

            records.add(record);
        }

        return records;
    }
}
