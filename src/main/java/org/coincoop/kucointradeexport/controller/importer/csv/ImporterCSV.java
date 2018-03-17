/*

 */

package org.coincoop.kucointradeexport.controller.importer.csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.coincoop.kucointradeexport.controller.format.Record;
import org.coincoop.kucointradeexport.controller.importer.Importer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ImporterCSV implements Importer {

    @Override
    public List<Record> imports(List<String> headers, String fileName) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                     .withIgnoreHeaderCase().withTrim())) {
            return getRecords(csvParser, headers);
        }
    }

    @Override
    public List<Record> imports(String apiKey, String secretKey) {
        throw new NotImplementedException();
    }

    @Override
    public List<Record> importChunks(String apiKey, String secretKey, String symbol) {
        throw new NotImplementedException();
    }

    private List<Record> getRecords(CSVParser csvParser, List<String> headers) throws IOException {
        List<Record> results = new ArrayList<>();
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            results.add(getRecord(csvRecord, headers));
        }

        return results;
    }

    private Record getRecord(CSVRecord csvRecord, List<String> headers) {
        Record records = new Record();

        for (String header : headers) {
            records.put(header, csvRecord.get(header));
        }

        return records;
    }
}
