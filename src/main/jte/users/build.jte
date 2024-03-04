@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

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

<form action="/users" method="post">
    <div>
        <label>
            Имя
            <input type="text"  class="form-control rounded" placeholder="Введите имя" aria-label="Search" aria-describedby="search-addon" name="name" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email"  class="form-control rounded" placeholder="Введите email" aria-label="Search" aria-describedby="search-addon" required name="email" />
        </label>
    </div>
    <div>
        <label>
            Пароль
            <input type="password"  class="form-control rounded" placeholder="Введите пароль" aria-label="Search" aria-describedby="search-addon"  required name="password" />
        </label>
    </div>
    <div>
        <label>
            Подтверждение пароля
            <input type="password"  class="form-control rounded" placeholder="Повторите пароль" aria-label="Search" aria-describedby="search-addon" required name="passwordConfirmation" />
        </label>
    </div>
    <input type="submit" class="btn btn-outline-primary" value="Зарегистрировать" />
</form>

`)