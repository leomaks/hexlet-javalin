
WORKDIR /HexletJavalin

COPY / .

RUN gradle installDist

CMD ./build/install/HexletJavalin/bin/HexletJavalin


