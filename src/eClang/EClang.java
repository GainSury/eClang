package eClang;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import model.OutputInfo;

public class EClang { 
    public static OutputInfo output(String sourceNo){
        String source = Conf.SOURUCE+sourceNo+Conf.LANG;
        String dest = Conf.DEST + sourceNo+Conf.WIN;
        File file=new File(dest); 
        if(file.exists() == true)
            file.delete();
        ProcessBuilder pb  = new ProcessBuilder(Conf.COMPILER_VERSION,source,"-o",dest);
        Process p;
        OutputInfo output = new OutputInfo();
        int result;

        try {
            p = pb.start();
            //record error messages from the clang
            String errMessage = getMessageFromBuf(p.getErrorStream());
            result = p.waitFor();
            if(result != 0){
                output.setStatus("error");
                output.setOutput(errMessage);
                return output;
            }
            
            //if result == 0,it means no error,continue run target
            pb.command(dest);
            p = pb.start();
            if(p.waitFor(3000, TimeUnit.MILLISECONDS) == false){
                p.destroy();
                output.setStatus("error");
                output.setOutput("exceed "+Conf.TIME_LIMITATION+"ms time limitation");
                return output;
            }
            String execMessage = getMessageFromBuf(p.getInputStream());
            output.setStatus("succeed");
            output.setOutput(execMessage);
            return output;
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getMessageFromBuf(InputStream buf){
        BufferedReader bufR = new BufferedReader(new InputStreamReader(buf));
        String aLine;
        StringBuilder output = new StringBuilder();
        try {
            while((aLine = bufR.readLine())!=null)
            {
                output.append(aLine+"\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String result = new String();;
        if(output.length() != 0)
            result = output.toString().substring(0,output.length()-1);
        
        String utf8_result="";
        try {
            utf8_result = new String(result.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utf8_result;
        
    }
}
