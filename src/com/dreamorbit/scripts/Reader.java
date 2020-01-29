
package com.dreamorbit.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;

public class Reader extends BaseTest {
	

	boolean isFound;

	public String unzippedlatestFilePath;

	@Test(priority = 31, enabled = true)

	public void readingJSON() throws InterruptedException, IOException, ParseException {

		JsonDownloadValidSkey jsonDownloadValidSkey = new JsonDownloadValidSkey();
		jsonDownloadValidSkey.jsonDownloadCheck();
		Thread.sleep(6000);

//TO READ THE LATEST DOWNLOADED FILE Path
		Path dir = Paths.get("C://Users/karthik.m/Downloads/"); // specify your directory

		Optional<Path> lastFilePath = Files.list(dir) // here we get the stream with full directory listing
				.filter(f -> !Files.isDirectory(f)) // exclude subdirectories from listing
				.max(Comparator.comparingLong(f -> f.toFile().lastModified())); // finally get the last file using
																				// simple comparator by lastModified
																				// field
//PRINTS THE latest downloaded FILE PATH
		if (lastFilePath.isPresent()) // your folder may be empty
		{

			String latestModifiedPath = lastFilePath.toString().replaceAll("[\\[\\]]", "");
			latestModifiedPath = latestModifiedPath.replaceAll("Optional", "");
			unzippedlatestFilePath = "C://Users/karthik.m/Downloads/latestdownload";
			unzip(latestModifiedPath, unzippedlatestFilePath);
			File folder = new File(unzippedlatestFilePath);
			//Reporter.log("File folder >> " + folder.toString(), true);
			List<String> list = new ArrayList<>();
			List<String> listOfFilesArray = new ArrayList<>(Arrays.asList("CurrentTime.json", "DeviceMotion.json",
					"discardReason.json", "Location.json", "Pedometer.json", "StepCountOfDay.json", "Summary.json",
					"SurveyResponse.json", "Weather.json"));
			
			
			
			for (File file : folder.listFiles()) 
			{
				
				String afn = file.getName();
				list.add(afn); // adds strings to the list
				continue;
			}
			
		isArrayEqual(listOfFilesArray, list);
	
	
	
			
			
				
					
			for (File file : folder.listFiles()) {
				String apath = file.getAbsolutePath();
				String afn = file.getName();
				
				
				//Reporter.log(apath,true);
				
				if (afn.equals("CurrentTime.json"))

				{
					readingcurrentTimejSON(apath);
				}
				
				else if (afn.equals("DeviceMotion.json")) {
					readingdeviceMotioninfo(apath);
				}
				
				else if (afn.equals("Pedometer.json")) {
					readingPedometerinfo(apath);
				}
				
				else if (afn.equals("discardReason.json")) {
					readingdiscardReasonjSONS(apath);
				}

				else if (afn.equals("StepCountOfDay.json")) {
					readingTotalStepCountOfDayjSONS(apath);
				}
				
				else if (afn.equals("Summary.json")) {
					readingArraySummaryjSONS(apath);
				}
				
				else if (afn.equals("SurveyResponse.json")) {
					readingArraySurveyResponsejSONS(apath);
				}
				
				else if (afn.equals("Weather.json")) {
					readingArrayWeatherjSONS(apath);
				}
				

				else if (afn.equals("Location.json"))
				{
					readingLocationjSONS(apath);
				}

			}

		}
		}
		
		
	

	private void isArrayEqual(List<String> listOfFilesArray, List<String> list) {

		Collections.sort(listOfFilesArray);
		Collections.sort(list);

		boolean isEqual = listOfFilesArray.equals(list);
		if (isEqual == true) {
			System.out.println("All the json files are downloaded successfully -Test case passed ");
		} else {
			listOfFilesArray.removeAll(list);

			System.out.println(
					"Test case failed-All the files are not downloaded ,Missing json file is " + listOfFilesArray);

		}
	}

