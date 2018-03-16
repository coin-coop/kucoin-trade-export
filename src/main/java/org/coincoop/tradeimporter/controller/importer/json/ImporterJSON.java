/*

 */

package org.coincoop.tradeimporter.controller.importer.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.coincoop.tradeimporter.controller.format.Record;
import org.coincoop.tradeimporter.controller.importer.Importer;

public abstract class ImporterJSON implements Importer {

    @Override
    public List<Record> imports(List<String> keys, String fileName) throws IOException {
        List<Record> results;

        try (InputStream inputStream = new FileInputStream(fileName);
             JsonReader reader = Json.createReader(inputStream)) {
            JsonObject jsonObject = reader.readObject();
            results = getResults(jsonObject, keys);
        }
        return results;
    }

    protected abstract List<Record> getResults(JsonObject jsonObject, List<String> keys);
}
