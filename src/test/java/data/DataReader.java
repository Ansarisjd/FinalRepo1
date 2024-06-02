package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
   public List<HashMap<String,String>> getJasonDataToMap() throws IOException
   {   
	   // read jason to string
	String JsonContent =FileUtils.readFileToString(new File(System.getProperty("C:\\Users\\Divyesh Pawaskar\\Downloads\\Updated CODE\\Updated CODE\\Updated Framework\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json")), StandardCharsets.UTF_8);
     
	  // String to HashMap by using dependency of Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();    
	
	List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String >>>(){});
	return data;		
	
	
   
   
   }
}
