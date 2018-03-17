/*

 */

package org.coincoop.kucointradeexport.controller.importer.csv;

import java.util.ArrayList;
import java.util.List;

import org.coincoop.kucointradeexport.controller.format.Record;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImporterCSVTest {

    private static List<String> headers;
    private String fileName = "src/test/resources/records.csv";

    @BeforeClass
    public static void prepareData() {
        headers = new ArrayList<>();
        headers.add("Write");
        headers.add("Test");
        headers.add("Result");
    }

    @AfterClass
    public static void clean() {

    }

    @Test
    public void shouldImport() throws Exception {
        ImporterCSV importerCSV = new ImporterCSV();

        List<Record> records = importerCSV.imports(headers, fileName);

        assertEquals("Record was not imported correctly!", "import", records.get(1).getValueByKey("Write"));
    }
}
