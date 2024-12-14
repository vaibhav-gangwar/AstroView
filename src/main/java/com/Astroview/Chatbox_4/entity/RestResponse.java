package com.Astroview.Chatbox_4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rest_response")
public class RestResponse {
    @Id
    private String id;

    @NotNull
    private String mobile;

    @NotNull
    private String status;

    @NotNull
    private String msgId;

    @NotNull
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestResponse(String id, String mobile, String status, String msgId, String message) {
        this.id = id;
        this.mobile = mobile;
        this.status = status;
        this.msgId = msgId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                ", msgId='" + msgId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public RestResponse() {

    }

}

