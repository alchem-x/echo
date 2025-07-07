FROM public.ecr.aws/docker/library/eclipse-temurin:24 AS builder

WORKDIR /app
COPY . .
RUN ./build.sh

FROM public.ecr.aws/docker/library/eclipse-temurin:24-jre-alpine

WORKDIR /app
COPY --from=builder /app/build build
COPY --from=builder /app/run.sh .
CMD ["./run.sh"]
