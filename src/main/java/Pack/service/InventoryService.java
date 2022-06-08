package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.mapper.InventoryMapper;
import Pack.vo.InventoryCustomer;
import Pack.vo.InventoryItemname;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;

@Service
public class InventoryService {
	@Autowired
    public InventoryMapper mapper;
    
    public List<InventoryVo> selectAll() {
        return mapper.selectAll();
    }
    
    public List<InventoryVo> selectSome(InventorySch inventorySch){
    	return mapper.selectSome(inventorySch);
    }
    
    public List<InventoryWarehouse> selectWarehouse(String warehouseCode){
    	return mapper.selectWarehouse(warehouseCode);
    }
    
    public List<InventoryItemname> selectItemname(String location){
    	return mapper.selectItemname(location);
    }
    
    public List<InventoryCustomer> selectCustomer(String location){
    	return mapper.selectCustomer(location);
    }
    
    public int inventoryDel(String lotNo) {
    	return mapper.delete(lotNo);
    }
    
    public int inventoryUpd(String lotNo, InventoryUpd inventoryUpd) {
    	inventoryUpd.setLot_no(lotNo);
    	System.out.println(inventoryUpd);
    	return mapper.update(inventoryUpd);
    }
}
