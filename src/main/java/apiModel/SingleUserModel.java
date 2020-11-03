package apiModel;

import apiModel.reqres_model_parts.SingleUserAd;
import apiModel.reqres_model_parts.SingleUserData;

public class SingleUserModel {

    private SingleUserData data;
    private SingleUserAd ad;

    public SingleUserModel() {}
    public SingleUserModel(SingleUserData data, SingleUserAd ad) {
        this.data = data;
        this.ad = ad;
    }

    public SingleUserData getData() {
        return data;
    }

    public void setData(SingleUserData data) {
        this.data = data;
    }

    public SingleUserAd getAd() {
        return ad;
    }

    public void setAd(SingleUserAd ad) {
        this.ad = ad;
    }
}
