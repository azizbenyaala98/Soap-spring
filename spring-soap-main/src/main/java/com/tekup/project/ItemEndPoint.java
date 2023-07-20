package com.tekup.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
public class ItemEndPoint {
    private static final String NAMESPACE_URI = "http://www.tekup.com/xml/store";
    private ItemRepository itemRepository;

    @Autowired
    public ItemEndPoint(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IemDetailsRequest")
    @ResponsePayload
    public ItemDetailsResponse getItem(@RequestPayload ItemDetailsRequest request) {
        ItemDetailsResponse response = new ItemDetailsResponse();
        response.setItem(itemRepository.findItem(request.getName()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateItemRequest")
    @ResponsePayload
    public UpdateItemResponse createItem(@RequestPayload CreateItemRequest request) {
        UpdateItemResponse response = new UpdateItemResponse();
        Item item = new Item();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        itemRepository.createItem(item);
        response.setMessage("Item created successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateItemRequest")
    @ResponsePayload
    public UpdateItemResponse updateItem(@RequestPayload UpdateItemRequest request) {
        UpdateItemResponse response = new UpdateItemResponse();
        String name = request.getName();
        Item existingItem = itemRepository.findItem(name);
        if (existingItem != null) {
            Item updatedItem= new Item();
            updatedItem.setPrice(request.getPrice());
            updatedItem.setName(request.getNewName());
            updatedItem.setDescription(request.getDescription());

            itemRepository.updateItem(name, updatedItem);
            response.setMessage("Item updated successfully");
        } else {
            response.setMessage("Item not found");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteItemRequest")
    @ResponsePayload
    public UpdateItemResponse deleteItem(@RequestPayload DeleteItemRequest request) {
        UpdateItemResponse response = new UpdateItemResponse();
        String name = request.getName();
        Item existingEmployee = itemRepository.findItem(name);
        if (existingEmployee != null) {
            itemRepository.deleteItem(name);
            response.setMessage("Item deleted successfully");
        } else {
            response.setMessage("Item not found");
        }
        return response;
    }
}
