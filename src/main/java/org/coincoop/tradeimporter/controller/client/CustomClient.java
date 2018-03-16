/*

 */

package org.coincoop.tradeimporter.controller.client;

import java.io.IOException;
import java.util.List;
import javax.json.JsonObject;

public interface CustomClient {

    JsonObject getUserInfo() throws IOException;

    List<JsonObject> getTradingHistory() throws IOException;
}
