package Pack.vo;

import java.util.HashMap;

import lombok.Data;

@Data
public class InventoryDTO {
	String industry_family;
	String stock_type;
	String stock_quality_status;
	String status_cause;
	String location;
	String product_family;
	String warehouse_code;
	String lot_no;
	String item_no;
	String item_desc;
	String item_name;
	int amount;
	float weight;
	String unit;
	String customer;
	int fixed_month;
	float width;
	float thickness;
	float height;
	String inventory_date; //
	String warehouse_date; //
	
	public InventoryDTO(LogiVo logiVo) {
		this.industry_family = logiVo.getIndustry_family();
		this.location = logiVo.getLocation();
		this.product_family = logiVo.getProduct_family();
		this.warehouse_code = logiVo.getTo_warehouse();
		this.lot_no = logiVo.getLot_no();
		this.item_no = logiVo.getItem_no();
		this.item_desc = "";
		this.item_name = logiVo.getItem_name();
		this.amount = logiVo.getAmount();
		this.weight = logiVo.getWeight();
		this.unit = logiVo.getUnit();
		this.customer = logiVo.getCustomer();
		this.fixed_month = 0;
		this.width = logiVo.getWidth();
		this.thickness = logiVo.getThickness();
		this.height = logiVo.getHeight();
	}
}
