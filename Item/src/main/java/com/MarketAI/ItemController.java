package com.MarketAI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.support.KafkaHeaders;


import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemService.GetAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@RequestParam("id") Long id) {
        return itemService.GetItem(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item item) {

        Message<String> message = MessageBuilder
                .withPayload((item.getSellerId()+" "))
                .setHeader(KafkaHeaders.TOPIC, "clientValidationTopic")
                .build();


        kafkaTemplate.send(message);

        return itemService.CreateItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@RequestParam("id") Long id, @RequestBody Item item) {
        return itemService.UpdateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@RequestParam("id") Long id) {
        itemService.DeleteItem(id);
    }

}
