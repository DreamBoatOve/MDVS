package Utils.service.test.highThroughput.PD;

import java.util.Set;

import beans.material.service.test.highThroughput.PD.PD_Chart;
import beans.material.service.test.highThroughput.PD.PD_OCV;
import beans.material.service.test.highThroughput.PD.PD_Setting;

public interface IPDParser 
{
	public PD_Setting getPD_Setting();
	public Set<PD_OCV> getPD_OcvSet();
	public Set<PD_Chart> getPD_ChartSet();
}
