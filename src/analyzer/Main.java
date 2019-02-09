package analyzer;

import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      FileTypePatterns fileTypePatterns = new FileTypePatterns(
          Arrays.copyOfRange(args, 1, args.length));

      String fileType = fileTypePatterns.checkFileType(args[0]);
      System.out.println(fileType);
    }
  }
}