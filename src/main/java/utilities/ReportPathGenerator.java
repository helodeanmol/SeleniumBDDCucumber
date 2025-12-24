package utilities;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportPathGenerator {

    /**
     * Generates a unique report path string.
     * Note: This approach is not directly compatible with the @CucumberOptions plugin attribute.
     *
     * @param featureName The name of the feature file.
     * @param tagName     The tag being executed.
     * @return A string representing the full path for a report file.
     */
    public static String getReportPath(String featureName, String tagName) {
        // Use the modern java.time API for better performance and thread safety.
        // This format is safe for file and folder names on all operating systems.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSSSSS");
        String timestamp = LocalDateTime.now().format(formatter);

        // Use Paths.get() to construct a path in an OS-agnostic way.
        return Paths.get("target", "reports", featureName + "_" + tagName + "_" + timestamp, "cucumber-report.html").toString();
    }
}
