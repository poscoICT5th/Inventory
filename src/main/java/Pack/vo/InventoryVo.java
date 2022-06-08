package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventoryVo {
	String industry_family;
	String target;
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
	String inventory_date;
	String warehouse_date;
	int warehouse_aging;
}
