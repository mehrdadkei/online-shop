package onlineShop.app.onlineShop.helper.ui;

import onlineShop.app.onlineShop.entities.people.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceResponse<t> implements Serializable {
    private List<t> dataList ;
    private String message;
    private long count;
    private ResponseStatus status;
    private boolean hasError;

    public ServiceResponse(ResponseStatus status,List<t> dataList) {
        this.dataList = dataList;
        this.status = status;
        this.message = "";
        this.count=0;
        this.hasError=false;
    }

    public ServiceResponse(ResponseStatus status,List<t> dataList,long count) {
        this.dataList = dataList;
        this.status = status;
        this.message = "";
        this.count=count;
        this.hasError=false;
    }

    public ServiceResponse(ResponseStatus status, t data) {
        this.dataList = new ArrayList<t>();
        this.status = status;
        this.dataList.add(data);
        this.message = "";
        this.count=0;
        this.hasError=false;
    }

    public ServiceResponse(ResponseStatus status, String message) {
        this.dataList = new ArrayList<t>();
        this.status = status;
        this.message =message;
        this.count=0;
        this.hasError= status==ResponseStatus.failed;
    }

    public ServiceResponse(Exception ex) {
        this.dataList = new ArrayList<t>();
        this.status = ResponseStatus.exception;
        this.message =ex.getMessage();
        this.count=0;
        this.hasError=true;
    }



    public List<t> getDataList() {
        return dataList;
    }

    public void setDataList(List<t> dataList) {
        this.dataList = dataList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}
