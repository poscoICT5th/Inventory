package Pack.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import Pack.vo.InventoryAmount;
import Pack.vo.InventoryCustomer;
import Pack.vo.InventoryItemname;
import Pack.vo.InventoryMap;
import Pack.vo.InventoryProduceDTO;
import Pack.vo.InventoryDTO;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;
import Pack.vo.LogiVo;
import Pack.vo.ProcessingVo;
import Pack.vo.StatusChangeInfo;
import Pack.vo.TrendAll;
import Pack.vo.TrendInfo;
import Pack.vo.TrendInfoByYM;

@Repository
@Mapper
public interface InventoryMapper {
	List<InventoryVo> selectAll();
    
    List<InventoryVo> selectSome(InventorySch inventorySch);
    
    List<InventoryVo> selectWarehouse(String warehouseCode);
    
    List<InventoryItemname> selectItemname(String location);
    
    List<InventoryCustomer> selectCustomer(String location);
    
    List<InventoryVo> selectAging();
    
    List<InventoryVo> selectAmount();
    
    List<InventoryMap> selectMap(String location);
    
    int delete(String lotNo);
    
    int deletes(List inventoryDeleteList);
    
    int update(InventoryUpd inventoryUpd);

    int insert(InventoryDTO inventoryDTO);
    
    int produce(InventoryProduceDTO inventoryProduceDTO);

	InventoryVo selectByLotNo(String lot_no);

	int reduce(LogiVo logiVo);

	int move(LogiVo logiVo);

	List<InventoryVo> selectToMap();

	List<InventoryVo> selectByLocAndWare(HashMap locAndWare);

	List<TrendInfo> getTrendInfo();

	int statusChange(StatusChangeInfo statusChangeInfo);

	int processing(ProcessingVo processingVo);

	int processDone(LogiVo logiVo);

	List<TrendInfoByYM> getTrendByYearMonth(String year, String month);

	List<TrendAll> getTrendAll();

}
