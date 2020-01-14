/*
 * package com.dreamorbit.scripts;
 * 
 * import org.testng.annotations.Test; import org.testng.annotations.Test;
 * import org.testng.annotations.Test; import com.dreamorbit.generic.BaseTest;
 * 
 * import java.io.FileNotFoundException; import java.io.FileReader; import
 * java.io.IOException;
 * 
 * import org.json.simple.JSONArray; import org.json.simple.JSONObject; import
 * org.json.simple.parser.JSONParser; import
 * org.json.simple.parser.ParseException;
 * 
 * 
 * public class ReadJSONFile extends BaseTest {
 * 
 * @Test(priority = 30, enabled = true) public void readJSON() throws
 * InterruptedException, IOException, ParseException {
 * 
 * JsonDownloadValidSkey jsonDownloadValidSkey= new JsonDownloadValidSkey();
 * jsonDownloadValidSkey.jsonDownloadCheck();
 * 
 * 
 * JSONParser jsonParser = new JSONParser();// to read
 * 
 * FileReader sfileReader = new FileReader(sjsonPath);//to read json
 * C://Users/karthik.m/Downloads/json_6MWT_vijeth.k_2019-11-08T16%3A56%3A30%
 * 3A721/Pedometer.json Object aobj = jsonParser.parse(sfileReader); JSONObject
 * jsonObject= (JSONObject)obj;
 * 
 * String time = (String)jsonObject.get("currentTime");
 * System.out.println(time);
 * 
 * 
 * 
 * 
 * FileReader afileReader = new FileReader(ajsonPath);//to read json
 * C://Users/karthik.m/Downloads/json_6MWT_vijeth.k_2019-11-08T16%3A56%3A30%
 * 3A721/Pedometer.json Object sobj = jsonParser.parse(afileReader); JSONObject
 * jsonObject= (JSONObject)sobj;
 * 
 * String time = (String)jsonObject.get("currentTime");
 * System.out.println(time);
 * 
 * 
 * } }
 * 
 * 
 * 
 * 
 * 
 * //JSONArray itemList = (JSONArray) obj;
 * 
 * 
 * 
 * 
 * for(int i=0;i<itemList.size();i++) { JSONObject itemsList = (JSONObject)
 * itemList.get(i); System.out.println("Users -> "+itemsList);//This prints
 * every block - one json object JSONObject user = (JSONObject)
 * itemsList.get("items"); System.out.println("User -> "+user); //This prints
 * each data in the block String distance = (String) user.get("distance");
 * String endDate = (String) user.get("endDate");
 * System.out.println("The distance in JSON is: "+distance);
 * System.out.println("The endDate in JSON is: "+endDate); }
 * System.out.println("Users List-> "+itemList); } catch (FileNotFoundException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * 
 * 
 * 
 * 
 */