/*

 */

package org.coincoop.tradeimporter.controller.importer.csv;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.coincoop.tradeimporter.controller.format.Record;
import org.coincoop.tradeimporter.controller.importer.json.ImporterJSON;
import org.coincoop.tradeimporter.controller.importer.json.KuCoinImporterJSON;
import org.junit.Ignore;
import org.junit.Test;

public class KuCoinImporterJSONIT {

    @Ignore("TODO: fin a way for testing without keys")
    @Test
    public void shouldImportFromServer() throws Exception {
        ImporterJSON importerJSON = new KuCoinImporterJSON();

        List<Record> records = importerJSON.imports("", "");
        int expected = records.size();

        assertEquals("Record was not imported correctly!", 20, expected);
    }
}
