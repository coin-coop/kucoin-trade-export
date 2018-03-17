/*

 */

package org.coincoop.kucointradeexport.controller.importer.csv;

import java.util.ArrayList;
import java.util.List;

import org.coincoop.kucointradeexport.controller.format.Record;
import org.coincoop.kucointradeexport.controller.importer.json.ImporterJSON;
import org.coincoop.kucointradeexport.controller.importer.json.KuCoinImporterJSON;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KuCoinImporterJSONTest {

    private static List<String> keys;
    private String fileName = "src/test/resources/test_kucoin.json";

    @BeforeClass
    public static void prepareData() {
        keys = new ArrayList<>();
        keys.add("Write");
        keys.add("Test");
        keys.add("Result");
    }

    @AfterClass
    public static void clean() {

    }

    @Test
    public void shouldImportFromFile() throws Exception {
        ImporterJSON importerJSON = new KuCoinImporterJSON();

        List<Record> records = importerJSON.imports(keys, fileName);
        String expected = records.get(1).getValueByKey("createdAt");

        assertEquals("Record was not imported correctly!", "1508219588000", expected);
    }
}
