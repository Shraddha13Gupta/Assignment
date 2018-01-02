
public class WeatherPOJO {
	String regionCode;
	String weatherParam;
	Integer year;
	String key;
	Double value;
	public WeatherPOJO(String regionCode, String weatherParam, Integer year, String key, Double value) {
		super();
		this.regionCode = regionCode;
		this.weatherParam = weatherParam;
		this.year = year;
		this.key = key;
		this.value = value;
	}
	
	public String getRegionCode() {
		return regionCode;
	}
	
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getWeatherParam() {
		return weatherParam;
	}
	public void setWeatherParam(String weatherParam) {
		this.weatherParam = weatherParam;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WeatherPOJO [regionCode=" + regionCode + ", weatherParam=" + weatherParam + ", year=" + year + ", key="
				+ key + ", value=" + value + "]";
	}
}
