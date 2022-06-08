package Pack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import Pack.vo.InventoryCustomer;
import Pack.vo.InventoryItemname;
import Pack.vo.InventoryDTO;
import Pack.vo.InventoryLocation;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;

@Repository
@Mapper
public interface InventoryMapper {
	List<InventoryVo> selectAll();
    
    List<InventoryVo> selectSome(InventorySch inventorySch);
    
    List<InventoryWarehouse> selectWarehouse(String warehouseCode);
    
    List<InventoryItemname> selectItemname(String location);
    
    List<InventoryCustomer> selectCustomer(String location);
    
    int delete(String lotNo);
    
    int update(InventoryUpd inventoryUpd);

    int update(InventoryDTO inventoryDTO);

    int insert(InventoryDTO inventoryDTO);

}
