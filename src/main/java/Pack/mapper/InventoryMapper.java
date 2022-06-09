package Pack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import Pack.vo.InventoryDTO;
import Pack.vo.InventoryLocation;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;
import Pack.vo.LogiVo;

@Repository
@Mapper
public interface InventoryMapper {
	List<InventoryVo> selectAll();
    
    List<InventoryVo> selectSome(InventorySch inventorySch);
    
    List<InventoryWarehouse> selectWarehouse(String warehouseCode);
    
    List<InventoryLocation> selectLocation(String location);
    
    int delete(String lotNo);
    
    int update(InventoryUpd inventoryUpd);

    int insert(InventoryDTO inventoryDTO);

	InventoryVo selectByLotNo(String lot_no);

	int reduce(LogiVo logiVo);

	int move(LogiVo logiVo);

}
