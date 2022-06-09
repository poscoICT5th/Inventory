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
	String status;
	String industry_family;
	String location;
	String instruction_no;
	String product_family;
	String lot_no;
	String item_no;
	String item_name;
	int amount;
	float weight;
	String unit;
	String customer;
	float width;
	float thickness;
	float height;
	int order_amount;
	int im_amount;
	String to_warehouse;
	String order_date;
	String inst_reg_date;
	String inst_deadline;
	String done_date;
	// 출고 컬럼
	int ex_amount;
	int ex_remain;
	// 이동 컬럼
	int move_amount;
	String from_warehouse;
	
}
