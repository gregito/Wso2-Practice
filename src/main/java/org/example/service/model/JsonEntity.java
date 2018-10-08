package org.example.service.model;

import static org.example.service.util.JsonUtil.toJson;

public class JsonEntity {

    @Override
    public String toString() {
        return toJson(this);
    }

}
