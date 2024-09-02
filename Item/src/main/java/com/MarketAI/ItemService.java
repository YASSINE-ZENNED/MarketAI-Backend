package com.MarketAI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    public Item CreateItem(Item item) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/client/isClient?id="  + item.getSellerId();

        Boolean isClient = restTemplate.getForObject(url, Boolean.class);

        System.out.println("isClient = " + isClient);

        if ( item.getSellerId()==null || item.getName()==null || item.getPrice()==null || item.getCategory()==null ){
            throw new RuntimeException("not all required fields are filled in");
        }
        if (!isClient) {
            throw new RuntimeException("seller is not a client");
        }


        return itemRepository.save(item);
    }


    public List<Item> GetAllItems() { return itemRepository.findAll();
    }

    public Item GetItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void DeleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item UpdateItem(Long id, Item item) { return itemRepository.save(item); }

}
