package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventoryUpd {
	String industry_family;
	String target;
	String stock_type;
	String stock_quality_status;
	String status_cause;
	String location;
	String product_family;
	String warehouse_code;
	String lot_no;
	String Item_num;
	String Item_desc;
	String item_name;
	int amount;
	float weight;
	String unit;
	String customer;
	int fixed_month;
	float width;
	float thickness;
	float height;
	String inventory_date;
	String warehouse_date;
	int warehouse_aging;
	
	public InventoryUpd(String industry_family, String target, String stock_type, String stock_quality_status,
			String status_cause, String location, String product_family, String warehouse_code,
			String item_num, String item_desc, String item_name, int amount, float weight, String unit, String customer,
			int fixed_month, float width, float thickness, float height, String inventory_date, String warehouse_date,
			int warehouse_aging) {
		super();
		this.industry_family = industry_family;
		this.target = target;
		this.stock_type = stock_type;
		this.stock_quality_status = stock_quality_status;
		this.status_cause = status_cause;
		this.location = location;
		this.product_family = product_family;
		this.warehouse_code = warehouse_code;
		Item_num = item_num;
		Item_desc = item_desc;
		this.item_name = item_name;
		this.amount = amount;
		this.weight = weight;
		this.unit = unit;
		this.customer = customer;
		this.fixed_month = fixed_month;
		this.width = width;
		this.thickness = thickness;
		this.height = height;
		this.inventory_date = inventory_date;
		this.warehouse_date = warehouse_date;
		this.warehouse_aging = warehouse_aging;
	}
}

