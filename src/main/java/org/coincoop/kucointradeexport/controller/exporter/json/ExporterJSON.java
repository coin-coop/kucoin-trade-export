package org.coincoop.kucointradeexport.controller.exporter.json;

import java.util.List;

import org.coincoop.kucointradeexport.controller.exporter.Exporter;
import org.coincoop.kucointradeexport.controller.format.Record;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ExporterJSON implements Exporter {

    public void export(List<String> headers, List<Record> records, String fileName) {
        throw new NotImplementedException();
    }
}
