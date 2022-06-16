package Pack.vo;

import java.util.HashMap;

import lombok.Data;

@Data
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
		this.lot_no = logiVo.getLot_no();
		this.industry_family = logiVo.getIndustry_family();
		this.stock_type = logiVo.getStock_type();
		this.product_family = logiVo.getProduct_family();
		this.state = logiVo.getState();
		this.location = logiVo.getLocation();
		this.warehouse_code = logiVo.getWarehouse_code();
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
}
