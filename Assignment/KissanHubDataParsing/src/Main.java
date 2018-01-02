import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		DownloadFilesFromURL downloadFilesFromURL = new DownloadFilesFromURL();
		downloadFilesFromURL.execute();
		
		DataParsing dataParsing = new DataParsing();
		dataParsing.parse();
	}

}
