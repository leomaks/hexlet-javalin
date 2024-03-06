FROM gradle:8.2-jdk17

WORKDIR /HexletJavalin

COPY /app .

RUN gradle installDist

CMD ./build/install/HexletJavalin/bin/HexletJavalin