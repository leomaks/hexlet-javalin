package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,4,4,5,5,12,12,13,13,13,15,15,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n\n<main>\n    <h1>Привет, Хекслет!</h1>\n\n\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n        Добро пожаловать, ");
					jteOutput.setContext("main", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n    ");
				}
				jteOutput.writeContent("\n</main>\n\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
