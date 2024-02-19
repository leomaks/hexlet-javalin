package gg.jte.generated.ondemand.courses;
import org.example.hexlet.model.courses.CoursesPage;
public final class JtecoursesGenerated {
	public static final String JTE_NAME = "courses/courses.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,5,5,6,6,9,9,9,9,9,9,9,9,14,14,16,16,28,28,31,31,31,32,32,32,32,32,32,32,35,35,38,38,39,39,39,40};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <form action=\"/courses\" method=\"get\">\n        <input type=\"search\" required name=\"term\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getTerm())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n\n    ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n        <p>Пока не добавлено ни одного курса</p>\n    ");
				} else {
					jteOutput.writeContent("\n\n        <table class=\"table table-primary table-striped table-bordered table-sm\">\n\n            <thead>\n            <tr>\n                <th scope=\"col\">Id</th>\n                <th scope=\"col\">Course</th>\n\n            </tr>\n            </thead>\n\n            ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                <tbody>\n                <tr>\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getId());
						jteOutput.writeContent("</td>\n                    <td><a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</a> </td>\n                </tr>\n                </tbody>\n            ");
					}
					jteOutput.writeContent("\n        </table>\n\n    ");
				}
				jteOutput.writeContent("\n");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
