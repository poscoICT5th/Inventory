package Pack.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventorySch {
	String lot_no;
	String industry_family;
	String stock_type;
	String product_family;
	String state;
	String location;
	String warehouse_code;
	String item_code;
	String item_name;
	int min_amount;
	int max_amount;
	String unit;
	float min_weight;
	float max_weight;
	float min_width;
	float max_width;
	float min_thickness;
	float max_thickness;
	float min_height;
	float max_height;
	String customer;
	String stock_quality_status;
	String status_cause;
	String inventory_date;
	String warehouse_date;
	
	@Builder
	public InventorySch() {
		
	}
}
