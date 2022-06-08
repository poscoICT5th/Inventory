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
	String item_num;
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
	
	public InventoryDTO(LogiImportVo logiImportVo) {
		this.industry_family = logiImportVo.getIndustry_family();
		this.location = logiImportVo.getLocation();
		this.product_family = logiImportVo.getProduct_family();
		this.warehouse_code = logiImportVo.getTo_warehouse();
		this.lot_no = logiImportVo.getLot_no();
		this.item_num = logiImportVo.getItem_no();
		this.item_desc = "";
		this.item_name = logiImportVo.getItem_name();
		this.amount = logiImportVo.getAmount();
		this.weight = logiImportVo.getWeight();
		this.unit = logiImportVo.getUnit();
		this.customer = logiImportVo.getCustomer();
		this.fixed_month = 0;
		this.width = logiImportVo.getWidth();
		this.thickness = logiImportVo.getThickness();
		this.height = logiImportVo.getHeight();
	}
}
