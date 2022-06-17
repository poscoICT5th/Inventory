package Pack.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Delivery;

import Pack.service.InventoryService;
import Pack.vo.InventoryDTO;
import Pack.vo.InventoryVo;
import Pack.vo.LogiVo;

import org.springframework.amqp.rabbit.annotation.*;

import java.util.HashMap;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;

@Component
public class MessageListener {
	@Autowired
	InventoryService inventoryService;
	@RabbitListener(
		bindings = @QueueBinding(
			exchange = @Exchange(name="posco", type=ExchangeTypes.TOPIC),
			value=@Queue(name="toInventory"),
			key="*.Inventory.*"))
	public void receiver(Message message, LogiVo logiVo ) {
		System.out.println("add object 받음");
		System.out.println(logiVo);
		String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
		System.out.println(receivedRoutingKey);
		String receiveCMD = receivedRoutingKey.split("\\.")[2];
		try {
			if (receiveCMD.equals("add")) {
				InventoryDTO inventoryDTO = new InventoryDTO(logiVo);
				System.out.println("add 들어옴");
				int result = inventoryService.insert(inventoryDTO);
			} else if (receiveCMD.equals("update")) {
				System.out.println("update들어옴");
			int result = inventoryService.move(logiVo);
			} else {
				System.out.println("reduce들어옴");
				InventoryVo inventoryVo = inventoryService.selectByLotNo(logiVo.getLot_no());
				System.out.println(inventoryVo);
				if (logiVo.getEx_amount() <= inventoryVo.getAmount()) {
					int result = inventoryService.reduce(logiVo);							
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("다시 listen중");
	}
}