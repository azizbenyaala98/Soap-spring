package com.tekup.project;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteItemRequest", namespace = "http://www.tekup.com/xml/store")
public class DeleteItemRequest {
    private String name;

    public String getName() {
        return name;
    }

    @XmlElement(name = "name", namespace = "http://www.tekup.com/xml/store")
    public void setName(String firstName) {
        this.name = name;
    }
}
