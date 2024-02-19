@import org.example.hexlet.model.courses.CoursePage
@param CoursePage page


@template.layout.page(
content = @`
    <h1>${page.getName()}</h1>
    <p>${page.getDescription()}</p>
`
)