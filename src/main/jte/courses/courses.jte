@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page




@template.layout.page(
page = page,
content = @`

    <form action="/courses" method="get">
        <input type="search" required name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать">
    </form>


    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else

        <table class="table table-primary table-striped table-bordered table-sm">

            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Course</th>

            </tr>
            </thead>

            @for(var course : page.getCourses())
                <tbody>
                <tr>
                    <td>${course.getId()}</td>
                    <td><a href="/courses/${course.getId()}">${course.getName()}</a> </td>
                </tr>
                </tbody>
            @endfor
        </table>

    @endif
`)
