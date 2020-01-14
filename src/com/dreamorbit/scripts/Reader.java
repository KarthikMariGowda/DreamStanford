
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
			// System.out.println("File folder >> " + folder.toString());
			List<String> list = new ArrayList<>();
			List<String> listOfFilesArray = new ArrayList<>(Arrays.asList("CurrentTime.json", "DeviceMotion.json",
					"discardReason.json", "Location.json", "Pedometer.json", "StepCountOfDay.json", "Summary.json",
					"SurveyResponse.json", "Weather.json"));

			for (File file : folder.listFiles()) {
				String apath = file.getAbsolutePath();
				String afn = file.getName();

				System.out.println(apath);
				if(afn.equals("CurrentTime.json"))
				{
					readingjSON(apath);
				}
				else
				{
					readingArrayjSONS(apath);
				}
				

				list.add(afn); // adds strings to the list

				continue;

			}

			isArrayEqual(listOfFilesArray, list);

		} else {
			Reporter.log("File download is failed -Test case failed");
		}
	}

	private void isArrayEqual(List<String> listOfFilesArray, List<String> list) {

		Collections.sort(listOfFilesArray);
		Collections.sort(list);

		boolean isEqual = listOfFilesArray.equals(list);
		if (isEqual == true) {
			System.out.println("Test case passed -All the json files are downloaded successfully");
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

	private void readingArrayjSONS(String apath) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
		FileReader ojsonfile = new FileReader(apath);// to read json file
		Object readableJson = jsonParser.parse(ojsonfile);
		JSONObject jsonObject = (JSONObject) readableJson;
		JSONArray arrayItems = (JSONArray) jsonObject.get("items");
		System.out.println("OUTPUT" + arrayItems.toJSONString());

		Iterator iterator = arrayItems.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
	
	
		private void readingjSON(String apath) throws IOException, ParseException {

			JSONParser jsonParser = new JSONParser();// to parse the readed file in order to translate
			FileReader ojsonfile = new FileReader(apath);// to read json file
			Object readableJson = jsonParser.parse(ojsonfile);
			JSONObject jsonObject = (JSONObject) readableJson;
			String currentTime = (String) jsonObject.get("currentTime");
			System.out.println("OUTPUT " + currentTime);
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