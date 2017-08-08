package cn.jackson.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jackson.domain.Link;
import cn.jackson.domain.User;

public class JacksonDemo {
	private User user=null;
	
	
	@Test
	public void obj2Json() throws Exception {
		// 注意点：（1） 日期--长整型 （2）List、Set均转成数组 **********
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
		
		/**
		 	将json转换成map，    数组都转换成集合，键值对都转换成 map***********
		 */
		Map map = mapper.readValue(json, Map.class);
		
		Object object = map.get("set");
		System.out.println(object.getClass().getName());
		System.out.println(object);
		
		ArrayList<String> link = (ArrayList) map.get("set");
		for (String string : link) {
			System.out.println(string);
		}
		
		
		
		/*
		 	返回结果 ArrayList
		Object object = map.get("set");
		System.out.println(object.getClass().getName());
		
		ArrayList<String> link = (ArrayList) map.get("set");
		for (String string : link) {
			System.out.println(string);
		}
		 
		 */
		
		/*
		 	返回结果 ArrayList
		 	
			Object object = map.get("list");
			System.out.println(object.getClass().getName());
			
			ArrayList<String> list = (ArrayList) map.get("list");
			for (String string : list) {
				System.out.println(string);
			}
		 */
		
		/*
		 * 	返回结果 LinkedHashMap

			LinkedHashMap<String, String> link = (LinkedHashMap) map.get("link");
			System.out.println(link);
			for (Map.Entry<String, String> entry : link.entrySet()) {
				System.out.println(entry.getKey() + "::" + entry.getValue());
			}
		 */
		
	}


	@Test
	public void json2Obj() throws Exception {
		User temp = new User();
//{"id":"01","name":"张三","age":33,"pay":6666.88,"valid":true,"one":"E","birthday":632448000000,"link":{"phone":"13899995555","address":"河南省济源市","qq":"123456"},"map":{"aa":"this is aa","bb":"this is bb","cc":"this is cc"},"list":["普洱","大红袍"],"set":["足球","篮球","乒乓球"]}
//{"id":"01","name":"张三","valid":true,"one":"E","birthday":"1990-01-16","link":{"phone":"13899995555","address":"河南省济源市","qq":"123456"},"map":{"aa":"this is aa","bb":"this is bb","cc":"this is cc"},"list":["普洱","大红袍"],"set":["足球","篮球","乒乓球"],"my_age":33}
//		String json="{\"id\":\"01\",\"name\":\"张三\",\"age\":33,\"pay\":6666.88,\"valid\":true,\"one\":\"E\",\"birthday\":632448000000,\"link\":{\"phone\":\"13899995555\",\"address\":\"河南省济源市\",\"qq\":\"123456\"},\"map\":{\"aa\":\"this is aa\",\"bb\":\"this is bb\",\"cc\":\"this is cc\"},\"list\":[\"普洱\",\"大红袍\"],\"set\":[\"足球\",\"篮球\",\"乒乓球\"]}\n";
		String json1 = "{\"id\":\"01\",\"name\":\"张三\",\"valid\":true,\"one\":\"E\",\"birthday\":\"1990-01-16\",\"link\":{\"phone\":\"13899995555\",\"address\":\"河南省济源市\",\"qq\":\"123456\"},\"map\":{\"aa\":\"this is aa\",\"bb\":\"this is bb\",\"cc\":\"this is cc\"},\"list\":[\"普洱\",\"大红袍\"],\"set\":[\"足球\",\"篮球\",\"乒乓球\"],\"my_age\":33}";
		ObjectMapper mapper = new ObjectMapper();
		User readValue = mapper.readValue(json1, User.class);
		System.out.println(readValue);
	}

