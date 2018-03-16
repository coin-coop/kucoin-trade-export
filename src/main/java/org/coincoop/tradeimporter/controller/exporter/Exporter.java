/*

 */

package org.coincoop.tradeimporter.controller.exporter;

import java.io.IOException;
import java.util.List;

import org.coincoop.tradeimporter.controller.format.Record;

public interface Exporter {

    void export(List<String> headers, List<Record> records, String fileName) throws IOException;
}
