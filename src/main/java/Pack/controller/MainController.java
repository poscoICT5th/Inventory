package Pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Pack.service.InventoryService;
import Pack.service.TestService;
import Pack.vo.InventoryAmount;
import Pack.vo.InventoryCustomer;
import Pack.vo.InventoryDeleteList;
import Pack.vo.InventoryItemname;
import Pack.vo.InventoryMap;
import Pack.vo.InventoryProduceDTO;
import Pack.vo.InventorySch;
import Pack.vo.InventoryUpd;
import Pack.vo.InventoryVo;
import Pack.vo.InventoryWarehouse;
import Pack.vo.ResultDTO;
import Pack.vo.StatusChangeInfo;
import Pack.vo.TestVo;
import Pack.vo.TrendAll;
import Pack.vo.TrendInfo;
import Pack.vo.TrendInfoByYM;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	InventoryService inventoryService;
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public List test() {
		System.out.println("test");
	    ModelAndView mav = new ModelAndView("test");

	    List<TestVo> testList = testService.selectTest();
	    System.out.println(testList);
	    mav.addObject("list", testList);

	    return testList;
	}
	
	@GetMapping("/")
	public List inventory() {
		System.out.println("inventorySelect");
	    List<InventoryVo> inventoryList = inventoryService.selectAll();
	    System.out.println(inventoryList.size());
	    return inventoryList;
	}
	
	@GetMapping("/lotno/{lot_no}")
	public InventoryVo selectOneByLotno(@PathVariable String lot_no) {
		System.out.println("inventorySelectOneByLotno");
		InventoryVo inventoryitem = inventoryService.selectByLotNo(lot_no);
		System.out.println(inventoryitem);
		return inventoryitem;
	}
	
	@GetMapping("/search")
	public List inventorySch(InventorySch inventorySch) {
		System.out.println("inventorySearch");
		System.out.println(inventorySch);
		List<InventoryVo> inventorySearch = inventoryService.selectSome(inventorySch);
		System.out.println(inventorySearch.size());
		return inventorySearch;
	}
	
	@GetMapping("/trend")
	public List<TrendInfo> getTrendInfo() {
		return inventoryService.getTrendInfo();
	}
	
	@GetMapping("/trend/year/{year}/month/{month}")
	public List<TrendInfoByYM> getTrendByYearMonth(@PathVariable String year, @PathVariable String month) {
		System.out.println("trendby mon year");
		System.out.println(year + " : " + month);
		return inventoryService.getTrendByYearMonth(year, month);
	}
	
	@GetMapping("/trendAll")
	public List<TrendAll> getTrendAll() {
		System.out.println("trendAll");
		return inventoryService.getTrendAll();
	}
	
	
	@GetMapping("/warehouse/{warehouseCode}")
	public List<InventoryVo> inventoryByWarehouse(@PathVariable("warehouseCode") String warehouseCode) {
		System.out.println("inventoryWarehouse");
		List<InventoryVo> inventoryWarehouse = inventoryService.selectWarehouse(warehouseCode);
		System.out.println(inventoryWarehouse.size());
		return inventoryWarehouse;
	}
	
	@GetMapping("/inventory/{location}")
	public List<InventoryItemname> inventoryItemname(@PathVariable("location") String location) {
		System.out.println("inventoryItemnameLocation");
		List<InventoryItemname> inventoryItemname = inventoryService.selectItemname(location);
		System.out.println(inventoryItemname.size());
		return inventoryItemname;
	}
	
	@GetMapping("/inventory/customer/{location}")
	public List inventoryCustomer(@PathVariable("location") String location) {
		System.out.println("inventoryCustomerLocation");
		List<InventoryCustomer> inventoryCustomer = inventoryService.selectCustomer(location);
		System.out.println(inventoryCustomer.size());
		return inventoryCustomer;
	}
	
//	@GetMapping("/map")	
//	public HashMap<String, Object> selectToMap() {
//		System.out.println("map data 요청");
//		HashMap result = inventoryService.selectToMap();
//		return result;
//	}
	
	@GetMapping("/map/{location}")
	public List inventoryMap(@PathVariable("location") String location) {
		System.out.println("inventoryMap");
		List<InventoryMap> inventoryMap = inventoryService.selectMap(location);
		System.out.println(inventoryMap.size());
		return inventoryMap;
	}
	
	@GetMapping("/aging")
	public List inventoryAging() {
		System.out.println("inventoryAging");
	    List<InventoryVo> inventoryList = inventoryService.selectAging();
	    System.out.println(inventoryList.size());
	    return inventoryList;
	}
	
	@GetMapping("/amount")
	public List inventoryAmount() {
		System.out.println("inventoryAmount");
		List<InventoryVo> inventoryList = inventoryService.selectAmount();
		System.out.println(inventoryList.size());
		return inventoryList;
	}

	@GetMapping("/location/{location}/warehouse/{warehouseCode}")	
	public List<InventoryVo> selectByLocAndWare(@PathVariable String location, @PathVariable String warehouseCode) {
		System.out.println(location + " 지역의 " + warehouseCode + " 창고 데이터 요청");
		List<InventoryVo> result = inventoryService.selectByLocAndWare(location, warehouseCode);
		return result;
	}
	//
	@DeleteMapping("/{lotNo}")
	public ResultDTO inventoryDel(@PathVariable("lotNo") String lotNo) {
		System.out.println("delete");
		System.out.println(lotNo);
		int result = inventoryService.inventoryDel(lotNo);
		return new ResultDTO(result);
	}
	
	@DeleteMapping("/")
	public ResultDTO inventoryDels(@RequestBody InventoryDeleteList inventoryDeleteList) {
		System.out.println("delete List");
		System.out.println(inventoryDeleteList);
		int result = inventoryService.inventoryDels(inventoryDeleteList);
		return new ResultDTO(result);
	}
	
	@PutMapping("/{lotNo}")
	public ResultDTO inventoryUpd(@PathVariable("lotNo") String lotNo, @RequestBody InventoryUpd inventoryUpd) {
		System.out.println(lotNo);
		System.out.println(inventoryUpd);
		int result = inventoryService.inventoryUpd(lotNo, inventoryUpd);
		return new ResultDTO(result);
	}
	

	@PostMapping("/produce")
	public ResultDTO inventoryProduce(@RequestBody InventoryProduceDTO data) {
//	public boolean inventoryMix(@RequestBody HashMap<String, Object> data) {
		System.out.println("post 들어감");
		System.out.println(data); 
		int result = inventoryService.produce(data);
//		return true;
		return new ResultDTO(result);
	}

	@PutMapping("/statuschange")
	public ResultDTO statusChange(@RequestBody StatusChangeInfo statusChangeInfo) {
		System.out.println("post 들어감");
		System.out.println(statusChangeInfo); 
		int result = inventoryService.statusChange(statusChangeInfo);
		return new ResultDTO(result);
	}
}
