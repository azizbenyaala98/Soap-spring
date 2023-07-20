package com.tekup.project;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UpdateItemResponse", namespace = "http://www.tekup.com/xml/store")
public class UpdateItemResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message", namespace = "http://www.tekup.com/xml/store")
    public void setMessage(String message) {
        this.message = message;
    }
}
