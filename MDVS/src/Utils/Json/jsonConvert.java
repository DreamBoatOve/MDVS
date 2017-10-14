package Utils.Json;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * @Note:java将数据存入JSONObject、JSONArray中，传入前端时要转换成String
 * 本类将java对象、数据转换为JSON对象对象后，再将JSON对象转换为字符串
 * */
public class jsonConvert
{
	public static String List_To_JSONArray(List<?> list)
	{
		JSONArray js = new JSONArray(list);
		return js.toString();
	}
	public static String Map_To_JSONObject(Map<?,?> map)
	{
		JSONObject jo = new JSONObject(map);
		return jo.toString();
	}
}
