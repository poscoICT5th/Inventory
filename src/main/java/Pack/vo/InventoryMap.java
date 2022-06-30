package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class InventoryMap {
	String warehouse_code_string;
	String warehouse_code_int;
	int amount;
}
