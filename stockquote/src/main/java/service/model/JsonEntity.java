package service.model;

import static service.util.JsonUtil.toJson;

public class JsonEntity {

    @Override
    public String toString() {
        return toJson(this);
    }

}
