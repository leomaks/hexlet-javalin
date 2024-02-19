
@template.layout.page(
content = @`

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