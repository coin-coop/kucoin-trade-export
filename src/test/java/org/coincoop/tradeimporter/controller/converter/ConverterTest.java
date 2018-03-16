package org.coincoop.tradeimporter.controller.converter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.coincoop.tradeimporter.controller.format.Format;
import org.coincoop.tradeimporter.controller.format.Record;
import org.coincoop.tradeimporter.controller.importer.json.KuCoinImporterJSON;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConverterTest {

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
    public void shouldConvert() throws Exception {
        Converter converter = new Converter();

        List<Record> importedRecords = new KuCoinImporterJSON().imports(keys, fileName);

        List<Record> records = converter.convert(Format.KU_COIN, Format.COIN_TRACKING, importedRecords);
        String expected = records.get(0).getValueByKey("Date");
        assertEquals("Record was not imported correctly!", "2017-10-17 07:53:08", expected);
    }

}
