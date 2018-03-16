/*

 */

package org.coincoop.tradeimporter.controller.exporter.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.coincoop.tradeimporter.controller.exporter.Exporter;
import org.coincoop.tradeimporter.controller.format.Record;

public class ExporterCSV implements Exporter  {

    public void export(List<String> headers, List<Record> records, String fileName) throws IOException {
        if (Objects.isNull(headers)) {
            headers = getHeaders(records);
        }

        String[] headersArray = headers.toArray(new String[0]);

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headersArray))) {
            addRecords(csvPrinter, headers, records);
        }
    }

    private void addRecords(CSVPrinter csvPrinter, List<String> headers, List<Record> records) throws IOException {
        for (Record value : records) {
            List<Object> orderedRecord = new ArrayList<>();
            for (String header : headers) {
                orderedRecord.add(value.getValueByKey(header));
            }
            csvPrinter.printRecord(orderedRecord);
        }

        csvPrinter.flush();
    }

    private List<String> getHeaders(List<Record> records) {
        List<String> headers = new ArrayList<>();
        if (!records.isEmpty()) {
            Record record = records.get(0);
            headers.addAll(record.getValues().keySet());
        }

        return headers;
    }
}
