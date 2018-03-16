package org.coincoop.tradeimporter.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.coincoop.tradeimporter.controller.client.KuCoinClient;
import org.coincoop.tradeimporter.controller.converter.Converter;
import org.coincoop.tradeimporter.controller.exporter.Exporter;
import org.coincoop.tradeimporter.controller.exporter.csv.ExporterCSV;
import org.coincoop.tradeimporter.controller.format.Format;
import org.coincoop.tradeimporter.controller.format.Record;
import org.coincoop.tradeimporter.controller.format.exchange.CoinTracking;
import org.coincoop.tradeimporter.controller.importer.Importer;
import org.coincoop.tradeimporter.controller.importer.json.KuCoinImporterJSON;

public class ImporterWorker extends SwingWorker<Boolean, String> {

    private static void failIfInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("Interrupted while importing");
        }
    }

    private final String apiKey;
    private final String secretKey;
    private final JTextArea messagesTextArea;
    private final File file;

    /**
     * Creates an instance of the worker.
     *
     * @param apiKey
     *          API key
     * @param secretKey
     *          secret key
     * @param messagesTextArea
     *          The text area where messages are written
     */
    public ImporterWorker(final String apiKey, final String secretKey, final JTextArea messagesTextArea, final File file) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.messagesTextArea = messagesTextArea;
        this.file = file;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        publish("Importing was started...");

        KuCoinClient kuCoinClient = new KuCoinClient(apiKey.trim(), secretKey.trim());
        List<String> symbols = kuCoinClient.getTradingSymbols();
        Importer importer = new KuCoinImporterJSON();

        List<Record> records = new ArrayList<>();

        for (String symbol : symbols) {
            publish("Importing trades for symbol " + symbol);
            List<Record> chunks = importer.importChunks(apiKey.trim(), secretKey.trim(), symbol);
            records.addAll(chunks);
            ImporterWorker.failIfInterrupted();
            publish("Imported trades: " + chunks.size());
        }
        publish(records.size() + " records was imported", "Starting conversion...");

        Converter converter = new Converter();
        records = converter.convert(Format.KU_COIN, Format.COIN_TRACKING, records);
        ImporterWorker.failIfInterrupted();

        ArrayList<String> headers = new ArrayList<>();
        headers.add(CoinTracking.TYPE.getCsvHeader());
        headers.add(CoinTracking.BUY_AMOUNT.getCsvHeader());
        headers.add(CoinTracking.BUY_CURRENCY.getCsvHeader());
        headers.add(CoinTracking.SELL_AMOUNT.getCsvHeader());
        headers.add(CoinTracking.SELL_CURRENCY.getCsvHeader());
        headers.add(CoinTracking.FEE.getCsvHeader());
        headers.add(CoinTracking.FEE_CURRENCY.getCsvHeader());
        headers.add(CoinTracking.EXCHANGE.getCsvHeader());
        headers.add(CoinTracking.GROUP.getCsvHeader());
        headers.add(CoinTracking.COMMENT.getCsvHeader());
        headers.add(CoinTracking.DATE.getCsvHeader());

        String filePath;

        if (Objects.nonNull(file)) {
            filePath = file.getAbsolutePath();
            if (filePath.endsWith("/") || filePath.endsWith("\\")) {
                filePath = filePath + "records.csv";
            } else if (!filePath.endsWith(".csv")) {
                filePath = filePath + ".csv";
            }
        } else {
            filePath = "records.csv";
        }

        Exporter exporter = new ExporterCSV();
        exporter.export(headers, records, filePath);

        ImporterWorker.failIfInterrupted();
        publish("Records were saved to path: " + filePath);
        return true;
    }

    @Override
    protected void process(final List<String> chunks) {
        for (final String string : chunks) {
            messagesTextArea.append(string);
            messagesTextArea.append("\n");
        }
    }
}
