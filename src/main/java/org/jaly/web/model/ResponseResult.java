package org.jaly.web.model;

import java.util.Objects;

/**
 * Created by daboowifi on 16/2/18.
 */
public class ResponseResult {
    /*
     * 0 成功，-1失败
     */
    private int status;

    private String error;

    private int errorCode;

    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