	public boolean checkFileExists(String checkFile) {
		String dirName = unzippedlatestFilePath;
		File dir2 = new File(dirName);
		File[] dir_contents = dir2.listFiles();
		String temp = dirName + "/" + checkFile;
		boolean check = new File(temp).exists();
		System.out.println("Check" + check); // -->always says false

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(checkFile))
				return true;
		}

		return false;
	}

	private static void unzip(String zipFilePath, String destDir) {
		String unzippedPath = null;
		String unZippedvalue = null;
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				// System.out.println("Unzipping to " + newFile.getAbsolutePath());
				unzippedPath = newFile.getAbsolutePath();
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				// System.out.println("FIS >> "+fos.toString());
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	//1 readingcurrentTimejSON
	
	private void readingcurrentTimejSON(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		JSONObject jsonObject = (JSONObject) readableJson;
		boolean currentTime = (boolean) jsonObject.containsKey("currentTime");
		if (currentTime == true) {
			Reporter.log("Current Time key is available in the current Time Json file- Test case passed", true);
		} else {
			Reporter.log("Current Time key is not available- Test case Failed for current Time Json", true);
		}
		

	}

	//2.readingdiscardReasonjSONS
	
	private void readingdiscardReasonjSONS(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		JSONObject jsonObject = (JSONObject) readableJson;
	
		boolean discardReason = (boolean) jsonObject.containsKey("discardReason");
		if (discardReason == true) {
			Reporter.log("discardReason key is available in discardReason Json file- Test case passed ", true);
		} else {
			Reporter.log("discardReason key is not available- Test case Failed for discardReason Json", true);
		}

	}

	
	//3.Reading device motion info
	
	private void readingdeviceMotioninfo(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		JSONObject jsonObject = (JSONObject) readableJson;
		
		boolean deviceMotioninfo = (boolean) jsonObject.containsKey("items");
		if (deviceMotioninfo == true) {
			Reporter.log("deviceMotioninfo key is available deviceMotion Json file- Test case passed ", true);
		} else {
			Reporter.log("deviceMotioninfo is not available- Test case Failed for deviceMotion Json", true);
		}
	}

	//4.Reading Total Steps
	
	private void readingTotalStepCountOfDayjSONS(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		JSONObject jsonObject = (JSONObject) readableJson;
		
		boolean totalStepsInDay = (boolean) jsonObject.containsKey("totalStepsInDay");
		if (totalStepsInDay == true) {
			Reporter.log("totalStepsInDay key is available in TotalStepCountOfDay Json file- Test case passed ",
					true);
		} else {
			Reporter.log("totalStepsInDay is not available- Test case Failed for TotalStepCountOfDay Json",
					true);
		}

	}

	//5.Reading location
	
	private void readingLocationjSONS(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		
		JSONObject jsonObject = (JSONObject) readableJson;
		
		
		if(jsonObject.containsKey("Items"))
		{
			Reporter.log("Items key is available under location JSON file- level 1 test case passed");
			
			JSONArray items = (JSONArray) jsonObject.get("items");
			boolean isValid = (boolean) true; 
			
			Iterator iterator = items.iterator(); 
			while (isValid && iterator.hasNext()) {
				JSONObject currentObj = (JSONObject) iterator.next();// To read using iterator -1. Create an object call iterator method 2.while hasNext() 3.next() to read
				isValid = currentObj.containsKey("altitude") && 
						currentObj.containsKey("coordinate") &&
						currentObj.containsKey("course") &&
						currentObj.containsKey("horizontalAccuracy") &&
						currentObj.containsKey("speed") && 
						currentObj.containsKey("timestamp") && 
						currentObj.containsKey("verticalAccuracy"); 
				
				JSONObject coordinateObj = (JSONObject) currentObj.get("coordinate");
				
				isValid = coordinateObj.containsKey("latitude") &&
						coordinateObj.containsKey("additionalProperties") && 
						coordinateObj.containsKey("longitude");
//						currentObj.containsKey("verticalAccuracyKarthik") 
						

			}
			
			

			if(isValid==true)
			{
				Reporter.log("Location JSON contains all the required keys- test case passed ", true);
			}
			else
			{
				Reporter.log("Location JSON does not contains all the required keys for Items- test case Failed ", true);
			}
			

		
		}
		else
		{
			Reporter.log("Items are not available under location json -Location Json level 1 test case Failed");
		}
		
	}

	//	System.out.println(items);// overrides to sting method and hence output will not be refrence instaed it prints the values with [] appended 
		
		
//6. Reading Summary JSON
	
	  private void readingArraySummaryjSONS(String apath) throws IOException,ParseException { 
	  
	  JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate 
	  FileReader ojsonfile = new FileReader(apath);// to read json file
	   Object readableJson = jsonParser.parse(ojsonfile);
	   JSONArray jsonArrayData= (JSONArray) readableJson;
		boolean isValid = (boolean) true;
	   
	   Iterator itr = jsonArrayData.iterator();
	   
	   while(isValid && itr.hasNext())
	   {
		   JSONObject currentObj = (JSONObject) itr.next();// To read using iterator -1. Create an object call iterator method 2.while hasNext() 3.next() to read
	   
		   isValid =  currentObj.containsKey("average_heart_rate")
	  && currentObj.containsKey("distance")&&
	  currentObj.containsKey("duration_of_test")&& currentObj.containsKey("id")&&
	  currentObj.containsKey("max_heart_rate")&&
	  currentObj.containsKey("steps_count")&&
	  currentObj.containsKey("test_taken_at")&&
	  currentObj.containsKey("total_floor_ascended") ;
	  
	  
		if(isValid==true)
		{
			Reporter.log("All the Summary Informations/keys are available- Test case passed for Summary Json",true);
			break;
		}
		else
		{
			Reporter.log("Summary Informations are not available- Test case Failed for Summary Json", true);
		}
	 
	  
	  
	  }
	 
	  }
	  //7. Reading Survey response
	  
	  private void readingArraySurveyResponsejSONS(String apath) throws IOException,ParseException { 
		  
	  JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate 
	  FileReader ojsonfile = new FileReader(apath);// to read json file
	   Object readableJson = jsonParser.parse(ojsonfile);
	   JSONArray jsonArrayData= (JSONArray) readableJson;
	   
	  boolean isvalid= (boolean)true;
	  
	   Iterator itr= jsonArrayData.iterator();
	   
	  while (isvalid && itr.hasNext()) {
		  JSONObject currentObj = (JSONObject) itr.next();
	 
		  isvalid= currentObj.containsKey("answers")
	  && currentObj.containsKey("date")&&
	  currentObj.containsKey("questions");
	  
	  if(isvalid==true)
	  {
	  Reporter.log("All the Survey Informations/Keys are available- Test case passed for Survey Json",true);
	  break;
	  } 
	  else 
	  { Reporter.log(
	  "Survey Informations are not available- Test case Failed for Survey Json"
	  ,true); 
	  }
	  }
	  }
	  
	  //8. Reading Weather JSON
	  
	  private void readingArrayWeatherjSONS(String apath) throws IOException,ParseException { 
		  
	  JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate 
	  FileReader ojsonfile = new FileReader(apath);// to read json file
	   Object readableJson = jsonParser.parse(ojsonfile);
	   JSONObject wtrJsonObject= (JSONObject) readableJson;
	  

	  
	  boolean weatherInfo = (boolean) wtrJsonObject.containsKey("base")
	  && wtrJsonObject.containsKey("clouds")&&
	  wtrJsonObject.containsKey("cod")&& wtrJsonObject.containsKey("id")&&
	  wtrJsonObject.containsKey("coord")&&
	  wtrJsonObject.containsKey("dt")&&
	  wtrJsonObject.containsKey("id")&&
	  wtrJsonObject.containsKey("main")&&
	  wtrJsonObject.containsKey("name")&&
	  wtrJsonObject.containsKey("sys")&&
	  wtrJsonObject.containsKey("weather")&&
	  wtrJsonObject.containsKey("wind");
	  
	  if(weatherInfo==true)
	  {
	  Reporter.log("All the Weather Informations/Keys are available- Test case passed for weather Json",true);
	  } 
	  else { Reporter.log(
	  "Weather Informations are not available- Test case Failed for Weather Json"
	  ,true); 
	  }
	  
	  }
	  
	  
	  //9.Reading pedometer info
	  
	  private void readingPedometerinfo(String apath) throws IOException, ParseException {

			JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
			FileReader ojsonfile = new FileReader(apath);// to read json file
			Object readableJson = jsonParser.parse(ojsonfile);
			
			JSONObject jsonObject = (JSONObject) readableJson;
		boolean ItemsExist=	jsonObject.containsKey("Items");
			
			if(ItemsExist==true)
			{
				Reporter.log("Items keys is present in JSON",true);
			}
		 
			JSONArray items = (JSONArray) jsonObject.get("items");
			
			boolean isValid = (boolean) true; 
			
			Iterator iterator = items.iterator(); 
			while (isValid && iterator.hasNext()) {
				JSONObject currentObj = (JSONObject) iterator.next();// To read using iterator -1. Create an object call iterator method 2.while hasNext() 3.next() to read
				isValid = currentObj.containsKey("distance") && 
						currentObj.containsKey("endDate") &&
						currentObj.containsKey("floorsAscended") &&
						currentObj.containsKey("floorsDescended") &&
						currentObj.containsKey("numberOfSteps") && 
						currentObj.containsKey("startDate"); 
						

			}
			

					
			if(isValid==true)
			{
				Reporter.log("Pedometer JSON contains all the required keys- test case passed ", true);
			}
			else
			{
				Reporter.log("Pedometer JSON does not contains all the required keys for Items- test case Failed ", true);
			}
			}
		

}


