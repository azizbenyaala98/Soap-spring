package com.tekup.project;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreateItemRequest", namespace = "http://www.tekup.com/xml/store")
public class CreateItemRequest {

    private String name;

    private String description;

    private int price;

    public String getName() {
        return name;
    }

    @XmlElement(name = "name", namespace = "http://www.tekup.com/xml/store")
    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    @XmlElement(name = "description", namespace = "http://www.tekup.com/xml/store")
    public void setDescription(String description) {
        this.description = description;
    }


    public int getPrice() {
        return price;
    }

    @XmlElement(name = "price", namespace = "http://www.tekup.com/xml/store")
    public void setPrice(int price) {
        this.price = price;
    }
}
