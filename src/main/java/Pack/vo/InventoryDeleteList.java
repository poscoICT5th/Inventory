package Pack.vo;

import java.util.List;

import lombok.*;

@ToString
@Getter
@Setter
public class InventoryDeleteList {
	List<String> inventoryDeleteList;
	
	@Builder
	public InventoryDeleteList() {
		
	}
}
