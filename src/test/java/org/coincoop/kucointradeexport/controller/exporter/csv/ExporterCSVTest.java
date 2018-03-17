/*

 */

package org.coincoop.kucointradeexport.controller.exporter.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.coincoop.kucointradeexport.controller.format.Record;
import org.coincoop.kucointradeexport.controller.importer.csv.ImporterCSV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExporterCSVTest {

    private static List<String> headers;
    private static List<Record> records;
    private static String fileName = "src/test/resources/results.csv";

    @BeforeClass
    public static void prepareData() {
        headers = new ArrayList<>();
        headers.add("Write");
        headers.add("Test");
        headers.add("Result");
        headers.add("Last");

        records = new ArrayList<>();
        Record map = new Record();
        map.put("Write", "export");
        map.put("Test", "1");
        map.put("Last", "should be");
        map.put("Result", "true");
        records.add(map);

        Record map2 = new Record();
        map2.put("Write", "import");
        map2.put("Last", "should be");
        map2.put("Test", "2");
        map2.put("Result", "false");
        records.add(map2);
    }

    @AfterClass
    public static void clean() {
        new File(fileName).delete();
    }

    @Test
    public void shouldExport() throws Exception {
        ExporterCSV exporterCSV = new ExporterCSV();

        exporterCSV.export(headers, records, fileName);
        List<Record> results =  new ImporterCSV().imports(headers, fileName);

        assertTrue("File was not created!", new File(fileName).exists());
        assertEquals("Record was not exported correctly!", "import", results.get(1).getValueByKey("Write"));

        exporterCSV.export(null, records, fileName);

        assertTrue("File was not created!", new File(fileName).exists());
        assertEquals("Record was not exported correctly!", "import", results.get(1).getValueByKey("Write"));
    }
}
