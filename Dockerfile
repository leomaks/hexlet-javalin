FROM gradle:8.2-jdk17

WORKDIR /HexletJavalin

COPY ./ ./

RUN gradle installDist

CMD ./build/install/HexletJavalin/bin/HexletJavalin