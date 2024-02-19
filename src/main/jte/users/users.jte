@import org.example.hexlet.model.users.UsersPage
@param UsersPage page



@template.layout.page(
content = @`

    <form action="/users" method="get">
        <input type="search" required name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать">
    </form>

    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else

        <table class="table table-primary table-striped table-bordered table-sm">

            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Пользователь</th>

            </tr>
            </thead>

            @for(var user : page.getUsers())
                <tbody>
                <tr>
                    <td>${user.getId()}</td>
                    <td><a href="/users/${user.getId()}">${user.getName()}</a> </td>
                </tr>
                </tbody>
            @endfor
        </table>

    @endif
`)
