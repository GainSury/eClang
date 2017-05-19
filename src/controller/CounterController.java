package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {
	// 生命周期：对�?
	private Integer counter1 = 0;

	// 生命周期：类
	private static Integer counter2 = 0;

	// 容器元素生命周期：对�?
	private List<Integer> counters1 = new ArrayList<Integer>();

	// 容器元素生命周期：访问线�?
	private ThreadLocal<Integer> counters2 = new ThreadLocal<Integer>();

	@RequestMapping(value = { "counter" },method=RequestMethod.GET)
	public String counter(Model model) {
		// 1-counter1自增后放入request
		model.addAttribute("counter1", ++counter1);
		// 2-counter2自增后放入request
		model.addAttribute("counter2", ++counter2);
		// 3从容器counters1取出counter3，自增后放入counters1
		Integer counter3 = null;
		if (counters1.size() <= 0) {
			counter3 = 1;
			counters1.add(counter3);
		} else {
			counter3 = counters1.get(0);
			counters1.set(0, ++counter3);
		}
		model.addAttribute("counter3", counter3);

		//4从容器counters2取出counter4，自增后放入counters2
		Integer counter4 = counters2.get();
		if (counter4 == null)
			counter4 = 0;
		counters2.set(++counter4);
		model.addAttribute("counter4", counter4);
		return "counter";
	}
}
