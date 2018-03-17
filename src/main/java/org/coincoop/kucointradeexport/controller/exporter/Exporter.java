/*

 */

package org.coincoop.kucointradeexport.controller.exporter;

import java.io.IOException;
import java.util.List;

import org.coincoop.kucointradeexport.controller.format.Record;

public interface Exporter {

    void export(List<String> headers, List<Record> records, String fileName) throws IOException;
}
