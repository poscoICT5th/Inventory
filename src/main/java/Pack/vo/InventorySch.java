package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventorySch {
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
	int min_amount;
	int max_amount;
	float min_weight;
	float max_weight;
	String unit;
	String customer;
	int min_fixed_month;
	int max_fixed_month;
	float min_width;
	float max_width;
	float min_thickness;
	float max_thickness;
	float min_height;
	float max_height;
	String inventory_date;
	String warehouse_date;
}
