package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,35,35,35,37,37,39,39,39,41,41,43,43,43,45,45,48,48,50,50,50,65};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page, Content content, Content footer) {
		jteOutput.writeContent("\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\n          rel=\"stylesheet\"\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\n          crossorigin=\"anonymous\">\n    <title>Hello Hexlet!</title>\n</head>\n<header class=\"p-3 bg-dark text-white\">\n    <div class=\"container\">\n        <div class=\"d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start\">\n\n            <ul class=\"nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0\">\n                <li><a href=\"/\" class=\"nav-link px-2 text-white\">Главная страница</a></li>\n                <li><a href=\"/courses\" class=\"nav-link px-2 text-white\">Курсы</a></li>\n                <li><a href=\"/users\" class=\"nav-link px-2 text-white\">Пользователи</a></li>\n                <li><a href=\"/users/build\" class=\"nav-link px-2 text-white\">Создать нового пользователя</a></li>\n                <li><a href=\"/courses/build\" class=\"nav-link px-2 text-white\">Создать новый курс</a></li>\n                <li><a href=\"/sessions/build\" class=\"nav-link px-2 text-white\">Войти в аккаунт</a></li>\n            </ul>\n        </div>\n    </div>\n</header>\n<body>\n<div class=\"mx-auto p-4 py-md-5\">\n\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n        <p>\n            ");
			if ( page.getFlash().contains("Error")) {
				jteOutput.writeContent("\n                <div class=\"alert alert-danger\" role=\"alert\">\n                    ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getFlash());
				jteOutput.writeContent("\n                </div>\n            ");
			} else {
				jteOutput.writeContent("\n                <div class=\"alert alert-success\" role=\"alert\">\n                    ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getFlash());
				jteOutput.writeContent("\n                </div>\n            ");
			}
			jteOutput.writeContent("\n\n        </p>\n    ");
		}
		jteOutput.writeContent("\n\n");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n</body>\n\n\n<div class=\"footer\">\n\n</div>\n\n<footer class=\"py-3 my-4\">\n    <ul class=\"nav justify-content-center border-bottom pb-3 mb-3\">\n        <li class=\"nav-item\"><a href=\"https://github.com/leomaks\" class=\"nav-link px-2 text-muted\">My GitHub</a></li>\n    </ul>\n</footer>\n\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.getOrDefault("page", null);
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, page, content, footer);
	}
}
