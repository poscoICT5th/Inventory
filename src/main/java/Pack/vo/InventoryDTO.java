package Pack.vo;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import lombok.*;

@ToString 
@Getter
@Setter
public class InventoryDTO {
	String lot_no;
	String industry_family;
	String stock_type;
	String product_family;
	String state;
	String location;
	String warehouse_code;
	String item_code;
	String item_name;
	int amount;
	String unit;
	float weight;
	float width;
	float thickness;
	float height;
	String customer;
	String stock_quality_status;
	String status_cause;
	int sum;
	String inventory_date;
	String warehouse_date;
	int fixed_month;
	int warehouse_aging;
	
	public InventoryDTO(LogiVo logiVo) {
		System.out.println("logiVo");
		this.lot_no = logiVo.getLot_no();
		this.industry_family = logiVo.getIndustry_family();
		this.stock_type = logiVo.getStock_type();
		this.product_family = logiVo.getProduct_family();
		this.state = logiVo.getState();
		this.location = logiVo.getLocation();
		this.warehouse_code = logiVo.getTo_warehouse();
		this.item_code = logiVo.getItem_code();
		this.item_name = logiVo.getItem_name();
		this.amount = logiVo.getAmount();
		this.unit = logiVo.getUnit();
		this.weight = logiVo.getWeight();
		this.width = logiVo.getWidth();
		this.thickness = logiVo.getThickness();
		this.height = logiVo.getHeight();
		this.customer = logiVo.getCustomer();
		this.stock_quality_status = logiVo.getStock_quality_status();
		this.status_cause = logiVo.getStatus_cause();
		this.sum = 0;
		this.inventory_date = logiVo.getInventory_date();
		this.warehouse_date = logiVo.getWarehouse_date();
		this.fixed_month = 0;
		this.warehouse_aging = 0;
	}
	
	public InventoryDTO(String industry_family, String stock_type, String product_family,
			String state, String location, String warehouse_code, String item_code, String item_name, int amount,
			String unit, float weight, float width, float thickness, float height, String customer,
			String stock_quality_status, String status_cause, int sum, String inventory_date, String warehouse_date,
			int fixed_month, int warehouse_aging) {
		System.out.println("mixData");
		long curTime = System.currentTimeMillis();
		String makeDate = new SimpleDateFormat("YYMMddHHmmssms").format(curTime);
		this.lot_no = product_family + makeDate;
		this.industry_family = industry_family;
		this.stock_type = stock_type;
		this.product_family = product_family;
		this.state = state;
		this.location = location;
		this.warehouse_code = warehouse_code;
		this.item_code = item_code;
		this.item_name = item_name;
		this.amount = amount;
		this.unit = unit;
		this.weight = weight;
		this.width = width;
		this.thickness = thickness;
		this.height = height;
		this.customer = customer;
		this.stock_quality_status = stock_quality_status;
		this.status_cause = status_cause;
		this.sum = sum;
		this.inventory_date = new SimpleDateFormat("YYYY-MM-dd").format(curTime);;
		this.warehouse_date = new SimpleDateFormat("YYYY-MM-dd").format(curTime);;
		this.fixed_month = fixed_month;
		this.warehouse_aging = warehouse_aging;
	}
	
}
