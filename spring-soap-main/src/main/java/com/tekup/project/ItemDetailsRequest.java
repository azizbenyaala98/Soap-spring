package com.tekup.project;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemDetailsRequest", namespace = "http://www.tekup.com/xml/store")
public class ItemDetailsRequest {

    private String name;

    public String getName() {
        return name;
    }

    @XmlElement(name = "name", namespace = "http://www.tekup.com/xml/store")
    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

}
