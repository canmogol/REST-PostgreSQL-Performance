FROM golang as builder
RUN mkdir /build 
ADD . /build/
WORKDIR /build 
RUN apt update && apt install git -y
RUN go get github.com/gorilla/mux
RUN go get github.com/lib/pq
RUN go build main.go
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -ldflags '-extldflags "-static"' -o main .
FROM scratch
COPY --from=builder /build/main /app/
WORKDIR /app
CMD ["./main"]