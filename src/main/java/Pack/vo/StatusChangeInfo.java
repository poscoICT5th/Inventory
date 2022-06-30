package Pack.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatusChangeInfo {
	List<String> statusChangeList;
	String stock_quality_status;
	String status_cause;
}
