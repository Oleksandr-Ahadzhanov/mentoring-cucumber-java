package apiModel;

import apiModel.reqres_model_parts.SingleUserSupport;
import apiModel.reqres_model_parts.SingleUserData;

public class SingleUserModel {

    private SingleUserData data;
    private SingleUserSupport support;

    public SingleUserModel() {}
    public SingleUserModel(SingleUserData data, SingleUserSupport support) {
        this.data = data;
        this.support = support;
    }

    public SingleUserData getData() {
        return data;
    }

    public void setData(SingleUserData data) {
        this.data = data;
    }

    public SingleUserSupport getSupport() {
        return support;
    }

    public void setSupport(SingleUserSupport support) {
        this.support = support;
    }
}
