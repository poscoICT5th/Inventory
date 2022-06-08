package Pack.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Delivery;

import Pack.service.InventoryService;
import Pack.vo.InventoryDTO;
import Pack.vo.LogiImportVo;

import org.springframework.amqp.rabbit.annotation.*;

import java.util.HashMap;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;

@Component
public class messageListener {
	@Autowired
	InventoryService inventoryService;
	@RabbitListener(
		bindings = @QueueBinding(
			exchange = @Exchange(name="posco", type=ExchangeTypes.TOPIC),
			value=@Queue(name="toInventory"),
			key="*.Inventory.*"))
	public void receiver(Message message, LogiImportVo logiImportVo ) {
		System.out.println("add object 받음");
		System.out.println(logiImportVo);
		String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
		System.out.println(receivedRoutingKey);
		String receiveCMD = receivedRoutingKey.split("\\.")[2];
		InventoryDTO inventoryDTO = new InventoryDTO(logiImportVo);
		if (receiveCMD.equals("add")) {
			System.out.println("add 들어옴");
			int result = inventoryService.insert(inventoryDTO);
		} else {
			System.out.println("else들어옴");
			int result = inventoryService.inventoryUpd(inventoryDTO);
		}
		System.out.println("다시 listen중");
	}
}