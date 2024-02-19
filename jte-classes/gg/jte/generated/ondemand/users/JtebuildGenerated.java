package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,1,1,2,2,32,32,32};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n<form action=\"/users\" method=\"post\">\n    <div>\n        <label>\n            Имя\n            <input type=\"text\"  class=\"form-control rounded\" placeholder=\"Введите имя\" aria-label=\"Search\" aria-describedby=\"search-addon\" name=\"name\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Email\n            <input type=\"email\"  class=\"form-control rounded\" placeholder=\"Введите email\" aria-label=\"Search\" aria-describedby=\"search-addon\" required name=\"email\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Пароль\n            <input type=\"password\"  class=\"form-control rounded\" placeholder=\"Введите пароль\" aria-label=\"Search\" aria-describedby=\"search-addon\"  required name=\"password\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Подтверждение пароля\n            <input type=\"password\"  class=\"form-control rounded\" placeholder=\"Повторите пароль\" aria-label=\"Search\" aria-describedby=\"search-addon\" required name=\"passwordConfirmation\" />\n        </label>\n    </div>\n    <input type=\"submit\" class=\"btn btn-outline-primary\" value=\"Зарегистрировать\" />\n</form>\n\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
