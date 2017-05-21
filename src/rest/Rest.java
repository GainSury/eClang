package rest;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private static Integer no = 0;
    public static synchronized Integer getAndAdd(){
        if(no > 10000000)
            no =  0;
        return no++;
    }
	@RequestMapping(value={"/compileAndOutput"},method=RequestMethod.POST)
    public @ResponseBody  OutputInfo get1(@RequestBody InputInfo inputInfo) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	   
	    System.out.println(df.format(new Date())+":"+inputInfo.getCode_text());
	    String sourceNo = Rest.getAndAdd().toString();
	    
        try {
            PrintWriter writer = new PrintWriter(Conf.SOURUCE+sourceNo+Conf.LANG, "UTF-8");
            writer.print(inputInfo.getCode_text());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    OutputInfo output = EClang.output(sourceNo);  
        System.out.println(df.format(new Date())+":"+output.getOutput());
        return output;
    }
	
}
//output.setOutput(EClang.testOutput());
//new Thread() {  
//  public void run() {  
//      
//  }}.start();
