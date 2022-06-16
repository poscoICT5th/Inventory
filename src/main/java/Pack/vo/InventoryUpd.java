package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventoryUpd {
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
	String inventory_date;
	String warehouse_date;

	public InventoryUpd(String industry_family, String stock_type, String product_family, String state,
			String location, String warehouse_code, String item_code, String item_name, int amount, String unit,
			float weight, float width, float thickness, float height, String customer, String stock_quality_status,
			String status_cause, String inventory_date, String warehouse_date) {
		super();
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
		this.inventory_date = inventory_date;
		this.warehouse_date = warehouse_date;
	}
}

