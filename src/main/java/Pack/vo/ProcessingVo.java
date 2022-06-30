package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProcessingVo {
	String lot_no;
	String state;
	public ProcessingVo(LogiVo logiVo, String from) {
		this.lot_no = logiVo.lot_no;
		this.state = from.equals("export") ? "출고등록" : "이동등록";
	}
}
