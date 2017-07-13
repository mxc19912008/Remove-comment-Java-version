
/**
 * This is a tiny tool to remove java comments,
 * in the same time remaining origional format.
 * @Author Xiaochun Ma
 * @Date（2017/07/13）
 */
import java.io.*;
import edu.duke.*;
public class CodeCommentCleaner{
    public  void cleanComments(String Filename,FileResource f) 
    throws IOException
        { 
          File file = new File (Filename);
          BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
          for (String s: f.lines()) {
              String ss = s.trim(); 
              if(ss.startsWith("/*")||ss.startsWith("*")||ss.startsWith("//")){
                  continue;
              }else if(ss.contains("//")){
                  out.write(s.substring(0,s.indexOf("//")));
                  out.newLine();
              }else{
                  out.write(s);
                  out.newLine();
              }
          }
          out.close();
    }
    //demo
    public void test() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            FileResource toConvert = new FileResource(f);
            String newName = "nonComment-" + fileName;
            try{
                cleanComments(newName, toConvert);}
            catch(IOException e) {
                e.printStackTrace();  
          }
        }
    }   
 }

