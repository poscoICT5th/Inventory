package Pack.vo;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import lombok.*;

@ToString 
@Getter
@Setter
public class InventoryProduceDTO {
	List<InventoryProduceVo> consumedProducts;
	InventoryDTO newProduct;
}
