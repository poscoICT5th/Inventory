package Pack.vo;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class LogiVo {
	String instruction_no;
	String status;
	String lot_no;
	String industry_family;
	String stock_type;
	String product_family;
	String state;
	String location;
	String to_warehouse;
	String item_code;
	String item_name;
	int amount;
	int order_amount;
	int im_amount;
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
	// 출고 컬럼
	int ex_amount;
	int ex_remain;
	// 이동 컬럼
	int move_amount;
	String from_warehouse;
	
	
}
