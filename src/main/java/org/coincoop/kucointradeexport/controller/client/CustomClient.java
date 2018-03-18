/*

 */

package org.coincoop.kucointradeexport.controller.client;

import java.io.IOException;
import java.util.List;
import javax.json.JsonObject;

public interface CustomClient {

    JsonObject getUserInfo() throws IOException;

    List<JsonObject> getTradingHistory() throws IOException;

    List<JsonObject> getTradingHistory(Long before, Long since) throws IOException;

    List<JsonObject> getTradingHistory(String symbol) throws IOException;

    List<JsonObject> getTradingHistory(String symbol, Long before, Long since) throws IOException;
}
