package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.mapper.InventoryMapper;
import Pack.vo.InventoryDTO;
import Pack.vo.InventoryLocation;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;
import Pack.vo.LogiVo;

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
    
    public List<InventoryLocation> selectLocation(String location){
    	return mapper.selectLocation(location);
    }
    
    public int inventoryDel(String lotNo) {
    	return mapper.delete(lotNo);
    }
    
    public int inventoryUpd(String lotNo, InventoryUpd inventoryUpd) {
    	inventoryUpd.setLot_no(lotNo);
    	System.out.println(inventoryUpd);
    	return mapper.update(inventoryUpd);
    }

	public int insert(InventoryDTO inventoryDTO) {
		return mapper.insert(inventoryDTO);
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
}
