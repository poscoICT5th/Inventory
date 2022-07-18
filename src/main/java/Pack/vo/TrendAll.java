package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrendAll {
	int day;
	long sum_inven_motor;
	long sum_inven_rotor;
	long sum_inven_strip;
	long sum_export_motor;
	long sum_export_rotor;
	long sum_export_strip;
	String year;
	String month;
}
