package sample.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerApp03 {

	public static void main(String[] args) throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("v", "Tom&Jerry");
		process("simple.ftl", root);
	}
	private static void process(String template, Map<String, ?> data) throws Exception {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		String baseDir = new File("").getAbsolutePath();
		cfg.setDirectoryForTemplateLoading(new File(baseDir + "\\src\\main\\resources"));
		Writer out = new OutputStreamWriter(System.out);
		Template temp = cfg.getTemplate(template);
		temp.process(data, out);
		out.flush();
	}
}
