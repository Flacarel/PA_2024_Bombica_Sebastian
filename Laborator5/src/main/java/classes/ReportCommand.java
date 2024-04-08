package classes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Repository repository;

    public ReportCommand(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if(args.length != 0){
            throw new IllegalArgumentException("Invalid number of arguments for report command [should be 0]");
        }
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");

        Template template = cfg.getTemplate("report.ftlh");

        Map<String, Object> data = new HashMap<>();
        data.put("repository", repository);
        String name=repository.getDirectory()+"_report.html";
        try (Writer out = new FileWriter(new File("report",name))) {
            template.process(data, out);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException("Failed to generate report", e);
        }

        Desktop.getDesktop().open(new File("report.html"));
    }
}