//THE BELOW ONE IS USING ARRAY, THE ABOVE ONE IS USING LIST_COLLECTIONS
/*
 * package com.dreamorbit.scripts;
 * 
 * import org.testng.annotations.Test; import java.io.File; import
 * java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException; import java.nio.file.Files; import java.nio.file.Path;
 * import java.nio.file.Paths; import java.util.Arrays; import
 * java.util.Comparator; import java.util.List; import java.util.Optional;
 * import java.util.zip.ZipEntry; import java.util.zip.ZipInputStream;
 * 
 * import org.json.simple.parser.ParseException; import
 * org.testng.annotations.Test;
 * 
 * import com.dreamorbit.generic.BaseTest;
 * 
 * public class Reader extends BaseTest {
 * 
 * public String unzippedlatestFilePath;
 * 
 * @Test(priority = 31, enabled = true)
 * 
 * public void readingJSON() throws InterruptedException, IOException,
 * ParseException { BaseTest baseTest = new BaseTest(); JsonDownloadValidSkey
 * jsonDownloadValidSkey = new JsonDownloadValidSkey();
 * jsonDownloadValidSkey.jsonDownloadCheck();
 * 
 * //TO READ THE LATEST DOWNLOADED FILE Path Path dir =
 * Paths.get("C://Users/karthik.m/Downloads/"); // specify your directory
 * 
 * Optional<Path> lastFilePath = Files.list(dir) // here we get the stream with
 * full directory listing .filter(f -> !Files.isDirectory(f)) // exclude
 * subdirectories from listing .max(Comparator.comparingLong(f ->
 * f.toFile().lastModified())); // finally get the last file using // simple
 * comparator by lastModified // field //PRINTS THE latest downloaded FILE PATH
 * if (lastFilePath.isPresent()) // your folder may be empty {
 * 
 * // System.out.println("lastFilePath >> " + lastFilePath.toString()); //
 * System.out.println(lastFilePath.toString()); String latestModifiedPath =
 * lastFilePath.toString().replaceAll("[\\[\\]]", ""); latestModifiedPath =
 * latestModifiedPath.replaceAll("Optional", "");
 * System.out.println("latestModifiedPath "+latestModifiedPath);
 * 
 * // Unziping the latest downloaded file and pront its path
 * 
 * unzippedlatestFilePath = "C://Users/karthik.m/Downloads/latestdownload";
 * 
 * 
 * unzip(latestModifiedPath, unzippedlatestFilePath);
 * 
 * //String aUnzipvalue =
 * unzippedValue.replaceAll("C://Users/karthik.m/Downloads/latestdownload/",
 * ""); //System.out.println(); //String[] EUnzipArrayvalues =
 * {"CurrentTime.json","DeviceMotion.json","discardReason.json","Location.json",
 * "Pedometer.json","StepCountOfDay.json","Summary.json","SurveyResponse.json",
 * "Weather.json"};
 * 
 * File folder = new File(unzippedlatestFilePath);
 * 
 * System.out.println("File folder >> " + folder.toString()); String[] a1 = new
 * String[9];.................................................... String[] a2 =
 * {"CurrentTime.json","DeviceMotion.json","discardReason.json","Location.json",
 * "Pedometer.json","StepCountOfDay.json","Summary.json","SurveyResponse.json",
 * "Weather.json"};.............................................................
 * ....
 * 
 * 
 * int i=0; for (File file : folder.listFiles()) { String afn= file.getName();
 * a1[i]=afn; System.out.println(afn); i++;
 * 
 * 
 * System.out.println("json files >>> " + file.toString()); String replaceData =
 * file.toString().replaceAll("C","");
 * 
 * // create directories for sub directories in zip
 * //System.out.println("unZippedvalue>>> "+replaceData); continue;
 * 
 * } if (areEqual(a1, a2)) System.out.println("Yes"); else
 * System.out.println("No");
 * 
 * 
 * final List<File> fileList = Arrays.asList(folder.listFiles());
 * 
 * System.out.println("List of json files >>> " + fileList.toString());
 * 
 * int rowCount = baseTest.xl_RowCount(XL_DATA_PATH, "EjsonFiles");
 * System.out.println(rowCount);
 * 
 * for (int l = 1; l <= rowCount; l++) { String checkFile =
 * baseTest.read_XL_Data(XL_DATA_PATH, "EjsonFiles", l, 0); boolean fileCheck =
 * checkFileExists(checkFile); System.out.println("fileCheck json files >>> " +
 * fileCheck);
 * 
 * String str2 = fileList.toString().replaceAll("[\\[\\]]", ""); str2 =
 * str2.replaceAll(latestDownloads, ""); System.out.println("str2 >>> "+str2 );
 * 
 * }
 * 
 * }
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
 * }
 * 
 * private boolean areEqual(String[] a1, String[] a2) { int n = a1.length; int m
 * = a2.length;
 * 
 * // If lengths of array are not equal means // array are not equal if (n != m)
 * return false;
 * 
 * // Sort both arrays Arrays.sort(a1); Arrays.sort(a2);
 * 
 * // Linearly compare elements for (int i = 0; i < n; i++) {
 * System.out.println("new Output a1>>" + a1[i]);
 * System.out.println(" new Output a2>>" + a2[i]); if (!(a1[i].equals(a2[i])))
 * return false; } // If all elements were same. return true; }
 * 
 * public boolean checkFileExists(String checkFile) { String dirName =
 * unzippedlatestFilePath; File dir2 = new File(dirName); File[] dir_contents =
 * dir2.listFiles(); String temp = dirName + "/" + checkFile; boolean check =
 * new File(temp).exists(); System.out.println("Check" + check); // -->always
 * says false
 * 
 * for (int i = 0; i < dir_contents.length; i++) { if
 * (dir_contents[i].getName().equals(checkFile)) return true; }
 * 
 * return false; }
 * 
 * private static void unzip(String zipFilePath, String destDir) { String
 * unzippedPath = null; String unZippedvalue= null; File dir = new
 * File(destDir); // create output directory if it doesn't exist if
 * (!dir.exists()) dir.mkdirs(); FileInputStream fis; // buffer for read and
 * write data to file byte[] buffer = new byte[1024]; try { fis = new
 * FileInputStream(zipFilePath); ZipInputStream zis = new ZipInputStream(fis);
 * ZipEntry ze = zis.getNextEntry(); while (ze != null) { String fileName =
 * ze.getName(); File newFile = new File(destDir + File.separator + fileName);
 * //System.out.println("Unzipping to " + newFile.getAbsolutePath());
 * unzippedPath= newFile.getAbsolutePath(); new
 * File(newFile.getParent()).mkdirs(); FileOutputStream fos = new
 * FileOutputStream(newFile); int len; while ((len = zis.read(buffer)) > 0) {
 * fos.write(buffer, 0, len); } // System.out.println("FIS >> "+fos.toString());
 * fos.close(); // close this ZipEntry zis.closeEntry(); ze =
 * zis.getNextEntry(); } // close last ZipEntry zis.closeEntry(); zis.close();
 * fis.close(); } catch (IOException e) { e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 */