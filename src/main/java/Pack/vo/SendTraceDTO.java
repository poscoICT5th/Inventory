package Pack.vo;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class SendTraceDTO {
	String lot_no;
	String item_name;
	String item_code;
	int amount;
	String stock_quality_status;
	String stock_cause;
	List<InventoryProduceVo> consumed_infos;
	
	public SendTraceDTO(InventoryProduceDTO inventoryProduceDTO) {
		InventoryDTO newProduct = inventoryProduceDTO.getNewProduct();
		this.lot_no = newProduct.getLot_no();
		this.item_name = newProduct.getItem_name();
		this.item_code = newProduct.getItem_code();
		this.amount = newProduct.getAmount();
		this.consumed_infos = inventoryProduceDTO.getConsumedProducts();
	}
}
