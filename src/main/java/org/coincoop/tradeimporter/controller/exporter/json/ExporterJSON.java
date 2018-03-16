package org.coincoop.tradeimporter.controller.exporter.json;

import java.util.List;

import org.coincoop.tradeimporter.controller.exporter.Exporter;
import org.coincoop.tradeimporter.controller.format.Record;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ExporterJSON implements Exporter {

    public void export(List<String> headers, List<Record> records, String fileName) {
        throw new NotImplementedException();
    }
}
