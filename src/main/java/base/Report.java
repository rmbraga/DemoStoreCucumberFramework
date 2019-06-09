package base;

public class Report extends TestBase {

	public Report() {
		super();
	}

	public static String getReportConfigPath() {
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path não foi especificado no arquivo de config.properties para a chave: reportConfigPath");
	}

}
