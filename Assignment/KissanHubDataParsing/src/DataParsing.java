import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParsing {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "region_code,weather_param,year, key, value";

	@SuppressWarnings("resource")
	public void parse() throws IOException {
		String[] key = null;
		List<String> countryList = new ArrayList<String>();
		countryList.add("England");
		countryList.add("Scotland");
		countryList.add("UK");
		countryList.add("Wales");
		
		List<String> paramsList = new ArrayList<String>();
		paramsList.add("Rainfall");
		paramsList.add("Sunshine");
		paramsList.add("Tmax");
		paramsList.add("Tmean");
		paramsList.add("Tmin");
		
		final String fileExtension = ".txt";
		for (int i=0; i<countryList.size(); i++)
		{
			for (int j=0; j<paramsList.size(); j++)
			{
				//create a file called weather.csv and put data in formatted way
				String fileName = "region/" + countryList.get(i) +"/" + paramsList.get(j)+ fileExtension;
				FileWriter fileWriter = null;
				fileWriter = new FileWriter("weather.csv");
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
				try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
					String line;
					int lineNo = 0;
					
					
					
					while ((line = br.readLine()) != null) {
						lineNo++;
						if(lineNo == 8) {
							key = line.split("(?<=\\S\\s)");
						}
						if(lineNo>8) {
							if (line.contains("---") || line.contains("      "))
							{
								line = line.replace("---", "N/A");
								line = line.replace("      ", "   N/A ");
							}
							
							List<String> data = new ArrayList<String>(Arrays.asList(line.split("(?<=\\S\\s)")));
							String year = data.get(0).trim();
							int count = data.size();
							
							//Appending extra "N/A  " at runtime in the data arraylist, it will not be in line object
							if (count < 18)
							{
								for (int x=count; x<18; x++)
								{
									data.add("N/A ");
								}
							}
							System.out.println(line);
							for(int k=1; k<data.size(); k++) {
								
								fileWriter.append(countryList.get(i).toString());
								fileWriter.append(COMMA_DELIMITER);
								fileWriter.append(paramsList.get(j).toString());
								fileWriter.append(COMMA_DELIMITER);
								fileWriter.append(year.trim());
								fileWriter.append(COMMA_DELIMITER);
								fileWriter.append(key[k].trim());
								fileWriter.append(COMMA_DELIMITER);
								fileWriter.append(data.get(k).trim());
								fileWriter.append(NEW_LINE_SEPARATOR);
							}
							data=null;
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					// close the filewriter object
					if (fileWriter != null)
					{
						fileWriter.flush();
						fileWriter.close();
					}
				}
			}
		}
		
	}
	
}
