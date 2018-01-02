import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadFilesFromURL {
	
	private  String urlPattern = "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/";
	private List<String> countries;
	private List<String> statistics;
	private  String date = "date";
	
	public DownloadFilesFromURL() {
		countries = new ArrayList<String>();
		countries.add("UK");
		countries.add("England");
		countries.add("Wales");
		countries.add("Scotland");
		
		statistics = new ArrayList<String>();
		statistics.add("Tmax");
		statistics.add("Tmin");
		statistics.add("Tmean");
		statistics.add("Rainfall");
		statistics.add("Sunshine");
	}
	
	public void execute() {
		String url = null;
		for(int i=0; i<countries.size(); i++) {
			for(int j=0; j<statistics.size(); j++) {
				url = urlPattern + statistics.get(j) + "/" + date + "/" +countries.get(i) + ".txt";
				try {
					downloadUsingStream(url,"region/"+countries.get(i)+"/", statistics.get(j) + ".txt");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private  void downloadUsingStream(String urlStr, String directoryName, String fileName){
        File directory = new File(directoryName);
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        try {
	        if (!directory.exists()){
	            directory.mkdirs();
	        }
	
	        File file = new File(directoryName, fileName);
	        
				file.createNewFile();
			
	        bis = new BufferedInputStream(new URL(urlStr).openStream());
	        fos = new FileOutputStream(file);
	        byte[] buffer = new byte[1024];
	        int count=0;
	        while((count = bis.read(buffer,0,1024)) != -1){
	            fos.write(buffer, 0, count);
	        }
        } catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        try {
				fos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
		}
    }
}
