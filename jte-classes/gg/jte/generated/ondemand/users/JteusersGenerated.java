package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteusersGenerated {
	public static final String JTE_NAME = "users/users.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,5,5,6,6,9,9,9,9,9,9,9,9,13,13,15,15,27,27,30,30,30,31,31,31,31,31,31,31,34,34,37,37,38,38,38,39};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <form action=\"/users\" method=\"get\">\n        <input type=\"search\" required name=\"term\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getTerm())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n    ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n        <p>Пока не добавлено ни одного пользователя</p>\n    ");
				} else {
					jteOutput.writeContent("\n\n        <table class=\"table table-primary table-striped table-bordered table-sm\">\n\n            <thead>\n            <tr>\n                <th scope=\"col\">Id</th>\n                <th scope=\"col\">Пользователь</th>\n\n            </tr>\n            </thead>\n\n            ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                <tbody>\n                <tr>\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                    <td><a href=\"/users/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(user.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getName());
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
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}