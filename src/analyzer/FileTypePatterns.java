package analyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTypePatterns {

  private static final String UNMATCHED_FILE_TYPE = "Unknown file type";

  private final byte[] pattern;
  private final String typeName;

  public FileTypePatterns(String[] patternTypePairs) {
    this.pattern = patternTypePairs[0].getBytes(StandardCharsets.UTF_8);
    this.typeName = patternTypePairs[1];
  }

  public String checkFileType(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    byte[] fileBytes = Files.readAllBytes(path);
    for (int i = 0; i < fileBytes.length - pattern.length + 1; i++) {
      int j = 0;
      while (j < pattern.length && fileBytes[i + j] == pattern[j]) {
        j++;
      }
      if (j == pattern.length) {
        return typeName;
      }
    }
    return UNMATCHED_FILE_TYPE;
  }
}
