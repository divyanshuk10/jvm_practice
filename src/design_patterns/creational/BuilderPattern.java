package design_patterns.creational;

public class BuilderPattern {
    public static void main(String[] args) {
        Logger logger = Logger.Builder.getBuilder()
                .setLogType("Debug")
                .setEvent("Event Performed")
                .setTimestamp(System.currentTimeMillis())
                .build();

        System.out.println(logger);
    }
}


class Logger {
    private String event;
    private String logType;
    private long timestamp;

    public String getEvent() {
        return event;
    }

    public String getLogType() {
        return logType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Logger(Builder builder) {
        this.event = builder.event;
        this.logType = builder.logType;
        this.timestamp = builder.timestamp;
    }

    static class Builder {
        private String event;
        private String logType;
        private long timestamp;

        private Builder() {
        }

        public static Builder getBuilder() {
            return new Builder();
        }

        public Builder setEvent(String event) {
            this.event = event;
            return this;
        }

        public Builder setLogType(String logType) {
            this.logType = logType;
            return this;
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Logger build() {
            return new Logger(this);
        }
    }

    @Override
    public String toString() {
        return "Logger{" +
                "event='" + event + '\'' +
                ", logType='" + logType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
