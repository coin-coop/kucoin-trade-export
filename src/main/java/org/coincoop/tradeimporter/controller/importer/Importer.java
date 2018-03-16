/*

 */

package org.coincoop.tradeimporter.controller.importer;

import java.io.IOException;
import java.util.List;

import org.coincoop.tradeimporter.controller.format.Record;

public interface Importer {

    List<Record> imports(List<String> headers, String fileName) throws IOException;

    List<Record> imports(String apiKey, String secretKey) throws IOException;

    List<Record> importChunks(String apiKey, String secretKey, String symbol) throws IOException;
}
