package Pack.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.mapper.InventoryMapper;
import Pack.vo.InventoryAmount;
import Pack.vo.InventoryCustomer;
import Pack.vo.InventoryItemname;
import Pack.vo.InventoryMap;
import Pack.vo.InventoryProduceDTO;
import Pack.vo.InventoryDTO;
import Pack.vo.InventoryDeleteList;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;
import Pack.vo.LogiVo;
import Pack.vo.ProcessingVo;
import Pack.vo.SendTraceDTO;
import Pack.vo.StatusChangeInfo;
import Pack.vo.TrendInfo;

@Service
public class InventoryService {
	@Autowired
    public InventoryMapper mapper;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
    
    public List<InventoryVo> selectAll() {
        return mapper.selectAll();
    }
    
    public List<InventoryVo> selectSome(InventorySch inventorySch){
    	return mapper.selectSome(inventorySch);
    }
    
    public List<InventoryVo> selectWarehouse(String warehouseCode){
    	return mapper.selectWarehouse(warehouseCode);
    }
    
    public List<InventoryItemname> selectItemname(String location){
    	return mapper.selectItemname(location);
    }
    
    public List<InventoryCustomer> selectCustomer(String location){
    	return mapper.selectCustomer(location);
    }
    
    public List<InventoryVo> selectAging() {
    	return mapper.selectAging();
    }
    
    public List<InventoryVo> selectAmount(){
    	return mapper.selectAmount();
    }
    
    public List<InventoryMap> selectMap(){
    	return mapper.selectMap();
    }
    
    public int inventoryDel(String lotNo) {
    	return mapper.delete(lotNo);
    }
    
    public int inventoryDels(InventoryDeleteList inventoryDeleteList) {
    	return mapper.deletes(inventoryDeleteList.getInventoryDeleteList());
    }
    
    public int inventoryUpd(String lotNo, InventoryUpd inventoryUpd) {
    	inventoryUpd.setLot_no(lotNo);
    	System.out.println(inventoryUpd);
    	return mapper.update(inventoryUpd);
    }

	public int insert(InventoryDTO inventoryDTO) {
		return mapper.insert(inventoryDTO);
	}
	
	public int produce(InventoryProduceDTO inventoryProduceDTO) {
		int result = mapper.produce(inventoryProduceDTO);
		if (result > 1) {
			rabbitTemplate.convertAndSend("posco", "import.Traceback.manufacture", new SendTraceDTO(inventoryProduceDTO));
		}
		return result;
	}

	public InventoryVo selectByLotNo(String lot_no) {
		return mapper.selectByLotNo(lot_no);
	}

	public int reduce(LogiVo logiVo) {
		return mapper.reduce(logiVo);
	}

	public int move(LogiVo logiVo) {
		return mapper.move(logiVo);
	}

	public HashMap selectToMap() {
		HashMap<String, HashMap> result = new HashMap<String, HashMap>();
		List<InventoryVo> resultToMap = mapper.selectAll();
		System.out.println("들어옴?");
		int cnt = 0;
		for (InventoryVo inventoryVo : resultToMap) {
			HashMap<String, Object> locationMap = new HashMap<>();
			HashMap<String, Object> wareMap = new HashMap<>();
			HashMap<String, Object> lotNoMap = new HashMap<>();
			lotNoMap.put("재고량", inventoryVo.getAmount());
			lotNoMap.put("제품명", inventoryVo.getItem_name());
			if (result.containsKey(inventoryVo.getLocation())) {
				HashMap<String, Object> tempLocationMap = result.get(inventoryVo.getLocation());
				if (tempLocationMap.containsKey(inventoryVo.getWarehouse_code())) {
					HashMap<String, Object> tempWareMap = (HashMap<String, Object>) tempLocationMap.get(inventoryVo.getWarehouse_code());
					tempWareMap.put(inventoryVo.getLot_no(), lotNoMap);
				} else {
					wareMap.put(inventoryVo.getLot_no(), lotNoMap);
					tempLocationMap.put(inventoryVo.getWarehouse_code() ,wareMap);
				}
			} else {
				wareMap.put(inventoryVo.getLot_no(), lotNoMap);
				locationMap.put(inventoryVo.getWarehouse_code() ,wareMap);
				result.put(inventoryVo.getLocation(), locationMap);
			}
			cnt++;
		}
		System.out.println(cnt);
		return result;
	}

	public List<InventoryVo> selectByLocAndWare(String location, String warehouseCode) {
		HashMap locAndWare = new HashMap();
		locAndWare.put("location", location);
		locAndWare.put("warehouseCode", warehouseCode);		
		return mapper.selectByLocAndWare(locAndWare);
	}

	public List<TrendInfo> getTrendInfo() {
		return mapper.getTrendInfo();
	}

	public int statusChange(StatusChangeInfo statusChangeInfo) {
		return mapper.statusChange(statusChangeInfo);
	}

	public int processing(ProcessingVo processingVo) {
		return mapper.processing(processingVo);
	}

	public int processDone(LogiVo logiVo) {
		return mapper.processDone(logiVo);
	}
}
