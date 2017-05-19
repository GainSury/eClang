package rest;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eClang.Conf;
import eClang.EClang;
import model.InputInfo;
import model.OutputInfo;
@Controller
public class Rest {
	@RequestMapping(value={"/compileAndOutput"},method=RequestMethod.POST)
    public @ResponseBody  OutputInfo get1(@RequestBody InputInfo inputInfo) {
        
        try {
            PrintWriter writer = new PrintWriter(Conf.SOURUCE, "UTF-8");
            writer.print(inputInfo.getCode_text());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    OutputInfo output = EClang.output();
               
        return output;
    }
}
//output.setOutput(EClang.testOutput());
//new Thread() {  
//  public void run() {  
//      
//  }}.start();
