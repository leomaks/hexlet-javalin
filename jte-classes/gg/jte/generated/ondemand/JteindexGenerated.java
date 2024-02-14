package gg.jte.generated.ondemand;
import org.example.hexlet.model.CoursePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,8,8,8,8,9,9,9,11};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n<html>\n<head>\n    <title>Хекслет</title>\n</head>\n<body>\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getName());
		jteOutput.writeContent("</h1>\n<p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.getDescription());
		jteOutput.writeContent("</p>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
