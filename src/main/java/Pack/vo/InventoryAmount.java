package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventoryAmount {
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
}
