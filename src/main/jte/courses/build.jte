@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
page=page,
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/courses" method="post">
        <div>
            <label>
                Название курса
                <input type="text"  class="form-control rounded" placeholder="Введите название"  aria-describedby="search-addon" required name="name" />
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <input type="text"  class="form-control rounded" placeholder="Введите описание"  aria-describedby="search-addon" name="description" />
            </label>
        </div>

        <input type="submit" class="btn btn-outline-primary" value="Зарегистрировать" />
    </form>

`)