	@Test
	public void testParseJson() throws Exception {
		//{"status":"1","count":"18","info":"OK","infocode":"10000","suggestion":{"keywords":[],"cities":[]},"pois":[{"id":"B00155LGZT","name":"香山中医医院","tag":"内科,外科","type":"医疗保健服务;综合医院;综合医院","typecode":"090100","biz_type":[],"address":"复兴中路528号","location":"121.466727,31.215526","tel":"021-53061730","postcode":[],"website":[],"email":[],"pcode":"310000","pname":"上海市","citycode":"021","cityname":"上海市","adcode":"310101","adname":"黄浦区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"gridcode":"4621635721","distance":[],"navi_poiid":"H51F010012_846249","entr_location":"121.46681,31.215192","business_area":[],"exit_location":[],"match":"0","recommend":"3","timestamp":[],"alias":[],"indoor_map":"0","indoor_data":{"cpid":[],"floor":[],"truefloor":[],"cmsid":[]},"groupbuy_num":"0","discount_num":"0","biz_ext":{"rating":"4.0","cost":[]},"event":[],"children":[{"id":" B00155I5AI ","name":" 上海市黄浦区香山中医医院(西南门) ","sname":" 西南门 ","location":"121.466807,31.215201","address":" 复兴中路528号 ","distance":" 0 ","subtype":"门"},{"id":" B0FFG59U1Y ","name":" 上海市黄浦区香山中医医院(东南门) ","sname":" 东南门 ","location":"121.467169,31.215229","address":" 复兴中路528号 ","distance":" 0 ","subtype":"门"},{"id":" B0FFH97N1L ","name":" 上海市黄浦区香山中医医院(西北门) ","sname":" 西北门 ","location":"121.466470,31.215899","address":" 香山路11号 ","distance":" 0 ","subtype":"门"},{"id":" B00156TLYV ","name":" 上海市黄浦区香山中医医院停车场 ","sname":" 停车场 ","location":"121.466924,31.215365","address":" 复兴中路528号上海市黄浦区香山中医医院内 ","distance":" 0 ","subtype":"停车场"}],"photos":[{"title":[],"url":"http://store.is.autonavi.com/showpic/182cc0feb626d31fcd24ad88a1599f93"},{"title":[],"url":"http://store.is.autonavi.com/showpic/5a0c7d809a538b86613eb44dbeb79819"},{"title":"外景图","url":"http://store.is.autonavi.com/showpic/56c7a51b93caba57d31248fb664feca2"}]}]}

		String json = "{\"status\":\"1\",\"count\":\"18\",\"info\":\"OK\",\"infocode\":\"10000\",\"suggestion\":{\"keywords\":[],\"cities\":[]},\"pois\":[{\"id\":\"B00155LGZT\",\"name\":\"香山中医医院\",\"tag\":\"内科,外科\",\"type\":\"医疗保健服务;综合医院;综合医院\",\"typecode\":\"090100\",\"biz_type\":[],\"address\":\"复兴中路528号\",\"location\":\"121.466727,31.215526\",\"tel\":\"021-53061730\",\"postcode\":[],\"website\":[],\"email\":[],\"pcode\":\"310000\",\"pname\":\"上海市\",\"citycode\":\"021\",\"cityname\":\"上海市\",\"adcode\":\"310101\",\"adname\":\"黄浦区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"2\",\"poiweight\":[],\"gridcode\":\"4621635721\",\"distance\":[],\"navi_poiid\":\"H51F010012_846249\",\"entr_location\":\"121.46681,31.215192\",\"business_area\":[],\"exit_location\":[],\"match\":\"0\",\"recommend\":\"3\",\"timestamp\":[],\"alias\":[],\"indoor_map\":\"0\",\"indoor_data\":{\"cpid\":[],\"floor\":[],\"truefloor\":[],\"cmsid\":[]},\"groupbuy_num\":\"0\",\"discount_num\":\"0\",\"biz_ext\":{\"rating\":\"4.0\",\"cost\":[]},\"event\":[],\"children\":[{\"id\":\" B00155I5AI \",\"name\":\" 上海市黄浦区香山中医医院(西南门) \",\"sname\":\" 西南门 \",\"location\":\"121.466807,31.215201\",\"address\":\" 复兴中路528号 \",\"distance\":\" 0 \",\"subtype\":\"门\"},{\"id\":\" B0FFG59U1Y \",\"name\":\" 上海市黄浦区香山中医医院(东南门) \",\"sname\":\" 东南门 \",\"location\":\"121.467169,31.215229\",\"address\":\" 复兴中路528号 \",\"distance\":\" 0 \",\"subtype\":\"门\"},{\"id\":\" B0FFH97N1L \",\"name\":\" 上海市黄浦区香山中医医院(西北门) \",\"sname\":\" 西北门 \",\"location\":\"121.466470,31.215899\",\"address\":\" 香山路11号 \",\"distance\":\" 0 \",\"subtype\":\"门\"},{\"id\":\" B00156TLYV \",\"name\":\" 上海市黄浦区香山中医医院停车场 \",\"sname\":\" 停车场 \",\"location\":\"121.466924,31.215365\",\"address\":\" 复兴中路528号上海市黄浦区香山中医医院内 \",\"distance\":\" 0 \",\"subtype\":\"停车场\"}],\"photos\":[{\"title\":[],\"url\":\"http://store.is.autonavi.com/showpic/182cc0feb626d31fcd24ad88a1599f93\"},{\"title\":[],\"url\":\"http://store.is.autonavi.com/showpic/5a0c7d809a538b86613eb44dbeb79819\"},{\"title\":\"外景图\",\"url\":\"http://store.is.autonavi.com/showpic/56c7a51b93caba57d31248fb664feca2\"}]}]}\n";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(json, Map.class);
		ArrayList pois = (ArrayList)map.get("pois");
		
		LinkedHashMap<String, Object> poisMap = (LinkedHashMap<String, Object>)pois.get(0);
		for (Map.Entry<String, Object> entry : poisMap.entrySet()) {
			System.out.println(entry.getKey() + ":::" + entry.getValue());
		}

	}
	
	
	@Before
	public void setup() {
		user= new User();
		user.setId("01");
		user.setName("张三");
		user.setAge(33);
		user.setPay(6666.88);
		user.setValid(true);
		user.setOne('E');
		user.setBirthday(new Date(20l * 366 * 24 * 3600 * 1000)); // 1990年

		Link link = new Link();
		link.setAddress("河南省济源市");
		link.setPhone("13899995555");
		link.setQq("123456");
		user.setLink(link);

		Map map = new HashMap();
		map.put("aa", "this is aa");
		map.put("bb", "this is bb");
		map.put("cc", "this is cc");
		user.setMap(map);

		List list = new ArrayList() {
		};
		list.add("普洱");
		list.add("大红袍");
		user.setList(list);

		Set set = new HashSet();
		set.add("篮球");
		set.add("足球");
		set.add("乒乓球");
		user.setSet(set);

	}
}
