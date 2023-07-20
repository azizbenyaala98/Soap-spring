package com.tekup.project;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemDetailsResponse", namespace = "http://www.tekup.com/xml/store")
public class ItemDetailsResponse {
    private Item item;

    public Item getItem() {
        return item;
    }

    @XmlElement(name = "Item", namespace = "http://www.tekup.com/xml/store")
    public void setItem(Item item) {
        this.item = item;
    }
}
