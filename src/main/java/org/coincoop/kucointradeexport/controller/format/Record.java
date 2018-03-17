/*

 */

package org.coincoop.kucointradeexport.controller.format;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private Map<String,String> values = new HashMap<>();

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    public String getValueByKey(String key) {
        return this.values.get(key);
    }

    public void put(String key, String value) {
        this.values.put(key, value);
    }
}
