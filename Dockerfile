FROM groovy:latest
COPY ./server.groovy /home/groovy/
EXPOSE 9991
CMD ["groovy", "/home/groovy/server.groovy", "9991"]
