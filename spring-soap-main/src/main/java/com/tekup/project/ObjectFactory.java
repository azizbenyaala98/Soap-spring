package com.tekup.project;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private static final QName ITEM_DETAILS_REQUEST_QNAME = new QName("http://www.tekup.com/xml/store", "ItemDetailsRequest");
    private static final QName ITEM_DETAILS_RESPONSE_QNAME = new QName("http://www.tekup.com/xml/store", "ItemDetailsResponse");

    public ObjectFactory() {
    }

    public ItemDetailsRequest createItemDetailsRequest() {
        return new ItemDetailsRequest();
    }

    public ItemDetailsResponse createItemDetailsResponse() {
        return new ItemDetailsResponse();
    }

    public Item createItem() {
        return new Item();
    }

    @XmlElementDecl(namespace = "http://www.tekup.com/xml/store", name = "ItemDetailsRequest")
    public JAXBElement<ItemDetailsRequest> createItemDetailsRequest(ItemDetailsRequest value) {
        return new JAXBElement<>(ITEM_DETAILS_REQUEST_QNAME, ItemDetailsRequest.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.tekup.com/xml/store", name = "ItemDetailsResponse")
    public JAXBElement<ItemDetailsResponse> createItemDetailsResponse(ItemDetailsResponse value) {
        return new JAXBElement<>(ITEM_DETAILS_RESPONSE_QNAME, ItemDetailsResponse.class, null, value);
    }
}
