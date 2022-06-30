package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrendInfo {
	int trend_idx;
	String date;
	int inven_motor;
	int inven_rotor;
	int inven_strip;
	int export_motor;
	int export_rotor;
	int export_strip;
}
