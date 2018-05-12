import java.util.ArrayList;
import java.util.List;

public class TestExcel {
	
	List<List<String>> listData = new ArrayList<>();
	
	public void init() {
		List<String> item = new ArrayList<>();
		item.add("1");
		item.add("order");
		item.add("111");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("1");
		item.add("header");
		item.add("222");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("2");
		item.add("title");
		item.add("333");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("2");
		item.add("color");
		item.add("444");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("1");
		item.add("body");
		item.add("444");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("2");
		item.add("thead");
		item.add("555");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("3");
		item.add("script");
		item.add("666");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("3");
		item.add("link");
		item.add("777");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("2");
		item.add("tbody");
		item.add("888");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("3");
		item.add("pr");
		item.add("999");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("3");
		item.add("img");
		item.add("122");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("3");
		item.add("link");
		item.add("133");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("1");
		item.add("catalog");
		item.add("");
		listData.add(item);
		
		item = new ArrayList<>();
		item.add("1");
		item.add("footer");
		item.add("144");
		listData.add(item);
	}

	public ArrayList<AnObject> parseData() {
		//ArrayList<ArrayList<String>> listData = new ArrayList<>();
		ArrayList<AnObject> listObjectLv1 = new ArrayList<>();
		ArrayList<AnObject> listObjectLv2 = null;
		ArrayList<AnObject> listObjectLv3 = null;
		int sizeOfData = listData.size();
		AnObject anObject = null;

		for (int i = 0; i < sizeOfData; i++ ) {
		    anObject = new AnObject();
		    anObject.setName(listData.get(i).get(1));
		  
		    if (Integer.valueOf(listData.get(i).get(0)) == 1)  {
		        listObjectLv2 = new ArrayList();
				anObject.setList(listObjectLv2);
		        listObjectLv1.add(anObject );
		    }
			
			if (Integer.valueOf(listData.get(i).get(0)) == 2)  {
		        listObjectLv3 = new ArrayList();
				anObject.setList(listObjectLv3);
		        listObjectLv2.add(anObject );
		    }
			
			if (Integer.valueOf(listData.get(i).get(0)) == 3)  {
		        listObjectLv3.add(anObject);
		    }
		}
		
		return listObjectLv1;
	}
	
	public void display(ArrayList<AnObject> listObject) {
		AnObject tempObj = null;
		AnObject tempObj2 = null;
		AnObject tempObj3 = null;
		for (int i = 0; i < listObject.size(); i++ ) {
			tempObj = listObject.get(i);
			System.err.println("tempObj " + tempObj.getName());
			if (tempObj.getList() != null && tempObj.getList().size() > 0 ) {
				for (int j = 0; j < tempObj.getList().size(); j++ ) {
					tempObj2 = tempObj.getList().get(j);
					System.err.println("tempObj2 " + tempObj2.getName());
					if (tempObj2.getList() != null && tempObj2.getList().size() > 0 ) {
						for (int k = 0; k < tempObj2.getList().size(); k++ ) {
							tempObj3 = tempObj2.getList().get(k);
							System.err.println("tempObj3 " + tempObj3.getName());
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TestExcel excel = new TestExcel();
		excel.init();
		ArrayList<AnObject> listObject = excel.parseData();
		excel.display(listObject);
	}
}
