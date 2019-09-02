package com.etnetera.hr.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    private static final long serialVersionUID = -1447632100796181450L;

    private Long recordId;
    private Integer result; //Result of operation: 0 success, 1 error
    private String errorText;

    public ResponseModel(Long recordId, Integer result, String errorText) {
        this.recordId = recordId;
        this.result = result;
        this.errorText = errorText;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
