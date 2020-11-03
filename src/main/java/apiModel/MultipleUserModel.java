package apiModel;

import apiModel.reqres_model_parts.SingleUserAd;
import apiModel.reqres_model_parts.SingleUserData;
import java.util.List;

public class MultipleUserModel {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private SingleUserAd ad;
    private List<SingleUserData> data;

    public MultipleUserModel(){}
    public MultipleUserModel(int page, int per_page, int total, int total_pages, SingleUserAd ad, List<SingleUserData> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.ad = ad;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public SingleUserAd getAd() {
        return ad;
    }

    public void setAd(SingleUserAd ad) {
        this.ad = ad;
    }

    public List<SingleUserData> getData() {
        return data;
    }

    public void setData(List<SingleUserData> data) {
        this.data = data;
    }
}
